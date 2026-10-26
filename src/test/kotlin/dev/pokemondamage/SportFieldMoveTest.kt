package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class SportFieldMoveTest {
    @TestFactory
    fun `sport field effects preserve source final damage and type restrictions`() =
        listOf(
                Triple("MudSport", FieldEffect.MUD_SPORT, PokemonType.ELECTRIC),
                Triple("WaterSport", FieldEffect.WATER_SPORT, PokemonType.FIRE),
            )
            .map { (name, effect, type) ->
                dynamicTest("MoveId/$name") {
                    val pokemon =
                        PokemonState(
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.NORMAL),
                                PokemonWeight(100),
                            ),
                            Stats(200, 100, 100, 100, 100, 100),
                        )
                    val ordinary =
                        listOf(39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46)
                    val reduced =
                        listOf(13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16)
                    for (category in Category.entries) for (enabled in
                        listOf(false, true)) for (moveType in listOf(type, PokemonType.WATER)) {
                        val field =
                            BattleField(effects = if (enabled) EnumFlags(effect) else EnumFlags())
                        val move = Move(MoveId("Tackle"), moveType, 100, category)
                        val result =
                            assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(DamageRequest(pokemon, pokemon, move, field)),
                                )
                                .value
                                .hit
                        val affected = enabled && moveType == type
                        assertEquals(
                            if (affected) 33 else 100,
                            result.power,
                            "$name/$category/$moveType/$enabled power",
                        )
                        assertEquals(
                            if (affected) reduced else ordinary,
                            result.rolls,
                            "$name/$category/$moveType/$enabled damage",
                        )
                    }
                }
            }
}
