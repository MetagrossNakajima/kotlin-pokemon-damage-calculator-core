package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ReferenceEffectPairsTest {
    @TestFactory
    fun `each effect changes full damage and agrees with native Reference`() =
        javaClass
            .getResourceAsStream("/reference/effect-pairs.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(152, it.size) }
            .map { (effect, rows) ->
                dynamicTest(effect) {
                    assertEquals(listOf("false", "true"), rows.map { it[1] })
                    val results = rows.map { c ->
                        val profile =
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.NORMAL),
                                PokemonWeight(100),
                            )
                        val stats = Stats(200, 100, 100, 100, 100, 100)
                        val a =
                            PokemonState(
                                profile.copy(id = PokemonId(c[15]), gender = Gender.valueOf(c[23])),
                                stats,
                                faintedAllies = c[25].toInt(),
                                stages =
                                    StatStages(
                                        attack = c[22].toInt(),
                                        specialAttack = c[22].toInt(),
                                    ),
                                ability = AbilityId(c[2]),
                                item = c[4].takeUnless { it == "-" }?.let(::ItemId),
                            )
                        val d =
                            PokemonState(
                                profile.copy(
                                    id = PokemonId(c[16]),
                                    gender = Gender.valueOf(c[24]),
                                    types = PokemonTypes(PokemonType.valueOf(c[7])),
                                ),
                                stats,
                                status = c[21].takeUnless { it == "-" }?.let(Status::valueOf),
                                sideConditions =
                                    SideConditions(
                                        c[20].toBooleanStrict(),
                                        c[20].toBooleanStrict(),
                                    ),
                                ability = AbilityId(c[3]),
                                item = c[5].takeUnless { it == "-" }?.let(::ItemId),
                                flags =
                                    PokemonFlags(
                                        mapOf(PokemonFlag.CAN_EVOLVE to (c[16] == "Chansey")),
                                    ),
                            )
                        val flags =
                            listOf(MoveFlag.CONTACT, MoveFlag.SOUND, MoveFlag.BULLET, MoveFlag.WIND)
                                .filterIndexed { index, _ -> c[9 + index].toBooleanStrict() } +
                                if (effect == "ItemId/PunchingGlove") listOf(MoveFlag.PUNCH)
                                else emptyList()
                        val request =
                            DamageRequest(
                                a,
                                d,
                                Move(
                                    MoveId(c[18]),
                                    PokemonType.valueOf(c[6]),
                                    80,
                                    Category.valueOf(c[8]),
                                    flags = EnumFlags(*flags.toTypedArray()),
                                ),
                                field =
                                    BattleField(
                                        effects =
                                            EnumFlags(
                                                *c[19]
                                                    .takeUnless { it == "-" }
                                                    ?.let { arrayOf(FieldEffect.valueOf(it)) }
                                                    .orEmpty(),
                                            ),
                                        weather =
                                            c[17].takeUnless { it == "-" }?.let(Weather::valueOf),
                                    ),
                                critical = c[13].toBooleanStrict(),
                            )
                        val actual =
                            assertIs<Calculation.Success<DamageResult>>(calculateDamage(request))
                                .value
                                .hit
                                .rolls
                        val encoded =
                            c[14].removePrefix("[").removeSuffix("]").split(',').map(String::toInt)
                        val expected =
                            if (encoded.size == 1) List(16) { encoded.single() } else encoded
                        assertEquals(expected, actual, "$effect enabled=${c[1]}")
                        actual
                    }
                    assertNotEquals(
                        results[0],
                        results[1],
                        "$effect must change final damage compared with its control",
                    )
                }
            }
}
