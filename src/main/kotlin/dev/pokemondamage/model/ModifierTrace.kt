package dev.pokemondamage.model

/** 正確な分数の補正値と、適用時の計算途中の値。 */
data class ModifierTrace(
    val id: String,
    val stage: ModifierStage,
    val numerator: Long,
    val denominator: Long,
    val before: Long,
    val after: Long,
)

enum class ModifierStage {
    BASE_POWER,
    POWER,
    POWER_MODIFIER,
    ATTACK,
    ATTACK_MODIFIER,
    DEFENSE,
    DEFENSE_MODIFIER,
    DAMAGE,
    DAMAGE_MODIFIER,
}
