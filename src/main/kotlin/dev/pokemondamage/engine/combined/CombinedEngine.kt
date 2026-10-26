package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.*
import java.math.BigInteger

/** Runs fixed attack distributions; future damage is not recalculated from branch HP. */
internal object CombinedEngine {
    fun calculate(request: CombinedDamageRequest): Calculation<CombinedDamageResult> {
        val budget = CalculationBudget(request.limits)
        val inputCost =
            request.setup.initialDamages.size.toLong() +
                request.attacks.sumOf { attack ->
                    attack.hits.sumOf { it.weights.size.toLong() } +
                        attack.hitCounts.size +
                        (attack.conditionalHitCounts?.size ?: 0)
                }
        if (!budget.spend(inputCost, 1)) return failure()
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
        var branches = mapOf(initial to BigInteger.ONE)
        val applicable = request.attacks.all { it.conditionalHitCounts != null }
        var conditional = if (applicable) branches else emptyMap()
        var possible: Int? = if (applicable && initial.hp == 0) 0 else null
        var guaranteed = possible
        for ((index, attack) in request.attacks.withIndex()) {
            val needsConditional = applicable && guaranteed == null
            val shared = needsConditional && branches === conditional
            val sameCounts = shared && attack.hitCounts.keys == attack.conditionalHitCounts!!.keys
            val result =
                convolution.apply(
                    branches,
                    attack,
                    sharedConditionalCounts =
                        if (shared && !sameCounts) attack.conditionalHitCounts else null,
                )
            if (result is Calculation.Failure) return result
            val value = (result as Calculation.Success).value
            branches = value.actual
            if (needsConditional) {
                if (shared) {
                    conditional = if (sameCounts) branches else value.conditional!!
                } else {
                    val conditionalResult =
                        convolution.apply(
                            conditional,
                            attack,
                            attack.conditionalHitCounts!!,
                            trackAttackDamage = false,
                        )
                    if (conditionalResult is Calculation.Failure) return conditionalResult
                    conditional = (conditionalResult as Calculation.Success).value.actual
                }
            }
            if (
                index == request.attacks.lastIndex || request.attacks[index + 1].turn != attack.turn
            ) {
                val sharedTurnEnd = needsConditional && branches === conditional
                branches = endTurn(branches, turnEnd, attack.turn)
                if (needsConditional)
                    conditional =
                        if (sharedTurnEnd) branches else endTurn(conditional, turnEnd, attack.turn)
            }
            if (needsConditional) {
                if (conditional.keys.any { it.hp == 0 } && possible == null) possible = index + 1
                if (conditional.keys.all { it.hp == 0 }) guaranteed = index + 1
            }
            if (
                !budget.spend(
                    branches.size.toLong() + if (needsConditional) conditional.size else 0,
                    maxOf(branches.size, if (needsConditional) conditional.size else 0),
                )
            )
                return failure()
        }
        return Calculation.Success(result(request, branches, applicable, possible, guaranteed))
    }

    private fun endTurn(
        branches: Map<BattleProgress, BigInteger>,
        turnEnd: TurnEnd,
        turn: Long,
    ): Map<BattleProgress, BigInteger> {
        val merged = linkedMapOf<BattleProgress, BigInteger>()
        for ((state, weight) in branches) merged.merge(
            turnEnd.apply(state, turn),
            weight,
            BigInteger::add,
        )
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
            for ((state, weight) in branches) weights.merge(select(state), weight, BigInteger::add)
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
