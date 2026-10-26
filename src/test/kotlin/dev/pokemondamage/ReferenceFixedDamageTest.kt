package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageKind
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.SideConditions
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.Weather
import dev.pokemondamage.model.zip
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ReferenceFixedDamageTest {
    @TestFactory
    fun `fixed moves match expected damage across HP boundaries modifiers and immunity`() =
        javaClass
            .getResourceAsStream("/reference/fixed.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(7, it.size) }
            .map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    assertEquals(13, rows.size)
                    val values =
                        rows.map { c ->
                            val modified = c[7].toBooleanStrict()
                            val profile =
                                PokemonProfile(
                                    PokemonId("Mew"),
                                    PokemonTypes(PokemonType.NORMAL),
                                    PokemonWeight(100),
                                )
                            val stats = Stats(200, 100, 100, 100, 100, 100)
                            val a =
                                PokemonState(
                                    profile,
                                    stats,
                                    currentHp = c[3].toInt(),
                                    ability = AbilityId("Illuminate"),
                                    item = if (modified) ItemId("LifeOrb") else null,
                                    status = if (modified) Status.BURN else null,
                                    stages =
                                        if (modified) {
                                            StatStages.fromValues(attack = 6, specialAttack = 6)
                                        } else {
                                            StatStages.fromValues()
                                        },
                                )
                            val d =
                                PokemonState(
                                    profile.copy(types = PokemonTypes(PokemonType.valueOf(c[5]))),
                                    stats,
                                    currentHp = c[4].toInt(),
                                    ability = AbilityId(c[6]),
                                    stages =
                                        if (modified) {
                                            StatStages.fromValues(defense = 6, specialDefense = 6)
                                        } else {
                                            StatStages.fromValues()
                                        },
                                    sideConditions = SideConditions(modified, modified),
                                )
                            val move =
                                Move(
                                    MoveId(name),
                                    PokemonType.valueOf(c[1]),
                                    0,
                                    Category.valueOf(c[2]),
                                )
                            val request =
                                DamageRequest(
                                    a,
                                    d,
                                    move,
                                    BattleField(weather = if (modified) Weather.SUNLIGHT else null),
                                    critical = modified,
                                )
                            val result =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(request),
                                ).value
                                    .hit
                            // 保存済みの参照値はHP1で0を返すが、この技は1ダメージを与える。
                            val expected =
                                if (name == "NaturesMadness" && c[4] == "1") 1 else c[8].toInt()
                            assertEquals(
                                listOf(expected),
                                result.rolls,
                                "$name HP=${c[3]} modified=$modified target=${c[5]}/${c[6]}",
                            )
                            assertEquals(DamageKind.FIXED, result.kind)
                            assertFalse(result.critical)
                            result.rolls.single()
                        }
                    values.dropLast(1).chunked(2).forEach { (plain, modified) ->
                        assertEquals(plain, modified, "ordinary modifiers must not affect $name")
                    }
                    assertTrue(
                        values.dropLast(1).any { it > 0 },
                        "$name must have a nonimmune control",
                    )
                    assertEquals(0, values.last(), "$name must respect immunity")
                }
            }

    @TestFactory
    fun `source fixed moves retain supported results where native has no implementation`() =
        javaClass
            .getResourceAsStream("/reference/fixed-unsupported.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(7, it.size) }
            .map { (name, rows) ->
                dynamicTest("SourceOnly/MoveId/$name") {
                    val expected =
                        when (name) {
                            "SuperFang",
                            "Ruination",
                            -> listOf(1, 1, 50, 100)

                            "Endeavor" -> listOf(0, 0, 61, 160)

                            else -> listOf(1, 3, 101, 200)
                        }
                    assertEquals(listOf("1", "3", "101", "200"), rows.map { it[4] })
                    rows.zip(expected).forEach { (c, damage) ->
                        assertEquals(
                            "0",
                            c[5],
                            "Pinned native engine has no fixed-damage implementation for $name",
                        )
                        val profile =
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.NORMAL),
                                PokemonWeight(100),
                            )
                        val stats = Stats(200, 100, 100, 100, 100, 100)
                        val a =
                            PokemonState(
                                profile,
                                stats,
                                currentHp = c[3].toInt(),
                                ability = AbilityId("Illuminate"),
                            )
                        val d =
                            a.copy(
                                profile = profile.copy(types = PokemonTypes(PokemonType.GRASS)),
                                currentHp = c[4].toInt(),
                            )
                        val move =
                            Move(MoveId(name), PokemonType.valueOf(c[1]), 0, Category.valueOf(c[2]))
                        val result =
                            assertIs<Calculation.Success<DamageResult>>(
                                calculateDamage(DamageRequest(a, d, move)),
                            ).value
                                .hit
                        assertEquals(listOf(damage), result.rolls, "$name HP=${c[4]}")
                        assertEquals(DamageKind.FIXED, result.kind)
                    }
                }
            }
}
