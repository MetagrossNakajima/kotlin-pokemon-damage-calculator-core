package dev.pokemondamage.model

data class DamageRequest(
    val attacker: PokemonState,
    val defender: PokemonState,
    val move: Move,
    val field: BattleField = BattleField(),
    val critical: Boolean = false,
    val hitIndex: Long = 0,
) {
    init {
        val checks = InputChecks()
        checks.require(hitIndex >= 0, "hitIndex", ValidationCode.OUT_OF_RANGE)
        checks.finish()
    }
}
