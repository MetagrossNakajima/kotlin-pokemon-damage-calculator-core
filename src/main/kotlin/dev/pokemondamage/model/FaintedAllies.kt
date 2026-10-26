package dev.pokemondamage.model

/** Historical faint count; Last Respects and Supreme Overlord have different caps. */
@JvmInline
value class FaintedAllies(
    val value: Int,
) {
    init {
        requireInput(value in 0..100, "value", ValidationCode.OUT_OF_RANGE)
    }

    val lastRespectsPower: Long get() = 50L * (1 + value)
    val supremeOverlordModifier: Int get() = overlord[minOf(5, value)]

    companion object {
        val NONE = FaintedAllies(0)
        private val overlord = listOf(4096, 4506, 4915, 5325, 5734, 6144)
    }
}
