package dev.pokemondamage.model

import java.math.BigInteger

/** 攻撃は1ターン目から順に指定する。同じターンに複数回攻撃できるが、ターンは飛ばせない。 */
class CombinedDamageRequest(
    val defender: PokemonState,
    attacks: List<Attack>,
    val field: BattleField = BattleField(),
    val setup: BattleSetup = BattleSetup(),
    val limits: CalculationLimits = CalculationLimits(),
) {
    val attacks: List<Attack> = java.util.List.copyOf(attacks)

    init {
        val checks = InputChecks()
        checks.require(this.attacks.isNotEmpty(), "attacks", ValidationCode.REQUIRED)
        this.attacks.forEachIndexed { index, attack ->
            val ordered =
                if (index == 0) {
                    attack.turn == 1L
                } else {
                    attack.turn - this.attacks[index - 1].turn in 0L..1L
                }
            checks.require(ordered, "attacks[$index].turn", ValidationCode.INCONSISTENT)
        }
        checks.finish()
    }

    override fun equals(other: Any?): Boolean =
        other is CombinedDamageRequest &&
            defender == other.defender &&
            attacks == other.attacks &&
            field == other.field &&
            setup == other.setup &&
            limits == other.limits

    override fun hashCode(): Int = listOf(defender, attacks, field, setup, limits).hashCode()

    companion object {
        /** 途中で外れても、固定の攻撃分布を使って4ターン連続で攻撃する。 */
        fun repeatSingleHit(
            firstHit: DamageDistribution,
            defender: PokemonState,
            subsequentHit: DamageDistribution = firstHit,
            accuracyPercent: Int = 100,
            hitCounts: Map<Int, BigInteger>? = null,
            field: BattleField = BattleField(),
            setup: BattleSetup = BattleSetup(),
            limits: CalculationLimits = CalculationLimits(),
        ): CombinedDamageRequest =
            CombinedDamageRequest(
                defender,
                (1L..4L).map { turn ->
                    val hits = listOf(if (turn == 1L) firstHit else subsequentHit)
                    if (hitCounts == null) {
                        Attack.fromAccuracy(turn, hits, accuracyPercent)
                    } else {
                        Attack(turn, hits, hitCounts, mapOf(1 to BigInteger.ONE))
                    }
                },
                field,
                setup,
                limits,
            )
    }
}
