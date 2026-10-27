package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.math.TracedValue
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleFormat
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather

/** 基礎ダメージに範囲技・おやこあいの2発目・天候・急所の順で補正を適用する。 */
internal object PreRandomDamage {
    fun calculate(
        context: DamageContext,
        power: Int,
        attack: Int,
        defense: Int,
        critical: Boolean,
    ): TracedValue {
        val baseDamage = BattleMath.baseDamage(power, attack, defense)
        val base =
            TracedValue(
                baseDamage,
                listOf(
                    ModifierTrace(
                        "BaseDamage",
                        ModifierStage.DAMAGE,
                        1,
                        1,
                        baseDamage.toLong(),
                        baseDamage.toLong(),
                    ),
                ),
            )
        // ダブルバトルの範囲技補正
        val spread =
            if (context.field.format == BattleFormat.DOUBLE &&
                context.move.original.spread
            ) {
                apply(base, "Spread", 3072)
            } else {
                base
            }
        // おやこあい（2発目）
        val childHit =
            if (context.request.hitIndex == 1L && ParentalBond.applies(context)) {
                apply(spread, "ParentalBond", 1024)
            } else {
                spread
            }
        val weatherModifier = weatherModifier(context)
        val weather =
            if (weatherModifier != 4096) {
                apply(childHit, "Weather", weatherModifier)
            } else {
                childHit
            }
        // 急所補正
        return if (critical) {
            val damage = BattleMath.unsigned32(weather.value.toLong() * 3 / 2).toInt()
            weather.step("Critical", ModifierStage.DAMAGE, 6144, 4096, damage)
        } else {
            weather
        }
    }

    private fun apply(
        before: TracedValue,
        id: String,
        multiplier: Int,
    ): TracedValue =
        before.step(
            id,
            ModifierStage.DAMAGE,
            multiplier.toLong(),
            4096,
            BattleMath.modifyDamage(before.value, multiplier),
        )

    // 天候によるほのお･みず技の補正
    private fun weatherModifier(context: DamageContext): Int {
        // ハイドロスチームの晴れ補正
        if (
            (
                context.weather == Weather.SUNLIGHT ||
                    context.attackerAbility == AbilityId("MegaSol")
            ) &&
            context.move.original.id == MoveId("HydroSteam") &&
            context.attackerItem != ItemId("UtilityUmbrella")
        ) {
            return 6144
        }
        // ばんのうがさ
        if (context.defenderItem == ItemId("UtilityUmbrella")) {
            return 4096
        }
        return when (context.weather) {
            // 晴れ：ほのお1.5倍、みず0.5倍
            Weather.SUNLIGHT -> {
                when (context.move.type) {
                    TeraType.FIRE -> 6144
                    TeraType.WATER -> 2048
                    else -> 4096
                }
            }

            // 雨：みず1.5倍、ほのお0.5倍
            Weather.RAIN -> {
                when (context.move.type) {
                    TeraType.WATER -> 6144
                    TeraType.FIRE -> 2048
                    else -> 4096
                }
            }

            else -> {
                4096
            }
        }
    }
}
