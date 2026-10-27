package dev.pokemondamage

import dev.pokemondamage.fixtures.MagnitudeDifferenceCases
import dev.pokemondamage.fixtures.MovePairsCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonFlags
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.SideConditions
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Terrain
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

class ReferenceMovePairsTest {
    @TestFactory
    fun `move-specific conditions match native complete damage`() =
        MovePairsCases.all
            .groupBy { it.move }
            .also { assertEquals(56, it.size) }
            .map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    val genericResults = mutableListOf<List<Int>>()
                    val results =
                        rows.map { c ->

                            val profile =
                                PokemonProfile(
                                    PokemonId(c.attackerSpecies),
                                    PokemonTypes(PokemonType.NORMAL),
                                    PokemonWeight(c.attackerWeight),
                                )
                            val stats = Stats(200, 100, 100, 100, 100, 100)
                            val stages =
                                c.attackerStages
                            val a =
                                PokemonState(
                                    profile,
                                    stats,
                                    stages,
                                    teraType = c.attackerTera,
                                    ability = AbilityId("Illuminate"),
                                    item = c.attackerItem?.let(::ItemId),
                                    currentHp = c.attackerHp,
                                    status = c.attackerStatus,
                                    flags =
                                        PokemonFlags(
                                            mapOf(
                                                PokemonFlag.MOVES_FIRST to c.movesFirst,
                                            ),
                                        ),
                                )
                            val d =
                                PokemonState(
                                    profile.copy(
                                        id = PokemonId("Mew"),
                                        types = PokemonTypes(c.defenderType),
                                        weight = PokemonWeight(c.defenderWeight),
                                    ),
                                    stats,
                                    stages =
                                        c.defenderStages,
                                    sideConditions =
                                        SideConditions(
                                            c.screen,
                                            c.screen,
                                        ),
                                    ability = AbilityId(c.defenderAbility),
                                    item = c.defenderItem?.let(::ItemId),
                                    currentHp = c.defenderHp,
                                    status = c.defenderStatus,
                                )
                            val flags = c.flags
                            val field =
                                BattleField(
                                    weather = c.weather,
                                    terrain = c.terrain,
                                    gravity = c.gravity,
                                )
                            val move =
                                Move(
                                    MoveId(name),
                                    c.type,
                                    c.power,
                                    c.category,
                                    flags = EnumFlags(*flags.toTypedArray()),
                                )
                            val actual =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(DamageRequest(a, d, move, field)),
                                ).value
                                    .hit
                                    .rolls
                            val encoded =
                                c.damage
                            assertEquals(
                                if (encoded.size == 1) List(16) { encoded.single() } else encoded,
                                actual,
                                "$name enabled=${c.enabled}",
                            )
                            if (c.genericDamage != null) {
                                val generic =
                                    assertIs<Calculation.Success<DamageResult>>(
                                        calculateDamage(
                                            DamageRequest(
                                                a,
                                                d,
                                                move.copy(id = MoveId("Tackle")),
                                                field,
                                            ),
                                        ),
                                    ).value
                                        .hit
                                        .rolls
                                val expected =
                                    c.genericDamage
                                assertEquals(
                                    if (expected.size == 1) {
                                        List(16) { expected.single() }
                                    } else {
                                        expected
                                    },
                                    generic,
                                    "$name generic control enabled=${c.enabled}",
                                )
                                genericResults += generic
                            }
                            actual
                        }
                    if (
                        name in
                        setOf(
                            "ThousandArrows",
                            "BrickBreak",
                            "PsychicFangs",
                            "SacredSword",
                            "ChipAway",
                            "DarkestLariat",
                            "MoongeistBeam",
                            "SunsteelStrike",
                        )
                    ) {
                        assertEquals(
                            results[0],
                            results[1],
                            "$name must bypass the tested immunity, screen or defense stage",
                        )
                    } else {
                        assertNotEquals(
                            results[0],
                            results[1],
                            "condition must change damage for $name",
                        )
                    }
                    if (genericResults.isNotEmpty()) {
                        assertEquals(2, genericResults.size)
                        assertNotEquals(
                            genericResults[0],
                            genericResults[1],
                            "$name condition must affect the generic control",
                        )
                        assertEquals(
                            results[0],
                            genericResults[0],
                            "$name without the condition must match the generic control",
                        )
                        assertNotEquals(
                            results[1],
                            genericResults[1],
                            "$name must bypass the condition that affects the generic control",
                        )
                    }
                }
            }

    @Test
    fun `MoveId Magnitude matches native damage with and without Grassy Terrain`() {
        val rows =
            MagnitudeDifferenceCases.all
        assertEquals(2, rows.size)
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
        val native = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32)
        for (c in rows) {
            assertEquals("Magnitude", c.move)
            assertEquals(70, c.power)
            val grassy = c.enabled
            assertEquals(if (grassy) Terrain.GRASS else null, c.terrain)
            assertEquals(
                native,
                c.damage,
            )
            val result =
                assertIs<Calculation.Success<DamageResult>>(
                    calculateDamage(
                        DamageRequest(
                            pokemon,
                            pokemon,
                            Move(
                                MoveId("Magnitude"),
                                PokemonType.GROUND,
                                70,
                                Category.PHYSICAL,
                            ),
                            BattleField(terrain = if (grassy) Terrain.GRASS else null),
                        ),
                    ),
                ).value
                    .hit
                    .rolls
            assertEquals(native, result)
        }
    }
}
