package dev.pokemondamage.model

/** ランクや補正を適用する前の、レベル50の能力実数値。 */
data class Stats(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int,
) {
    init {
        val checks = InputChecks()
        for (
        (name, value) in
        listOf(
            "hp" to hp,
            "attack" to attack,
            "defense" to defense,
            "specialAttack" to specialAttack,
            "specialDefense" to specialDefense,
            "speed" to speed,
        )
        ) {
            checks.require(value in 1..999, name, ValidationCode.OUT_OF_RANGE)
        }
        checks.finish()
    }

    operator fun get(stat: Stat): Int =
        when (stat) {
            Stat.HP -> hp
            Stat.ATTACK -> attack
            Stat.DEFENSE -> defense
            Stat.SPECIAL_ATTACK -> specialAttack
            Stat.SPECIAL_DEFENSE -> specialDefense
            Stat.SPEED -> speed
        }
}
