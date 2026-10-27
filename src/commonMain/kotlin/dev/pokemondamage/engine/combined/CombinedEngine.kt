package dev.pokemondamage.engine.combined

import dev.pokemondamage.collections.mergeWeight
import dev.pokemondamage.math.BigInteger
import dev.pokemondamage.math.toBigInteger
import dev.pokemondamage.model.Attack
import dev.pokemondamage.model.BattleState
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult
import dev.pokemondamage.model.DamageDistribution
import dev.pokemondamage.model.ExactProbability
import dev.pokemondamage.model.FailureKind
import dev.pokemondamage.model.KoInfo
import dev.pokemondamage.model.KoStatus
import dev.pokemondamage.model.WeightedBattleState

/** 固定の攻撃分布を順に適用する。分岐後のHPによるダメージ再計算は行わない。 */
internal object CombinedEngine {
    fun calculate(request: CombinedDamageRequest): Calculation<CombinedDamageResult> {
        val budget = CalculationBudget(request.limits)
        val inputCost =
            request.setup.initialDamages.size
                .toLong() +
                request.attacks.sumOf { attack ->
                    attack.hits.sumOf { it.weights.size.toLong() } +
                        attack.hitCounts.size +
                        (attack.conditionalHitCounts?.size ?: 0)
                }
        if (!budget.spend(inputCost, 1)) {
            return failure()
        }
        val defender = request.defender
        val health = HealthEvents(defender, request.field)
        val turnEnd = TurnEnd(defender, request.field)
        val convolution = AttackConvolution(health, budget)
        val initial =
            health.setup(
                BattleProgress(
                    defender.hp,
                    defender.itemConsumed,
                    defender.toxicCounter,
                    defender.cudChewTurn,
                ),
                request.setup,
            )
        val branches = mapOf(initial to BigInteger.ONE)
        val applicable = request.attacks.all { it.conditionalHitCounts != null }
        val initialKnockout = if (applicable && initial.hp == 0) 0 else null
        val progress =
            AttackProgress(
                branches,
                if (applicable) branches else emptyMap(),
                initialKnockout,
                initialKnockout,
            )
        val completed =
            request.attacks.withIndex().fold(progress) { current, (index, attack) ->
                val needsConditional = applicable && current.guaranteed == null
                val distributions =
                    when (
                        val result =
                            applyAttack(
                                current,
                                attack,
                                needsConditional,
                                convolution,
                            )
                    ) {
                        is Calculation.Failure -> return result
                        is Calculation.Success -> result.value
                    }
                val endsTurn =
                    index == request.attacks.lastIndex ||
                        request.attacks[index + 1].turn != attack.turn
                val afterTurn =
                    finishTurn(distributions, needsConditional, endsTurn, turnEnd, attack.turn)
                val conditionalSize = if (needsConditional) afterTurn.conditional.size else 0
                val operations = afterTurn.actual.size.toLong() + conditionalSize
                if (!budget.spend(operations, maxOf(afterTurn.actual.size, conditionalSize))) {
                    return failure()
                }
                updateKnockout(current, afterTurn, needsConditional, index + 1)
            }
        return Calculation.Success(
            result(
                request,
                completed.branches,
                applicable,
                completed.possible,
                completed.guaranteed,
            ),
        )
    }

    private class AttackProgress(
        val branches: Map<BattleProgress, BigInteger>,
        val conditional: Map<BattleProgress, BigInteger>,
        val possible: Int?,
        val guaranteed: Int?,
    )

    private class AttackDistributions(
        val actual: Map<BattleProgress, BigInteger>,
        val conditional: Map<BattleProgress, BigInteger>,
    )

    /** 同じ入力分布なら畳み込みを共有し、必要な場合だけ条件付き分布を別に計算する。 */
    private fun applyAttack(
        current: AttackProgress,
        attack: Attack,
        needsConditional: Boolean,
        convolution: AttackConvolution,
    ): Calculation<AttackDistributions> {
        val shared = needsConditional && current.branches === current.conditional
        val sameCounts = shared && attack.hitCounts.keys == attack.conditionalHitCounts!!.keys
        val sharedCounts = if (shared && !sameCounts) attack.conditionalHitCounts else null
        val outcomes =
            when (
                val result =
                    convolution.apply(
                        current.branches,
                        attack,
                        sharedConditionalCounts = sharedCounts,
                    )
            ) {
                is Calculation.Failure -> return result
                is Calculation.Success -> result.value
            }
        val conditional =
            when {
                !needsConditional -> {
                    current.conditional
                }

                shared -> {
                    if (sameCounts) outcomes.actual else outcomes.conditional!!
                }

                else -> {
                    when (
                        val result =
                            convolution.apply(
                                current.conditional,
                                attack,
                                attack.conditionalHitCounts!!,
                                trackAttackDamage = false,
                            )
                    ) {
                        is Calculation.Failure -> return result
                        is Calculation.Success -> result.value.actual
                    }
                }
            }
        return Calculation.Success(AttackDistributions(outcomes.actual, conditional))
    }

    /** 共有中の分布にはターン終了処理を一度だけ適用し、共有関係を維持する。 */
    private fun finishTurn(
        distributions: AttackDistributions,
        needsConditional: Boolean,
        endsTurn: Boolean,
        turnEnd: TurnEnd,
        turn: Long,
    ): AttackDistributions {
        val actual =
            if (endsTurn) endTurn(distributions.actual, turnEnd, turn) else distributions.actual
        val conditional =
            when {
                !endsTurn || !needsConditional -> distributions.conditional
                distributions.actual === distributions.conditional -> actual
                else -> endTurn(distributions.conditional, turnEnd, turn)
            }
        return AttackDistributions(actual, conditional)
    }

    private fun updateKnockout(
        current: AttackProgress,
        distributions: AttackDistributions,
        needsConditional: Boolean,
        attackCount: Int,
    ): AttackProgress {
        val possible =
            if (needsConditional && current.possible == null &&
                distributions.conditional.keys.any { it.hp == 0 }
            ) {
                attackCount
            } else {
                current.possible
            }
        val guaranteed =
            if (needsConditional && distributions.conditional.keys.all { it.hp == 0 }) {
                attackCount
            } else {
                current.guaranteed
            }
        return AttackProgress(distributions.actual, distributions.conditional, possible, guaranteed)
    }

    private fun endTurn(
        branches: Map<BattleProgress, BigInteger>,
        turnEnd: TurnEnd,
        turn: Long,
    ): Map<BattleProgress, BigInteger> {
        val merged = linkedMapOf<BattleProgress, BigInteger>()
        for ((state, weight) in branches) {
            merged.mergeWeight(
                turnEnd.apply(state, turn),
                weight,
                BigInteger::add,
            )
        }
        return merged
    }

    private fun result(
        request: CombinedDamageRequest,
        branches: Map<BattleProgress, BigInteger>,
        applicable: Boolean,
        possible: Int?,
        guaranteed: Int?,
    ): CombinedDamageResult {
        fun distribution(select: (BattleProgress) -> BigInteger): DamageDistribution {
            val weights = linkedMapOf<BigInteger, BigInteger>()
            for ((state, weight) in branches) {
                weights.mergeWeight(select(state), weight, BigInteger::add)
            }
            return DamageDistribution(weights)
        }
        val hp = distribution { it.hp.toBigInteger() }
        return CombinedDamageResult(
            request.defender.stats.hp,
            hp,
            distribution { it.attackDamage },
            ExactProbability(hp.weights[BigInteger.ZERO] ?: BigInteger.ZERO, hp.totalWeight),
            KoInfo(
                when {
                    !applicable -> KoStatus.NOT_APPLICABLE
                    guaranteed == null -> KoStatus.LIMIT_REACHED
                    else -> KoStatus.RESOLVED
                },
                request.attacks.size,
                possible,
                guaranteed,
            ),
            branches.map { (state, weight) ->
                WeightedBattleState(
                    BattleState(
                        request.defender,
                        state.hp,
                        state.itemConsumed,
                        state.toxicCounter,
                        state.cudChewTurn,
                    ),
                    weight,
                )
            },
        )
    }

    private fun failure() = Calculation.Failure(FailureKind.COMPLEXITY_EXCEEDED, "distribution")
}
