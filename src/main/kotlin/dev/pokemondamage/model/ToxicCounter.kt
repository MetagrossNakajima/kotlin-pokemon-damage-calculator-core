package dev.pokemondamage.model

/** Toxic damage grows each turn, saturating at fifteen sixteenths of maximum HP. */
@JvmInline
value class ToxicCounter(
    val value: Int,
) {
    init {
        requireInput(value in 1..15, "value", ValidationCode.OUT_OF_RANGE)
    }

    fun next(): ToxicCounter = ToxicCounter(minOf(15, value + 1))

    companion object {
        val INITIAL = ToxicCounter(1)
    }
}
