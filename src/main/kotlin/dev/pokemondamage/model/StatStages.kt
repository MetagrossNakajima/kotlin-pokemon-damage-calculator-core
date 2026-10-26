package dev.pokemondamage.model

data class StatStages(
    val attack: StatStage = StatStage.NEUTRAL,
    val defense: StatStage = StatStage.NEUTRAL,
    val specialAttack: StatStage = StatStage.NEUTRAL,
    val specialDefense: StatStage = StatStage.NEUTRAL,
    val speed: StatStage = StatStage.NEUTRAL,
) {
    /** HP has no battle stage. */
    operator fun get(stat: Stat): StatStage? =
        when (stat) {
            Stat.HP -> null
            Stat.ATTACK -> attack
            Stat.DEFENSE -> defense
            Stat.SPECIAL_ATTACK -> specialAttack
            Stat.SPECIAL_DEFENSE -> specialDefense
            Stat.SPEED -> speed
        }

    companion object {
        /** Parses raw input together, retaining all field-specific validation errors. */
        fun fromValues(
            attack: Int = 0,
            defense: Int = 0,
            specialAttack: Int = 0,
            specialDefense: Int = 0,
            speed: Int = 0,
        ): StatStages {
            val checks = InputChecks()
            for (
            (name, stage) in
            listOf(
                "attack" to attack,
                "defense" to defense,
                "specialAttack" to specialAttack,
                "specialDefense" to specialDefense,
                "speed" to speed,
            )
            ) {
                checks.require(stage in -6..6, name, ValidationCode.OUT_OF_RANGE)
            }
            checks.finish()
            return StatStages(
                StatStage(attack),
                StatStage(defense),
                StatStage(specialAttack),
                StatStage(specialDefense),
                StatStage(speed),
            )
        }
    }
}
