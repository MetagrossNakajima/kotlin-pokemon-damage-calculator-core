package dev.pokemondamage.model

data class CalculationLimits(
    val maxOperations: Long = 2_000_000,
    val maxStates: Long = 100_000,
) {
    init {
        val checks = InputChecks()
        checks.require(maxOperations > 0, "maxOperations", ValidationCode.OUT_OF_RANGE)
        checks.require(maxStates > 0, "maxStates", ValidationCode.OUT_OF_RANGE)
        checks.finish()
    }
}
