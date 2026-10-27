package dev.pokemondamage.model

enum class Weather(
    val weatherBallType: TeraType,
) {
    SUNLIGHT(TeraType.FIRE),
    RAIN(TeraType.WATER),
    SANDSTORM(TeraType.ROCK),
    SNOW(TeraType.ICE),
}
