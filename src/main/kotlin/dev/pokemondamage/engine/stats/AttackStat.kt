package dev.pokemondamage.engine.stats

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.*
import dev.pokemondamage.model.*

internal object AttackStat {
    fun calculate(context: DamageContext, critical: Boolean): TracedValue {
        val source =
            if (context.move.original.id == MoveId("FoulPlay")) context.defender
            else context.attacker
        val (raw, stage) =
            when {
                context.move.original.id == MoveId("BodyPress") ->
                    source.stats.defense to
                        if (FieldEffect.WONDER_ROOM in context.field.effects)
                            source.stages.specialDefense
                        else source.stages.defense
                context.physical -> source.stats.attack to source.stages.attack
                else -> source.stats.specialAttack to source.stages.specialAttack
            }
        val criticalStage = if (critical) maxOf(0, stage) else stage
        val effectiveStage =
            if (context.defenderAbility == AbilityId("Unaware")) 0 else criticalStage
        var value = BattleMath.rankedStat(raw, effectiveStage)
        val trace =
            mutableListOf(
                ModifierTrace(
                    "Rank",
                    ModifierStage.ATTACK,
                    value.toLong(),
                    raw.toLong(),
                    raw.toLong(),
                    value.toLong(),
                ),
            )
        if (context.attackerAbility == AbilityId("Hustle") && context.physical) {
            val before = value
            value = BattleMath.modify(value, 6144)
            trace +=
                ModifierTrace(
                    "Hustle",
                    ModifierStage.ATTACK,
                    6144,
                    4096,
                    before.toLong(),
                    value.toLong(),
                )
        }
        val result = AttackModifiers.calculate(context).apply(value, ModifierStage.ATTACK)
        return TracedValue(result.value, trace + result.trace)
    }
}
