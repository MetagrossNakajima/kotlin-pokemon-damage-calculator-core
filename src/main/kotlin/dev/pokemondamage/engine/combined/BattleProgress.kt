package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.ToxicCounter
import java.math.BigInteger

/** State that distinguishes probability branches; weight is kept outside the key. */
internal data class BattleProgress(
    val hp: Int,
    val itemConsumed: Boolean,
    val toxicCounter: ToxicCounter?,
    val cudChewTurn: Long?,
    val attackDamage: BigInteger = BigInteger.ZERO,
)
