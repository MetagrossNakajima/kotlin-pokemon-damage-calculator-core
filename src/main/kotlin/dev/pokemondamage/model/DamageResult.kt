package dev.pokemondamage.model

/** 単発計算APIは、1発分の結果・正確な分布・最大HPに対する割合を返す。 */
data class DamageResult(
    /** 通常の結果。同値のシェルアームズでは特殊側の計算根拠。 */
    val hit: HitResult,
    val referenceHp: Int,
    /** 存在する場合、hit とそれぞれ50%の確率で選ばれる物理側の計算根拠。 */
    val alternativeHit: HitResult? = null,
) {
    init {
        requireInput(referenceHp in 1..999, "referenceHp", ValidationCode.OUT_OF_RANGE)
    }

    val distribution: DamageDistribution
        get() {
            val alternative = alternativeHit ?: return hit.distribution
            // 各分布の乱数数が異なる場合も、分類自体の確率は1/2ずつに保つ。
            val first = hit.distribution
            val second = alternative.distribution
            val divisor = first.totalWeight.gcd(second.totalWeight)
            val firstScale = second.totalWeight / divisor
            val secondScale = first.totalWeight / divisor
            val weights =
                first.weights
                    .mapValues { (_, weight) -> weight * firstScale }
                    .toMutableMap()
            for ((damage, weight) in second.weights) {
                weights.merge(damage, weight * secondScale, java.math.BigInteger::add)
            }
            return DamageDistribution(weights)
        }

    val min: Int
        get() = distribution.min.intValueExact()

    val max: Int
        get() = distribution.max.intValueExact()

    val minPercent: Double
        get() = min * 100.0 / referenceHp

    val maxPercent: Double
        get() = max * 100.0 / referenceHp
}
