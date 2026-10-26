package dev.pokemondamage.engine

import dev.pokemondamage.model.*

/** Prepared battle values may exceed input power bounds and may have the Stellar type. */
internal data class EffectiveMove(
    val original: Move,
    val type: TeraType,
    val power: Int,
    val category: Category,
    val flags: EnumFlags<MoveFlag> = original.flags,
)
