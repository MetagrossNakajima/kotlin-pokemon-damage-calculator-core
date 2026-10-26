package dev.pokemondamage.model

import java.math.BigInteger
import java.util.Collections

/** 整数の重みと任意精度のダメージを持つ、空でない変更不可の分布。 */
class DamageDistribution(
    weights: Map<BigInteger, BigInteger>,
) {
    val weights: Map<BigInteger, BigInteger> = Collections.unmodifiableMap(weights.toSortedMap())

    init {
        val checks = InputChecks()
        checks.require(this.weights.isNotEmpty(), "weights", ValidationCode.REQUIRED)
        for ((damage, weight) in this.weights) {
            checks.require(
                damage.signum() >= 0,
                "weights[$damage].damage",
                ValidationCode.OUT_OF_RANGE,
            )
            checks.require(
                weight.signum() > 0,
                "weights[$damage].weight",
                ValidationCode.OUT_OF_RANGE,
            )
        }
        checks.finish()
    }

    val totalWeight: BigInteger = this.weights.values.fold(BigInteger.ZERO, BigInteger::add)
    val min: BigInteger = this.weights.keys.first()
    val max: BigInteger = this.weights.keys.last()

    fun knockoutProbability(hp: BigInteger): ExactProbability {
        requireInput(hp.signum() >= 0, "hp", ValidationCode.OUT_OF_RANGE)
        val knockoutWeight =
            weights.entries
                .filter { (damage, _) -> damage >= hp }
                .fold(BigInteger.ZERO) { total, (_, weight) -> total + weight }
        return ExactProbability(knockoutWeight, totalWeight)
    }

    override fun equals(other: Any?): Boolean =
        other is DamageDistribution && weights == other.weights

    override fun hashCode(): Int = weights.hashCode()

    override fun toString(): String = "DamageDistribution($weights)"

    companion object {
        /** 各乱数は等確率とし、同じダメージが複数回現れた場合もその回数を保持する。 */
        fun fromRolls(rolls: Iterable<Int>): DamageDistribution {
            val weights = sortedMapOf<BigInteger, BigInteger>()
            for (roll in rolls) {
                val damage = BigInteger.valueOf(roll.toLong())
                weights[damage] = weights.getOrDefault(damage, BigInteger.ZERO) + BigInteger.ONE
            }
            return DamageDistribution(weights)
        }
    }
}
