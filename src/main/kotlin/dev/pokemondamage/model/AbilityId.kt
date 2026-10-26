package dev.pokemondamage.model

/** Case-sensitive source identifier. Custom nonempty IDs are supported. */
@JvmInline
value class AbilityId(val value: String) {
    init {
        requireInput(value.isNotEmpty(), "value", ValidationCode.REQUIRED)
    }
}
