package dev.pokemondamage.model

import dev.pokemondamage.collections.ImmutableCollections
import dev.pokemondamage.math.BigInteger

class BattleSetup(
    val entryHazards: EntryHazards = EntryHazards(),
    initialDamages: List<BigInteger> = emptyList(),
) {
    val initialDamages: List<BigInteger> = ImmutableCollections.unmodifiableList(initialDamages)

    init {
        val checks = InputChecks()
        this.initialDamages.forEachIndexed { index, amount ->
            checks.require(
                amount.signum() >= 0,
                "initialDamages[$index]",
                ValidationCode.OUT_OF_RANGE,
            )
        }
        checks.finish()
    }

    override fun equals(other: Any?): Boolean =
        other is BattleSetup &&
            entryHazards == other.entryHazards &&
            initialDamages == other.initialDamages

    override fun hashCode(): Int = listOf(entryHazards, initialDamages).hashCode()
}
