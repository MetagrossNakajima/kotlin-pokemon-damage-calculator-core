package dev.pokemondamage.engine.stats

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.*
import dev.pokemondamage.model.*

internal object DefenseStat {
    fun calculate(context: DamageContext, critical: Boolean): TracedValue {
        val defender = context.defender
        val physical = context.physicalDefense
        val wonderRoom = FieldEffect.WONDER_ROOM in context.field.effects
        // Wonder Room swaps raw values; the selected defensive rank and modifiers stay in place.
        val raw =
            if (physical != wonderRoom) defender.stats.defense else defender.stats.specialDefense
        val stage = if (physical) defender.stages.defense else defender.stages.specialDefense
        val criticalStage = if (critical) minOf(0, stage) else stage
        val ignoreStage =
            context.attackerAbility == AbilityId("Unaware") ||
                context.move.original.id.value in rankIgnoringMoves
        val effectiveStage = if (ignoreStage) 0 else criticalStage
        var value = BattleMath.rankedStat(raw, effectiveStage)
        val trace =
            mutableListOf(
                ModifierTrace(
                    "Rank",
                    ModifierStage.DEFENSE,
                    value.toLong(),
                    raw.toLong(),
                    raw.toLong(),
                    value.toLong(),
                ),
            )
        val weatherBoost =
            context.weather == Weather.SANDSTORM &&
                PokemonType.ROCK in context.defenderTypes &&
                !physical ||
                context.weather == Weather.SNOW &&
                    PokemonType.ICE in context.defenderTypes &&
                    physical
        if (weatherBoost) {
            val before = value
            value = BattleMath.modify(value, 6144)
            trace +=
                ModifierTrace(
                    "WeatherDefense",
                    ModifierStage.DEFENSE,
                    6144,
                    4096,
                    before.toLong(),
                    value.toLong(),
                )
        }
        val result = DefenseModifiers.calculate(context).apply(value, ModifierStage.DEFENSE)
        return TracedValue(result.value, trace + result.trace)
    }

    private val rankIgnoringMoves = setOf("SacredSword", "ChipAway", "DarkestLariat")
}
