package dev.pokemondamage.model

/** The single-hit API returns one hit, its exact distribution and percentages of maximum HP. */
data class DamageResult(val hit: HitResult, val referenceHp: Int) {
    init {
        requireInput(referenceHp in 1..999, "referenceHp", ValidationCode.OUT_OF_RANGE)
    }

    val distribution: DamageDistribution
        get() = hit.distribution

    val min: Int
        get() = distribution.min.intValueExact()

    val max: Int
        get() = distribution.max.intValueExact()

    val minPercent: Double
        get() = min * 100.0 / referenceHp

    val maxPercent: Double
        get() = max * 100.0 / referenceHp
}
