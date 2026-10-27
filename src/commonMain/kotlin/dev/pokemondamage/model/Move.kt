package dev.pokemondamage.model

import dev.pokemondamage.rules.MoveRules

data class Move(
    val id: MoveId,
    val type: PokemonType,
    val power: Int,
    val category: Category,
    val spread: Boolean = false,
    val flags: EnumFlags<MoveFlag> = EnumFlags(),
    val priority: Int = 0,
) {
    init {
        val checks = InputChecks()
        checks.require(
            power in 0..1000 &&
                (power != 0 || MoveRules.isFixedDamage(id) || MoveRules.isUnsupported(id)),
            "power",
            ValidationCode.OUT_OF_RANGE,
        )
        checks.require(priority in -7..5, "priority", ValidationCode.OUT_OF_RANGE)
        checks.finish()
    }
}
