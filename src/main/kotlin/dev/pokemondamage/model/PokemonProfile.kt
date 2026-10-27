package dev.pokemondamage.model

/** 呼び出し側が指定するポケモンの種族情報。タイプはテラスタル前のものを使う。 */
data class PokemonProfile(
    val id: PokemonId,
    val types: PokemonTypes,
    val weight: PokemonWeight,
    val gender: Gender = Gender.GENDERLESS,
)
