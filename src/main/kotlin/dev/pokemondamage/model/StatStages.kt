package dev.pokemondamage.model

data class StatStages(
    val attack: Int = 0,
    val defense: Int = 0,
    val specialAttack: Int = 0,
    val specialDefense: Int = 0,
    val speed: Int = 0,
) {
    init {
        val checks = InputChecks()
        for ((name, stage) in
            listOf(
                "attack" to attack,
                "defense" to defense,
                "specialAttack" to specialAttack,
                "specialDefense" to specialDefense,
                "speed" to speed,
            )) {
            checks.require(stage in -6..6, name, ValidationCode.OUT_OF_RANGE)
        }
        checks.finish()
    }

    /** HP has no battle stage. */
    operator fun get(stat: Stat): Int? =
        when (stat) {
            Stat.HP -> null
            Stat.ATTACK -> attack
            Stat.DEFENSE -> defense
            Stat.SPECIAL_ATTACK -> specialAttack
            Stat.SPECIAL_DEFENSE -> specialDefense
            Stat.SPEED -> speed
        }
}
