package dev.pokemondamage.model

/** Case-sensitive source identifier. Custom nonempty IDs are supported. */
@JvmInline
value class PokemonId(val value: String) {
    init {
        requireInput(value.isNotEmpty(), "value", ValidationCode.REQUIRED)
    }
}
