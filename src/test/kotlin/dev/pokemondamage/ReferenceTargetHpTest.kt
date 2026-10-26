package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ReferenceTargetHpTest {
    @TestFactory
    fun `target HP moves match native power and all damage rolls`() =
        javaClass
            .getResourceAsStream("/reference/target-hp.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also {
                assertEquals(setOf("CrushGrip", "WringOut", "HardPress"), it.keys)
            }
            .map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    assertEquals(
                        listOf(1, 2, 3, 7, 99, 100, 101, 199, 200),
                        rows.map { it[3].toInt() },
                    )
                    val pokemon =
                        PokemonState(
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.NORMAL),
                                PokemonWeight(100),
                            ),
                            Stats(200, 100, 100, 100, 100, 100),
                            ability = AbilityId("Illuminate"),
                        )
                    val rolls = rows.map { c ->
                        val request =
                            DamageRequest(
                                pokemon,
                                pokemon.copy(currentHp = c[3].toInt()),
                                Move(
                                    MoveId(name),
                                    PokemonType.valueOf(c[1]),
                                    1,
                                    Category.valueOf(c[2]),
                                ),
                            )
                        val hit =
                            assertIs<Calculation.Success<DamageResult>>(calculateDamage(request))
                                .value
                                .hit
                        assertEquals(c[4].toInt(), hit.power, "$name HP=${c[3]} power")
                        assertEquals(
                            c[5].removeSurrounding("[", "]").split(',').map(String::toInt),
                            hit.rolls,
                            "$name HP=${c[3]} damage",
                        )
                        hit.rolls
                    }
                    assertNotEquals(rolls.first(), rolls.last())
                }
            }
}
