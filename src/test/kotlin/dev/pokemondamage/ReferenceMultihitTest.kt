package dev.pokemondamage

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
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.zip
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ReferenceMultihitTest {
    @TestFactory
    fun `every natural multihit move matches each native hit with Tera and Parental Bond`() =
        javaClass
            .getResourceAsStream("/reference/multihit.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(30, it.size) }
            .map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    val profiles =
                        PokemonProfile(
                            PokemonId("Mew"),
                            PokemonTypes(PokemonType.NORMAL),
                            PokemonWeight(100),
                        )
                    val pokemon =
                        PokemonState(
                            profiles,
                            Stats(200, 100, 100, 100, 100, 100),
                            ability = AbilityId("Illuminate"),
                        )
                    val results =
                        rows.map { c ->
                            val tera = c[5].toBooleanStrict()
                            val type = PokemonType.valueOf(c[2])
                            val a =
                                pokemon.copy(
                                    ability = AbilityId(c[6]),
                                    teraType = if (tera) TeraType.valueOf(c[2]) else null,
                                )
                            val move =
                                Move(
                                    MoveId(name),
                                    type,
                                    c[1].toInt(),
                                    Category.valueOf(c[3]),
                                    priority = c[4].toInt(),
                                )
                            val result =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(
                                        DamageRequest(a, pokemon, move, hitIndex = c[8].toLong()),
                                    ),
                                ).value
                                    .hit
                            val expected =
                                c[9]
                                    .removePrefix("[")
                                    .removeSuffix("]")
                                    .split(',')
                                    .map(String::toInt)
                            assertEquals(
                                expected,
                                result.rolls,
                                "$name tera=$tera ability=${c[6]} hit=${c[8]}",
                            )
                            assertEquals(16, result.rolls.size)
                            result.rolls
                        }
                    for (tera in listOf("false", "true")) {
                        val indices = rows.indices.filter { rows[it][5] == tera }
                        val plain =
                            indices.filter { rows[it][6] == "Illuminate" }.map { results[it] }
                        val parent =
                            indices.filter { rows[it][6] == "ParentalBond" }.map { results[it] }
                        assertEquals(rows.first()[7].toInt(), plain.size)
                        assertEquals(
                            plain,
                            parent,
                            "Parental Bond must not reduce any natural multihit strike",
                        )
                        if (name in setOf("TripleAxel", "TripleKick")) {
                            assertEquals(3, plain.size)
                            assertTrue(
                                plain.zipWithNext().all { (a, b) ->
                                    a.zip(b).all { (x, y) -> y > x }
                                },
                                "$name must grow stronger on every hit",
                            )
                        } else {
                            assertTrue(
                                plain.all { it == plain.first() },
                                "$name has constant per-hit power in these conditions",
                            )
                        }
                    }
                }
            }
}
