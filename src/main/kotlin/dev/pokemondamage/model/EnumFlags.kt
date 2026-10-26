package dev.pokemondamage.model

import java.util.Collections

/** Immutable set shared by move traits and field effects. */
class EnumFlags<E : Enum<E>>(
    vararg flags: E,
) {
    val values: Set<E> = Collections.unmodifiableSet(flags.toSet())

    operator fun contains(flag: E): Boolean = flag in values

    override fun equals(other: Any?): Boolean = other is EnumFlags<*> && values == other.values

    override fun hashCode(): Int = values.hashCode()

    override fun toString(): String = values.toString()
}
