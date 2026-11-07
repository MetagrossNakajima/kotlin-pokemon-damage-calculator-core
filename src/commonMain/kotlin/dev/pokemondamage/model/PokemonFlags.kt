package dev.pokemondamage.model

import dev.pokemondamage.collections.ImmutableCollections

/** 未指定と明示的なfalseは異なるバトル状態として扱う。 */
class PokemonFlags(
    overrides: Map<PokemonFlag, Boolean> = emptyMap(),
) {
    val overrides: Map<PokemonFlag, Boolean> =
        ImmutableCollections.unmodifiableMap(
            overrides.toMap(),
        )

    operator fun get(flag: PokemonFlag): Boolean? = overrides[flag]

    override fun equals(other: Any?): Boolean =
        other is PokemonFlags && overrides == other.overrides

    override fun hashCode(): Int = overrides.hashCode()

    override fun toString(): String = overrides.toString()
}
