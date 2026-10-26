package dev.pokemondamage.model

import java.math.BigInteger

/**
 * Exact final HP, executed attack damage (including overkill), and accuracy-inclusive KO
 * probability.
 */
class CombinedDamageResult(
    val referenceHp: Int,
    val finalHp: DamageDistribution,
    val attackDamage: DamageDistribution,
    val knockout: ExactProbability,
    val ko: KoInfo,
    finalStates: List<WeightedBattleState>,
) {
    val finalStates: List<WeightedBattleState> = java.util.List.copyOf(finalStates)
    val min: BigInteger
        get() = attackDamage.min

    val max: BigInteger
        get() = attackDamage.max
}
