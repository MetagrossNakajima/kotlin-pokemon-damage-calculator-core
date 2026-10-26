package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.math.TracedValue
import dev.pokemondamage.model.*

/** Base damage followed by spread, child hit, weather and critical modifiers in battle order. */
internal object PreRandomDamage {
    fun calculate(
        context: DamageContext,
        power: Int,
        attack: Int,
        defense: Int,
        critical: Boolean,
    ): TracedValue {
        var damage = BattleMath.baseDamage(power, attack, defense)
        val trace =
            mutableListOf(
                ModifierTrace(
                    "BaseDamage",
                    ModifierStage.DAMAGE,
                    1,
                    1,
                    damage.toLong(),
                    damage.toLong(),
                ),
            )
        fun apply(id: String, multiplier: Int) {
            val before = damage
            damage = BattleMath.modifyDamage(damage, multiplier)
            trace +=
                ModifierTrace(
                    id,
                    ModifierStage.DAMAGE,
                    multiplier.toLong(),
                    4096,
                    before.toLong(),
                    damage.toLong(),
                )
        }
        if (context.field.format == BattleFormat.DOUBLE && context.move.original.spread)
            apply("Spread", 3072)
        if (context.request.hitIndex == 1L && ParentalBond.applies(context))
            apply("ParentalBond", 1024)
        val weatherModifier = weatherModifier(context)
        if (weatherModifier != 4096) apply("Weather", weatherModifier)
        if (critical) {
            val before = damage
            damage = BattleMath.unsigned32(damage.toLong() * 3 / 2).toInt()
            trace +=
                ModifierTrace(
                    "Critical",
                    ModifierStage.DAMAGE,
                    6144,
                    4096,
                    before.toLong(),
                    damage.toLong(),
                )
        }
        return TracedValue(damage, trace)
    }

    private fun weatherModifier(context: DamageContext): Int {
        if (
            (context.weather == Weather.SUNLIGHT ||
                context.attackerAbility == AbilityId("MegaSol")) &&
                context.move.original.id == MoveId("HydroSteam") &&
                context.attackerItem != ItemId("UtilityUmbrella")
        )
            return 6144
        if (context.defenderItem == ItemId("UtilityUmbrella")) return 4096
        return when (context.weather) {
            Weather.SUNLIGHT ->
                when (context.move.type) {
                    TeraType.FIRE -> 6144
                    TeraType.WATER -> 2048
                    else -> 4096
                }
            Weather.RAIN ->
                when (context.move.type) {
                    TeraType.WATER -> 6144
                    TeraType.FIRE -> 2048
                    else -> 4096
                }
            else -> 4096
        }
    }
}
