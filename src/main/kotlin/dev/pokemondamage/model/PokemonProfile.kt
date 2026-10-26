package dev.pokemondamage.model

/** Species data supplied by the caller; types describe the state before Terastallization. */
data class PokemonProfile(
    val id: PokemonId,
    val types: PokemonTypes,
    val weight: PokemonWeight,
    val gender: Gender = Gender.GENDERLESS,
)
