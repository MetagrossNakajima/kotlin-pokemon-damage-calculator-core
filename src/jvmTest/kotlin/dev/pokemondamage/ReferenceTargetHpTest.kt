package dev.pokemondamage

import dev.pokemondamage.fixtures.targetHpCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

class ReferenceTargetHpTest {
    @TestFactory
    fun `target HP moves match native power and all damage rolls`() =
        targetHpCases()
            .groupBy { it.move }
            .also {
                assertEquals(setOf("CrushGrip", "WringOut", "HardPress"), it.keys)
            }.map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    assertEquals(
                        listOf(1, 2, 3, 7, 99, 100, 101, 199, 200),
                        rows.map { it.hp },
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
                    val rolls =
                        rows.map { c ->
                            val request =
                                DamageRequest(
                                    pokemon,
                                    pokemon.copy(currentHp = c.hp),
                                    Move(
                                        MoveId(name),
                                        c.type,
                                        1,
                                        c.category,
                                    ),
                                )
                            val hit =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(request),
                                ).value
                                    .hit
                            assertEquals(c.power, hit.power, "$name HP=${c.hp} power")
                            assertEquals(
                                c.damage,
                                hit.rolls,
                                "$name HP=${c.hp} damage",
                            )
                            hit.rolls
                        }
                    assertNotEquals(rolls.first(), rolls.last())
                }
            }
}
