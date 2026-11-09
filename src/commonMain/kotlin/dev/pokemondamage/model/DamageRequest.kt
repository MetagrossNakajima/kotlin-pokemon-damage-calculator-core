package dev.pokemondamage.model

data class DamageRequest(
    val attacker: PokemonState,
    val defender: PokemonState,
    val move: Move,
    val field: BattleField = BattleField(),
    val critical: Boolean = false,
    val hitIndex: Long = 0,
    /** Replaces move-specific power resolution, before item/ability and other power modifiers. */
    val effectivePowerOverride: Int? = null,
) {
    init {
        val checks = InputChecks()
        checks.require(hitIndex >= 0, "hitIndex", ValidationCode.OUT_OF_RANGE)
        checks.require(
            effectivePowerOverride == null || effectivePowerOverride in 0..1000,
            "effectivePowerOverride",
            ValidationCode.OUT_OF_RANGE,
        )
        checks.finish()
    }
}
