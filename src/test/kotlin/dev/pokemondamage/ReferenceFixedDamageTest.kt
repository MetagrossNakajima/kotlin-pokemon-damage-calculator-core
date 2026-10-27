package dev.pokemondamage

import dev.pokemondamage.fixtures.fixedDamageCases
import dev.pokemondamage.fixtures.unsupportedFixedCases
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
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ReferenceFixedDamageTest {
    @Test
    fun `guardian of alola knocks out one HP targets unless immune`() {
        val pokemon =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(200, 100, 100, 100, 100, 100),
            )
        val move = Move(MoveId("GuardianofAlola"), PokemonType.FAIRY, 0, Category.SPECIAL)
        for ((ability, expected) in listOf(null to 1, AbilityId("WonderGuard") to 0)) {
            val defender = pokemon.copy(currentHp = 1, ability = ability)
            val result =
                assertIs<Calculation.Success<DamageResult>>(
                    calculateDamage(DamageRequest(pokemon, defender, move)),
                ).value
            assertEquals(listOf(expected), result.hit.rolls, "ability=$ability")
            assertEquals(
                expected == 1,
                result.distribution.knockoutProbability(1.toBigInteger()).guaranteed,
                "ability=$ability",
            )
        }
    }

    @TestFactory
    fun `fixed moves match expected damage across HP boundaries modifiers and immunity`() =
        fixedDamageCases()
            .groupBy { it.move }
            .also { assertEquals(7, it.size) }
            .map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    assertEquals(13, rows.size)
                    val values =
                        rows.map { c ->
                            val modified = c.modified
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
                                    currentHp = c.attackerHp,
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
                                    profile.copy(types = PokemonTypes(c.defenderType)),
                                    stats,
                                    currentHp = c.defenderHp,
                                    ability = AbilityId(c.defenderAbility),
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
                                    c.type,
                                    0,
                                    c.category,
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
                            // 保存済みの参照値はHP1で0を返すが、これらの技は1ダメージを与える。
                            val expected =
                                if (
                                    name in setOf("NaturesMadness", "GuardianofAlola") &&
                                    c.defenderHp == 1
                                ) {
                                    1
                                } else {
                                    c.damage
                                }
                            assertEquals(
                                listOf(expected),
                                result.rolls,
                                "$name HP=${c.attackerHp} modified=$modified target=${c.defenderType}/${c.defenderAbility}",
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
        unsupportedFixedCases()
            .groupBy { it.move }
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
                    assertEquals(listOf(1, 3, 101, 200), rows.map { it.defenderHp })
                    rows.zip(expected).forEach { (c, damage) ->
                        assertEquals(
                            0,
                            c.nativeDamage,
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
                                currentHp = c.attackerHp,
                                ability = AbilityId("Illuminate"),
                            )
                        val d =
                            a.copy(
                                profile = profile.copy(types = PokemonTypes(PokemonType.GRASS)),
                                currentHp = c.defenderHp,
                            )
                        val move =
                            Move(MoveId(name), c.type, 0, c.category)
                        val result =
                            assertIs<Calculation.Success<DamageResult>>(
                                calculateDamage(DamageRequest(a, d, move)),
                            ).value
                                .hit
                        assertEquals(listOf(damage), result.rolls, "$name HP=${c.defenderHp}")
                        assertEquals(DamageKind.FIXED, result.kind)
                    }
                }
            }
}
