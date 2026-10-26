package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*

class BlankPlateTest {
    @Test
    fun `ItemId BlankPlate preserves source Normal boost and does not boost other types`() {
        val pokemon =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(200, 100, 100, 100, 100, 100),
            )
        val normal = listOf(46, 46, 48, 48, 48, 49, 49, 51, 51, 51, 52, 52, 52, 54, 54, 55)
        val boosted = listOf(55, 55, 57, 57, 58, 58, 60, 60, 60, 61, 61, 63, 63, 64, 64, 66)
        val water = listOf(31, 31, 32, 32, 32, 33, 33, 34, 34, 34, 35, 35, 35, 36, 36, 37)
        for (held in listOf(false, true)) for (type in
            listOf(PokemonType.NORMAL, PokemonType.WATER)) {
            val a = pokemon.copy(item = if (held) ItemId("BlankPlate") else null)
            val result =
                assertIs<Calculation.Success<DamageResult>>(
                        calculateDamage(
                            DamageRequest(
                                a,
                                pokemon,
                                Move(MoveId("Tackle"), type, 80, Category.PHYSICAL),
                            ),
                        ),
                    )
                    .value
                    .hit
            assertEquals(if (held && type == PokemonType.NORMAL) 96 else 80, result.power)
            assertEquals(
                if (type == PokemonType.WATER) water else if (held) boosted else normal,
                result.rolls,
                "held=$held type=$type",
            )
        }
    }
}
