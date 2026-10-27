package dev.pokemondamage.model

import java.util.Collections

/** 技の性質や場の効果で共有する、変更不可の集合。 */
class EnumFlags<E : Enum<E>>(
    vararg flags: E,
) {
    val values: Set<E> = Collections.unmodifiableSet(flags.toSet())

    operator fun contains(flag: E): Boolean = flag in values

    override fun equals(other: Any?): Boolean = other is EnumFlags<*> && values == other.values

    override fun hashCode(): Int = values.hashCode()

    override fun toString(): String = values.toString()
}
