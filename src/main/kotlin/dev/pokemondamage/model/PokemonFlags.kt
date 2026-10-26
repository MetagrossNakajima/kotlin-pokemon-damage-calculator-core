package dev.pokemondamage.model

import java.util.Collections

/** Unspecified and explicitly false are different battle states. */
class PokemonFlags(overrides: Map<PokemonFlag, Boolean> = emptyMap()) {
    val overrides: Map<PokemonFlag, Boolean> = Collections.unmodifiableMap(overrides.toMap())

    operator fun get(flag: PokemonFlag): Boolean? = overrides[flag]

    override fun equals(other: Any?): Boolean =
        other is PokemonFlags && overrides == other.overrides

    override fun hashCode(): Int = overrides.hashCode()

    override fun toString(): String = overrides.toString()
}
