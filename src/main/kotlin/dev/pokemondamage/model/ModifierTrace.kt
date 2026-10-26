package dev.pokemondamage.model

/** An exact rational modifier with the intermediate values at its point of application. */
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
