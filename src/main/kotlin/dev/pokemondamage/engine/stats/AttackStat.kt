package dev.pokemondamage.engine.stats

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.math.TracedValue
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.StatStage

internal object AttackStat {
    fun calculate(
        context: DamageContext,
        critical: Boolean,
    ): TracedValue {
        // イカサマ
        val source =
            if (context.move.original.id == MoveId("FoulPlay")) {
                context.defender
            } else {
                context.attacker
            }
        val (raw, stage) =
            when {
                // ボディプレス
                context.move.original.id == MoveId("BodyPress") -> {
                    // ワンダールーム
                    val defenseStage =
                        if (FieldEffect.WONDER_ROOM in context.field.effects) {
                            source.stages.specialDefense
                        } else {
                            source.stages.defense
                        }
                    source.stats.defense to defenseStage
                }

                context.physical -> {
                    source.stats.attack to source.stages.attack
                }

                else -> {
                    source.stats.specialAttack to source.stages.specialAttack
                }
            }
        // 急所では攻撃側のマイナスランクを無視
        val criticalStage = if (critical) stage.ignoringNegative() else stage
        // てんねん
        val effectiveStage =
            if (context.defenderAbility ==
                AbilityId("Unaware")
            ) {
                StatStage.NEUTRAL
            } else {
                criticalStage
            }
        val value = BattleMath.rankedStat(raw, effectiveStage)
        val trace =
            listOf(
                ModifierTrace(
                    "Rank",
                    ModifierStage.ATTACK,
                    value.toLong(),
                    raw.toLong(),
                    raw.toLong(),
                    value.toLong(),
                ),
            )
        val ranked = TracedValue(value, trace)
        // はりきり
        val adjusted =
            if (context.attackerAbility == AbilityId("Hustle") && context.physical) {
                ranked.step(
                    "Hustle",
                    ModifierStage.ATTACK,
                    6144,
                    4096,
                    BattleMath.modify(value, 6144),
                )
            } else {
                ranked
            }
        val result = AttackModifiers.calculate(context).apply(adjusted.value, ModifierStage.ATTACK)
        return TracedValue(result.value, adjusted.trace + result.trace)
    }
}
