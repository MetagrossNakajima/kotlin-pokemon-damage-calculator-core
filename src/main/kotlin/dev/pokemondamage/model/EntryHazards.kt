package dev.pokemondamage.model

data class EntryHazards(val stealthRock: Boolean = false, val spikesLayers: Int = 0) {
    init {
        val checks = InputChecks()
        checks.require(spikesLayers in 0..3, "spikesLayers", ValidationCode.OUT_OF_RANGE)
        checks.finish()
    }
}
