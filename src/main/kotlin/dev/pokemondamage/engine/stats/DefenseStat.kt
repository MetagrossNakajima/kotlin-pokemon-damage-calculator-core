package dev.pokemondamage.engine.stats

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.math.TracedValue
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.StatStage
import dev.pokemondamage.model.Weather

internal object DefenseStat {
    fun calculate(
        context: DamageContext,
        critical: Boolean,
    ): TracedValue {
        val defender = context.defender
        val physical = context.physicalDefense
        val wonderRoom = FieldEffect.WONDER_ROOM in context.field.effects
        // Wonder Room swaps raw values; the selected defensive rank and modifiers stay in place.
        val raw =
            if (physical != wonderRoom) defender.stats.defense else defender.stats.specialDefense
        val stage = if (physical) defender.stages.defense else defender.stages.specialDefense
        val criticalStage = if (critical) stage.ignoringPositive() else stage
        val ignoreStage =
            context.attackerAbility == AbilityId("Unaware") ||
                context.move.original.id.value in rankIgnoringMoves
        val effectiveStage = if (ignoreStage) StatStage.NEUTRAL else criticalStage
        val value = BattleMath.rankedStat(raw, effectiveStage)
        val trace =
            listOf(
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
            (
                context.weather == Weather.SANDSTORM &&
                    PokemonType.ROCK in context.defenderTypes &&
                    !physical
            ) ||
                (
                    context.weather == Weather.SNOW &&
                        PokemonType.ICE in context.defenderTypes &&
                        physical
                )
        val ranked = TracedValue(value, trace)
        val adjusted =
            if (weatherBoost) {
                ranked.step(
                    "WeatherDefense",
                    ModifierStage.DEFENSE,
                    6144,
                    4096,
                    BattleMath.modify(value, 6144),
                )
            } else {
                ranked
            }
        val result =
            DefenseModifiers
                .calculate(
                    context,
                ).apply(adjusted.value, ModifierStage.DEFENSE)
        return TracedValue(result.value, adjusted.trace + result.trace)
    }

    private val rankIgnoringMoves = setOf("SacredSword", "ChipAway", "DarkestLariat")
}
