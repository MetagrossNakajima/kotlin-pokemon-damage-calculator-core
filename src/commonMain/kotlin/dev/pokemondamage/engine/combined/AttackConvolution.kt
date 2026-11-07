package dev.pokemondamage.engine.combined

import dev.pokemondamage.collections.mergeWeight
import dev.pokemondamage.math.BigInteger
import dev.pokemondamage.model.Attack
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.FailureKind

internal data class AttackOutcomes(
    val actual: Map<BattleProgress, BigInteger>,
    val conditional: Map<BattleProgress, BigInteger>?,
)

/**
 * 共通する命中途中までの計算を再利用し、命中回数ごとの結果を共通の分母にそろえる。
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
        // 各命中回数の分布を共通の分母にそろえる
        val denominators =
            attack.hits.take(maximum).runningFold(BigInteger.ONE) { total, hit ->
                total * hit.totalWeight
            }
        val actual = linkedMapOf<BattleProgress, BigInteger>()
        val conditional = linkedMapOf<BattleProgress, BigInteger>()
        (0..maximum).fold(branches) { current, hitIndex ->
            val countWeight = counts[hitIndex]
            if (
                countWeight != null &&
                !collect(
                    actual,
                    current,
                    countWeight * (denominators[actualMaximum] / denominators[hitIndex]),
                    trackAttackDamage,
                )
            ) {
                return failure()
            }
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
            ) {
                return failure()
            }
            if (hitIndex == maximum) {
                return@fold current
            }
            val hit = attack.hits[hitIndex]
            val next = linkedMapOf<BattleProgress, BigInteger>()
            for ((state, weight) in current) {
                // ひんしの分岐はHPを固定し、残りの乱数の重みだけ反映
                if (state.hp == 0) {
                    next.mergeWeight(state, weight * hit.totalWeight, BigInteger::add)
                    if (!budget.spend(1, next.size)) {
                        return failure()
                    }
                } else {
                    for ((damage, rollWeight) in hit.weights) {
                        val advanced = health.damage(state, damage, attack.turn, trackAttackDamage)
                        // 同じ状態に到達した分岐の重みを合算
                        next.mergeWeight(advanced, weight * rollWeight, BigInteger::add)
                        if (!budget.spend(1, next.size)) {
                            return failure()
                        }
                    }
                }
            }
            next
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
            target.mergeWeight(
                if (trackDamage) state else state.copy(attackDamage = BigInteger.ZERO),
                weight * scale,
                BigInteger::add,
            )
            if (!budget.spend(1, target.size)) {
                return false
            }
        }
        return true
    }

    private fun failure() = Calculation.Failure(FailureKind.COMPLEXITY_EXCEEDED, "distribution")
}
