package dev.pokemondamage.math

/** Integer arithmetic used by the battle engine. Rounding order is part of the rules. */
internal object BattleMath {
    const val UNIT = 4096

    /** Applying a modifier rounds exact halves down. */
    fun modify(value: Int, numerator: Int, denominator: Int = UNIT): Int =
        ((value.toLong() * numerator * 2 + denominator - 1) / (denominator * 2L)).toInt()

    /** Chaining modifiers, unlike applying them, rounds exact halves up. */
    fun chain(current: Int, next: Int): Int = ((current.toLong() * next + UNIT / 2) / UNIT).toInt()

    fun unsigned16(value: Int): Int = value and 0xffff

    fun unsigned32(value: Long): Long = value and 0xffffffffL

    fun rankedStat(value: Int, stage: Int): Int =
        when {
            stage > 0 -> unsigned16(value * (2 + stage)) / 2
            stage < 0 -> unsigned16(value * 2) / (2 - stage)
            else -> value
        }

    /** The source API fixes the combatants' level at 50. */
    fun baseDamage(power: Int, attack: Int, defense: Int): Int =
        (unsigned32(unsigned32(22L * power) * attack) / defense / 50 + 2).toInt()

    /** Damage modifiers wrap their product to 32 bits before rounding. */
    fun modifyDamage(damage: Int, numerator: Int): Int =
        ((unsigned32(damage.toLong() * numerator) * 2 + UNIT - 1) / (UNIT * 2)).toInt()
}
