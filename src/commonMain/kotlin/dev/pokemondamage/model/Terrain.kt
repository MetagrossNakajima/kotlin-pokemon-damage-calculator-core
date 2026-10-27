package dev.pokemondamage.model

enum class Terrain(
    val terrainPulseType: TeraType,
    val boostedType: TeraType?,
) {
    ELECTRIC(TeraType.ELECTRIC, TeraType.ELECTRIC),
    GRASS(TeraType.GRASS, TeraType.GRASS),
    MISTY(TeraType.FAIRY, null),
    PSYCHIC(TeraType.PSYCHIC, TeraType.PSYCHIC),
}
