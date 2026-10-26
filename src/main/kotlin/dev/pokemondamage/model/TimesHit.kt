package dev.pokemondamage.model

/** Historical hit count; Rage Fist reaches its maximum power after six hits. */
@JvmInline
value class TimesHit(
    val value: Int,
) {
    init {
        requireInput(value in 0..100, "value", ValidationCode.OUT_OF_RANGE)
    }

    val rageFistPower: Long get() = 50L * (1 + minOf(6, value))

    companion object {
        val NONE = TimesHit(0)
    }
}
