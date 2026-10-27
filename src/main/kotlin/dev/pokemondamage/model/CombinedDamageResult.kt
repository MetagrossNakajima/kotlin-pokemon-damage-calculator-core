package dev.pokemondamage.model

import java.math.BigInteger

/** 最終HP・与えた攻撃ダメージ（残りHPを超えた分も含む）・命中率込みのひんし確率を正確に保持する。 */
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
