package dev.pokemondamage.math

import dev.pokemondamage.model.ModifierStage

/** Final single-hit arithmetic after power, stats, weather and critical-hit modifiers. */
internal object DamageRoll {
    fun calculate(
        baseDamage: Int,
        randomPercent: Int,
        effectiveness: Double,
        burned: Boolean,
        stab: Int,
        finalModifier: Int,
    ): Int =
        calculateTraced(baseDamage, randomPercent, effectiveness, burned, stab, finalModifier).value

    fun calculateTraced(
        baseDamage: Int,
        randomPercent: Int,
        effectiveness: Double,
        burned: Boolean,
        stab: Int,
        finalModifier: Int,
    ): TracedValue {
        val randomDamage =
            (BattleMath.unsigned32(baseDamage.toLong() * randomPercent) / 100).toInt()
        val random =
            TracedValue(baseDamage, emptyList()).step(
                "Random",
                ModifierStage.DAMAGE,
                randomPercent.toLong(),
                100,
                randomDamage,
            )
        val sameType =
            if (stab != BattleMath.UNIT) {
                random.step(
                    "STAB",
                    ModifierStage.DAMAGE,
                    stab.toLong(),
                    4096,
                    BattleMath.modifyDamage(random.value, stab),
                )
            } else {
                random
            }
        // The chart and overrides produce exact binary fractions, recorded as an exact ratio.
        val denominator =
            if (effectiveness > 0 && effectiveness < 1) (1 / effectiveness).toLong() else 1
        val typeDamage = BattleMath.unsigned32((sameType.value * effectiveness).toLong()).toInt()
        val type =
            sameType.step(
                "Type",
                ModifierStage.DAMAGE,
                (effectiveness * denominator).toLong(),
                denominator,
                typeDamage,
            )
        val burn =
            if (burned) {
                type.step("Burn", ModifierStage.DAMAGE, 2048, 4096, type.value / 2)
            } else {
                type
            }
        val final =
            burn.step(
                "FinalModifiers",
                ModifierStage.DAMAGE,
                finalModifier.toLong(),
                4096,
                BattleMath.modifyDamage(burn.value, finalModifier),
            )
        val damage = if (effectiveness == 0.0) 0 else BattleMath.unsigned16(maxOf(1, final.value))
        return TracedValue(damage, final.trace)
    }
}
