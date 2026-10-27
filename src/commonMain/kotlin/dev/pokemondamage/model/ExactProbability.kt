package dev.pokemondamage.model

import dev.pokemondamage.math.BigInteger

/** 正確な確率を保持し、浮動小数点への変換時も非正規化数を保持する。 */
data class ExactProbability(
    val weight: BigInteger,
    val totalWeight: BigInteger,
) {
    init {
        val checks = InputChecks()
        checks.require(totalWeight.signum() > 0, "totalWeight", ValidationCode.OUT_OF_RANGE)
        checks.require(
            weight.signum() >= 0 && weight <= totalWeight,
            "weight",
            ValidationCode.OUT_OF_RANGE,
        )
        checks.finish()
    }

    val guaranteed: Boolean
        get() = weight == totalWeight

    val probability: Double
        get() {
            if (weight.signum() == 0) {
                return 0.0
            }
            val estimatedExponent = weight.bitLength() - totalWeight.bitLength()
            val alignment = maxOf(0, -estimatedExponent)
            val exponent =
                if (weight.shiftLeft(alignment) <
                    totalWeight.shiftLeft(estimatedExponent + alignment)
                ) {
                    estimatedExponent - 1
                } else {
                    estimatedExponent
                }
            val shift = (52 - exponent).coerceIn(0, 1074)
            val (quotient, remainder) = weight.shiftLeft(shift).divideAndRemainder(totalWeight)
            val comparison = remainder.shiftLeft(1).compareTo(totalWeight)
            val rounded =
                if (comparison > 0 || (comparison == 0 && quotient.testBit(0))) {
                    quotient + BigInteger.ONE
                } else {
                    quotient
                }
            // Split the power of two so neither factor underflows before multiplication.
            // The rounded significand is exact; only the final product can be subnormal.
            return rounded.toDouble() * Double.fromBits((1023L - minOf(shift, 1022)) shl 52) *
                Double.fromBits((1023L - maxOf(0, shift - 1022)) shl 52)
        }
}
