package dev.pokemondamage.model

enum class AccuracyMode {
    /** One accuracy check for the entire attack. */
    ONCE_PER_ATTACK,

    /** A new check for every hit; the first miss ends the attack. */
    UNTIL_FIRST_MISS,
}
