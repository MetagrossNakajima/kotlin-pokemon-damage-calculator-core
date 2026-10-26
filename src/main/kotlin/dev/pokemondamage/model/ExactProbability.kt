package dev.pokemondamage.model

import java.math.BigInteger

/** An exact probability whose floating-point view also preserves subnormal values. */
data class ExactProbability(val weight: BigInteger, val totalWeight: BigInteger) {
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
            if (weight.signum() == 0) return 0.0
            var exponent = weight.bitLength() - totalWeight.bitLength()
            val alignment = maxOf(0, -exponent)
            if (weight.shiftLeft(alignment) < totalWeight.shiftLeft(exponent + alignment))
                exponent--
            val shift = (52 - exponent).coerceIn(0, 1074)
            val (quotient, remainder) = weight.shiftLeft(shift).divideAndRemainder(totalWeight)
            val comparison = remainder.shiftLeft(1).compareTo(totalWeight)
            val rounded =
                if (comparison > 0 || comparison == 0 && quotient.testBit(0)) {
                    quotient + BigInteger.ONE
                } else {
                    quotient
                }
            return Math.scalb(rounded.toDouble(), -shift)
        }
}
