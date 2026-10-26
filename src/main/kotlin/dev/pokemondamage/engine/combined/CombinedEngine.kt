package dev.pokemondamage.engine.combined

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
import java.math.BigInteger

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
                val shared = needsConditional && current.branches === current.conditional
                val sameCounts =
                    shared && attack.hitCounts.keys == attack.conditionalHitCounts!!.keys
                val sharedCounts = if (shared && !sameCounts) attack.conditionalHitCounts else null
                val result =
                    convolution.apply(
                        current.branches,
                        attack,
                        sharedConditionalCounts = sharedCounts,
                    )
                if (result is Calculation.Failure) {
                    return result
                }
                val value = (result as Calculation.Success).value
                val conditional =
                    when {
                        !needsConditional -> {
                            current.conditional
                        }

                        shared -> {
                            if (sameCounts) value.actual else value.conditional!!
                        }

                        else -> {
                            val conditionalResult =
                                convolution.apply(
                                    current.conditional,
                                    attack,
                                    attack.conditionalHitCounts!!,
                                    trackAttackDamage = false,
                                )
                            if (conditionalResult is Calculation.Failure) {
                                return conditionalResult
                            }
                            (conditionalResult as Calculation.Success).value.actual
                        }
                    }
                val endsTurn =
                    index == request.attacks.lastIndex ||
                        request.attacks[index + 1].turn != attack.turn
                val afterTurn =
                    if (endsTurn) {
                        endTurn(
                            value.actual,
                            turnEnd,
                            attack.turn,
                        )
                    } else {
                        value.actual
                    }
                val conditionalAfterTurn =
                    when {
                        !endsTurn || !needsConditional -> conditional
                        value.actual === conditional -> afterTurn
                        else -> endTurn(conditional, turnEnd, attack.turn)
                    }
                val possible =
                    if (needsConditional && current.possible == null &&
                        conditionalAfterTurn.keys.any { it.hp == 0 }
                    ) {
                        index + 1
                    } else {
                        current.possible
                    }
                val guaranteed =
                    if (needsConditional && conditionalAfterTurn.keys.all { it.hp == 0 }) {
                        index + 1
                    } else {
                        current.guaranteed
                    }
                val conditionalSize = if (needsConditional) conditionalAfterTurn.size else 0
                val operations = afterTurn.size.toLong() + conditionalSize
                if (!budget.spend(operations, maxOf(afterTurn.size, conditionalSize))) {
                    return failure()
                }
                AttackProgress(afterTurn, conditionalAfterTurn, possible, guaranteed)
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

    private fun endTurn(
        branches: Map<BattleProgress, BigInteger>,
        turnEnd: TurnEnd,
        turn: Long,
    ): Map<BattleProgress, BigInteger> {
        val merged = linkedMapOf<BattleProgress, BigInteger>()
        for ((state, weight) in branches) {
            merged.merge(
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
                weights.merge(select(state), weight, BigInteger::add)
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
