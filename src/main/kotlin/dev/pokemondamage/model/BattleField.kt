package dev.pokemondamage.model

data class BattleField(
    val format: BattleFormat = BattleFormat.SINGLE,
    val weather: Weather? = null,
    val terrain: Terrain? = null,
    val gravity: Boolean = false,
    val effects: EnumFlags<FieldEffect> = EnumFlags(),
)
