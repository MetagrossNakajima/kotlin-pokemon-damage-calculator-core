package dev.pokemondamage.model

/** 能力実数値や後続の補正とは独立した、バトル中の能力ランク。 */
@JvmInline
value class StatStage(
    val value: Int,
) {
    init {
        requireInput(value in -6..6, "value", ValidationCode.OUT_OF_RANGE)
    }

    val numerator: Int get() = 2 + maxOf(0, value)
    val denominator: Int get() = 2 - minOf(0, value)
    val positive: Int get() = maxOf(0, value)

    fun ignoringNegative(): StatStage = StatStage(maxOf(0, value))

    fun ignoringPositive(): StatStage = StatStage(minOf(0, value))

    companion object {
        val NEUTRAL = StatStage(0)
    }
}
