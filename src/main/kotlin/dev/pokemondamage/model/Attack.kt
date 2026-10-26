package dev.pokemondamage.model

import java.math.BigInteger
import java.util.Collections

/** 1発ごとの固定ダメージ分布を順に保持する。命中数0は外れを表す。 */
class Attack(
    val turn: Long,
    hits: List<DamageDistribution>,
    hitCounts: Map<Int, BigInteger>,
    conditionalHitCounts: Map<Int, BigInteger>? = null,
) {
    val hits: List<DamageDistribution> = java.util.List.copyOf(hits)
    val hitCounts: Map<Int, BigInteger> = Collections.unmodifiableMap(hitCounts.toSortedMap())

    /** 命中判定成功を条件とした命中回数。1発ごとに独立判定する場合は保持しない。 */
    val conditionalHitCounts: Map<Int, BigInteger>? =
        conditionalHitCounts?.let {
            Collections.unmodifiableMap(it.toSortedMap())
        }

    init {
        val checks = InputChecks()
        checks.require(turn >= 1, "turn", ValidationCode.OUT_OF_RANGE)
        checks.require(this.hits.isNotEmpty(), "hits", ValidationCode.REQUIRED)
        validateCounts(checks, this.hitCounts, 0, this.hits.size, "hitCounts")
        this.conditionalHitCounts?.let {
            validateCounts(checks, it, 1, this.hits.size, "conditionalHitCounts")
        }
        checks.finish()
    }

    override fun equals(other: Any?): Boolean =
        other is Attack &&
            turn == other.turn &&
            hits == other.hits &&
            hitCounts == other.hitCounts &&
            conditionalHitCounts == other.conditionalHitCounts

    override fun hashCode(): Int = listOf(turn, hits, hitCounts, conditionalHitCounts).hashCode()

    companion object {
        /** 命中率を正確な重みで表す。1発ごとの判定では最初に外れた時点で終了する。 */
        fun fromAccuracy(
            turn: Long,
            hits: List<DamageDistribution>,
            accuracyPercent: Int = 100,
            hitCountWeights: Map<Int, BigInteger> = mapOf(1 to BigInteger.ONE),
            accuracyMode: AccuracyMode = AccuracyMode.ONCE_PER_ATTACK,
        ): Attack {
            val checks = InputChecks()
            checks.require(turn >= 1, "turn", ValidationCode.OUT_OF_RANGE)
            checks.require(hits.isNotEmpty(), "hits", ValidationCode.REQUIRED)
            checks.require(
                accuracyPercent in 0..100,
                "accuracyPercent",
                ValidationCode.OUT_OF_RANGE,
            )
            validateCounts(checks, hitCountWeights, 1, hits.size, "hitCountWeights")
            checks.finish()
            val accuracy = accuracyPercent.toBigInteger()
            val miss = (100 - accuracyPercent).toBigInteger()
            val hundred = BigInteger.valueOf(100)
            val counts = sortedMapOf<Int, BigInteger>()

            fun add(
                count: Int,
                weight: BigInteger,
            ) {
                if (weight.signum() > 0) {
                    counts.merge(count, weight, BigInteger::add)
                }
            }
            if (accuracyMode == AccuracyMode.UNTIL_FIRST_MISS) {
                val maximum = hitCountWeights.keys.max()
                for ((maximumHits, weight) in hitCountWeights) {
                    for (count in 0 until maximumHits) {
                        add(
                            count,
                            weight * accuracy.pow(count) * miss * hundred.pow(maximum - count - 1),
                        )
                    }
                    add(
                        maximumHits,
                        weight * accuracy.pow(maximumHits) * hundred.pow(maximum - maximumHits),
                    )
                }
            } else {
                for ((count, weight) in hitCountWeights) {
                    add(0, weight * miss)
                    add(count, weight * accuracy)
                }
            }
            val divisor = counts.values.reduce(BigInteger::gcd)
            return Attack(
                turn,
                hits,
                counts.mapValues { (_, weight) -> weight / divisor },
                if (accuracyMode == AccuracyMode.UNTIL_FIRST_MISS) null else hitCountWeights,
            )
        }

        private fun validateCounts(
            checks: InputChecks,
            counts: Map<Int, BigInteger>,
            minimum: Int,
            maximum: Int,
            path: String,
        ) {
            checks.require(counts.isNotEmpty(), path, ValidationCode.REQUIRED)
            for ((count, weight) in counts.toSortedMap()) {
                checks.require(
                    count in minimum..maximum,
                    "$path[$count]",
                    ValidationCode.OUT_OF_RANGE,
                )
                checks.require(
                    weight.signum() > 0,
                    "$path[$count].weight",
                    ValidationCode.OUT_OF_RANGE,
                )
            }
        }
    }
}
