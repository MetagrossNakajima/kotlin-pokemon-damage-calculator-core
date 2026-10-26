package dev.pokemondamage.model

/** One or two distinct types; the original ordering is retained. */
data class PokemonTypes(val primary: PokemonType, val secondary: PokemonType? = null) {
    init {
        requireInput(primary != secondary, "types", ValidationCode.DUPLICATE)
    }

    operator fun contains(type: PokemonType): Boolean = primary == type || secondary == type

    /** A fresh view: changing a returned list cannot alter this value. */
    fun toList(): List<PokemonType> = listOfNotNull(primary, secondary)
}
