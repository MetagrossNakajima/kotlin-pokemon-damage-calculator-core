package dev.pokemondamage.rules

/** Shared classification for input validation, damage selection and OHKO immunity. */
internal enum class FixedDamageKind {
    HALF_CURRENT_HP,
    THREE_QUARTERS_CURRENT_HP,
    ATTACKER_HP,
    HP_DIFFERENCE,
    TWENTY,
    FORTY,
    LEVEL,
    ONE_HIT_KO,
}
