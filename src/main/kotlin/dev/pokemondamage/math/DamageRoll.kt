package dev.pokemondamage.math

import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace

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
        var damage = baseDamage
        val trace = mutableListOf<ModifierTrace>()
        fun record(id: String, numerator: Long, denominator: Long, after: Int) {
            trace +=
                ModifierTrace(
                    id,
                    ModifierStage.DAMAGE,
                    numerator,
                    denominator,
                    damage.toLong(),
                    after.toLong(),
                )
            damage = after
        }
        record(
            "Random",
            randomPercent.toLong(),
            100,
            (BattleMath.unsigned32(damage.toLong() * randomPercent) / 100).toInt(),
        )
        if (stab != BattleMath.UNIT)
            record("STAB", stab.toLong(), 4096, BattleMath.modifyDamage(damage, stab))
        // The chart and overrides produce exact binary fractions, recorded as an exact ratio.
        val denominator =
            if (effectiveness > 0 && effectiveness < 1) (1 / effectiveness).toLong() else 1
        record(
            "Type",
            (effectiveness * denominator).toLong(),
            denominator,
            BattleMath.unsigned32((damage * effectiveness).toLong()).toInt(),
        )
        if (burned) record("Burn", 2048, 4096, damage / 2)
        record(
            "FinalModifiers",
            finalModifier.toLong(),
            4096,
            BattleMath.modifyDamage(damage, finalModifier),
        )
        return TracedValue(
            if (effectiveness == 0.0) 0 else BattleMath.unsigned16(maxOf(1, damage)),
            trace,
        )
    }
}
