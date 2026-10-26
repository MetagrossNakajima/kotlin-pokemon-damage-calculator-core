package dev.pokemondamage.model

/** これまでに攻撃を受けた回数。ふんどのこぶしは6回で最大威力になる。 */
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
