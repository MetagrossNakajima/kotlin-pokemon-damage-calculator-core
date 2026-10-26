package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.*
import java.math.BigInteger

internal data class AttackOutcomes(
    val actual: Map<BattleProgress, BigInteger>,
    val conditional: Map<BattleProgress, BigInteger>?,
)

/**
 * Computes shared hit prefixes once, then scales every hit-count outcome to a common denominator.
 */
internal class AttackConvolution(
    private val health: HealthEvents,
    private val budget: CalculationBudget,
) {
    fun apply(
        branches: Map<BattleProgress, BigInteger>,
        attack: Attack,
        counts: Map<Int, BigInteger> = attack.hitCounts,
        sharedConditionalCounts: Map<Int, BigInteger>? = null,
        trackAttackDamage: Boolean = true,
    ): Calculation<AttackOutcomes> {
        val actualMaximum = counts.keys.max()
        val conditionalMaximum = sharedConditionalCounts?.keys?.max() ?: 0
        val maximum = maxOf(actualMaximum, conditionalMaximum)
        val denominators = mutableListOf(BigInteger.ONE)
        for (hit in attack.hits.take(maximum)) denominators += denominators.last() * hit.totalWeight
        val actual = linkedMapOf<BattleProgress, BigInteger>()
        val conditional = linkedMapOf<BattleProgress, BigInteger>()
        var current = branches
        var hitIndex = 0
        while (true) {
            val countWeight = counts[hitIndex]
            if (
                countWeight != null &&
                    !collect(
                        actual,
                        current,
                        countWeight * (denominators[actualMaximum] / denominators[hitIndex]),
                        trackAttackDamage,
                    )
            )
                return failure()
            val conditionalWeight = sharedConditionalCounts?.get(hitIndex)
            if (
                conditionalWeight != null &&
                    !collect(
                        conditional,
                        current,
                        conditionalWeight *
                            (denominators[conditionalMaximum] / denominators[hitIndex]),
                        false,
                    )
            )
                return failure()
            if (hitIndex == maximum) break
            val hit = attack.hits[hitIndex]
            val next = linkedMapOf<BattleProgress, BigInteger>()
            for ((state, weight) in current) {
                if (state.hp == 0) {
                    next.merge(state, weight * hit.totalWeight, BigInteger::add)
                    if (!budget.spend(1, next.size)) return failure()
                } else {
                    for ((damage, rollWeight) in hit.weights) {
                        val advanced = health.damage(state, damage, attack.turn, trackAttackDamage)
                        next.merge(advanced, weight * rollWeight, BigInteger::add)
                        if (!budget.spend(1, next.size)) return failure()
                    }
                }
            }
            current = next
            hitIndex++
        }
        return Calculation.Success(
            AttackOutcomes(actual, if (sharedConditionalCounts == null) null else conditional),
        )
    }

    private fun collect(
        target: MutableMap<BattleProgress, BigInteger>,
        prefix: Map<BattleProgress, BigInteger>,
        scale: BigInteger,
        trackDamage: Boolean,
    ): Boolean {
        for ((state, weight) in prefix) {
            target.merge(
                if (trackDamage) state else state.copy(attackDamage = BigInteger.ZERO),
                weight * scale,
                BigInteger::add,
            )
            if (!budget.spend(1, target.size)) return false
        }
        return true
    }

    private fun failure() = Calculation.Failure(FailureKind.COMPLEXITY_EXCEEDED, "distribution")
}
