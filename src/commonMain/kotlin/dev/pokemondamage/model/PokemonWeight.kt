package dev.pokemondamage.model

import kotlin.jvm.JvmInline
import kotlin.math.roundToInt

/** 重さを0.1kg単位の整数で保持する。 */
@JvmInline
value class PokemonWeight(
    val hectograms: Int,
) {
    init {
        requireInput(hectograms in 1..9999, "value", ValidationCode.OUT_OF_RANGE)
    }

    val kilograms: Double
        get() = hectograms / 10.0

    companion object {
        fun fromKilograms(kilograms: Double): PokemonWeight {
            requireInput(
                kilograms.isFinite() && kilograms >= 0.1 && kilograms < 1000,
                "value",
                ValidationCode.OUT_OF_RANGE,
            )
            val hectograms = (kilograms * 10).roundToInt()
            requireInput(hectograms / 10.0 == kilograms, "value", ValidationCode.OUT_OF_RANGE)
            return PokemonWeight(hectograms)
        }
    }
}
