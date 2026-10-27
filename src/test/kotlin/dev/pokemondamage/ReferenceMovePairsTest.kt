package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
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
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.Weather
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

class ReferenceMovePairsTest {
    @TestFactory
    fun `move-specific conditions match native complete damage`() =
        javaClass
            .getResourceAsStream("/reference/move-pairs.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(56, it.size) }
            .map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    val genericResults = mutableListOf<List<Int>>()
                    val results =
                        rows.map { c ->
                            fun optional(index: Int) = c[index].takeUnless { it == "-" }
                            val profile =
                                PokemonProfile(
                                    PokemonId(c[21]),
                                    PokemonTypes(PokemonType.NORMAL),
                                    PokemonWeight(c[14].toInt()),
                                )
                            val stats = Stats(200, 100, 100, 100, 100, 100)
                            val stages =
                                c[16].split(',').map(String::toInt).let {
                                    StatStages.fromValues(it[0], it[1], it[2], it[3], it[4])
                                }
                            val a =
                                PokemonState(
                                    profile,
                                    stats,
                                    stages,
                                    teraType = optional(20)?.let(TeraType::valueOf),
                                    ability = AbilityId("Illuminate"),
                                    item = optional(10)?.let(::ItemId),
                                    currentHp = c[6].toInt(),
                                    status = optional(8)?.let(Status::valueOf),
                                    flags =
                                        PokemonFlags(
                                            mapOf(
                                                PokemonFlag.MOVES_FIRST to c[26].toBooleanStrict(),
                                            ),
                                        ),
                                )
                            val d =
                                PokemonState(
                                    profile.copy(
                                        id = PokemonId("Mew"),
                                        types = PokemonTypes(PokemonType.valueOf(c[17])),
                                        weight = PokemonWeight(c[15].toInt()),
                                    ),
                                    stats,
                                    stages =
                                        c[23].split(',').map(String::toInt).let {
                                            StatStages.fromValues(it[0], it[1], it[2], it[3], it[4])
                                        },
                                    sideConditions =
                                        SideConditions(
                                            c[22].toBooleanStrict(),
                                            c[22].toBooleanStrict(),
                                        ),
                                    ability = AbilityId(c[19]),
                                    item = optional(25)?.let(::ItemId),
                                    currentHp = c[7].toInt(),
                                    status = optional(9)?.let(Status::valueOf),
                                )
                            val flags = optional(5)?.split(',')?.map(MoveFlag::valueOf).orEmpty()
                            val field =
                                BattleField(
                                    weather = optional(11)?.let(Weather::valueOf),
                                    terrain = optional(12)?.let(Terrain::valueOf),
                                    gravity = c[13].toBooleanStrict(),
                                )
                            val move =
                                Move(
                                    MoveId(name),
                                    PokemonType.valueOf(c[3]),
                                    c[2].toInt(),
                                    Category.valueOf(c[4]),
                                    flags = EnumFlags(*flags.toTypedArray()),
                                )
                            val actual =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(DamageRequest(a, d, move, field)),
                                ).value
                                    .hit
                                    .rolls
                            val encoded =
                                c[18]
                                    .removePrefix("[")
                                    .removeSuffix("]")
                                    .split(',')
                                    .map(String::toInt)
                            assertEquals(
                                if (encoded.size == 1) List(16) { encoded.single() } else encoded,
                                actual,
                                "$name enabled=${c[1]}",
                            )
                            if (c[24] != "-") {
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
                                    c[24]
                                        .removePrefix("[")
                                        .removeSuffix("]")
                                        .split(',')
                                        .map(String::toInt)
                                assertEquals(
                                    if (expected.size == 1) {
                                        List(16) { expected.single() }
                                    } else {
                                        expected
                                    },
                                    generic,
                                    "$name generic control enabled=${c[1]}",
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
            javaClass
                .getResourceAsStream("/reference/magnitude-difference.tsv")!!
                .bufferedReader()
                .readLines()
                .drop(1)
                .map { it.split('\t') }
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
            assertEquals("Magnitude", c[0])
            assertEquals("70", c[2])
            val grassy = c[1].toBooleanStrict()
            assertEquals(if (grassy) "GRASS" else "-", c[12])
            assertEquals(
                native,
                c[18]
                    .removePrefix("[")
                    .removeSuffix("]")
                    .split(',')
                    .map(String::toInt),
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
