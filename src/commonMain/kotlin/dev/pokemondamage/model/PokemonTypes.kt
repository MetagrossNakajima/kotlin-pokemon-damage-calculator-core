package dev.pokemondamage.model

/** 重複のない1～2種類のタイプ。指定された順序を保持する。 */
data class PokemonTypes(
    val primary: PokemonType,
    val secondary: PokemonType? = null,
) {
    init {
        requireInput(primary != secondary, "types", ValidationCode.DUPLICATE)
    }

    operator fun contains(type: PokemonType): Boolean = primary == type || secondary == type

    /** 新しいリストを返し、返却後の変更が元の値に影響しないようにする。 */
    fun toList(): List<PokemonType> = listOfNotNull(primary, secondary)
}
