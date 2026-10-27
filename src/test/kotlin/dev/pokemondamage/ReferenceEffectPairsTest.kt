package dev.pokemondamage

import dev.pokemondamage.fixtures.EffectPairsCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FaintedAllies
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
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

class ReferenceEffectPairsTest {
    @TestFactory
    fun `each effect changes full damage and agrees with native Reference`() =
        EffectPairsCases.all
            .groupBy { it.effect }
            .also { assertEquals(152, it.size) }
            .map { (effect, rows) ->
                dynamicTest(effect) {
                    assertEquals(listOf(false, true), rows.map { it.enabled })
                    val results =
                        rows.map { c ->
                            val profile =
                                PokemonProfile(
                                    PokemonId("Mew"),
                                    PokemonTypes(PokemonType.NORMAL),
                                    PokemonWeight(100),
                                )
                            val stats = Stats(200, 100, 100, 100, 100, 100)
                            val a =
                                PokemonState(
                                    profile.copy(
                                        id = PokemonId(c.attackerSpecies),
                                        gender = c.attackerGender,
                                    ),
                                    stats,
                                    faintedAllies = FaintedAllies(c.fainted),
                                    stages =
                                        StatStages.fromValues(
                                            attack = c.attackerStage,
                                            specialAttack = c.attackerStage,
                                        ),
                                    ability = AbilityId(c.attackerAbility),
                                    item = c.attackerItem?.let(::ItemId),
                                )
                            val d =
                                PokemonState(
                                    profile.copy(
                                        id = PokemonId(c.defenderSpecies),
                                        gender = c.defenderGender,
                                        types = PokemonTypes(c.defenderType),
                                    ),
                                    stats,
                                    status = c.defenderStatus,
                                    sideConditions =
                                        SideConditions(
                                            c.screen,
                                            c.screen,
                                        ),
                                    ability = AbilityId(c.defenderAbility),
                                    item = c.defenderItem?.let(::ItemId),
                                    flags =
                                        PokemonFlags(
                                            mapOf(
                                                PokemonFlag.CAN_EVOLVE to
                                                    (c.defenderSpecies == "Chansey"),
                                            ),
                                        ),
                                )
                            val flags =
                                listOfNotNull(
                                    MoveFlag.CONTACT.takeIf { c.contact },
                                    MoveFlag.SOUND.takeIf { c.sound },
                                    MoveFlag.BULLET.takeIf { c.bullet },
                                    MoveFlag.WIND.takeIf { c.wind },
                                ) +
                                    if (effect == "ItemId/PunchingGlove") {
                                        listOf(MoveFlag.PUNCH)
                                    } else {
                                        emptyList()
                                    }
                            val request =
                                DamageRequest(
                                    a,
                                    d,
                                    Move(
                                        MoveId(c.move),
                                        c.type,
                                        80,
                                        c.category,
                                        flags = EnumFlags(*flags.toTypedArray()),
                                    ),
                                    field =
                                        BattleField(
                                            effects =
                                                EnumFlags(
                                                    *listOfNotNull(c.fieldEffect).toTypedArray(),
                                                ),
                                            weather =
                                                c.weather,
                                        ),
                                    critical = c.critical,
                                )
                            val actual =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(request),
                                ).value
                                    .hit
                                    .rolls
                            val encoded =
                                c.damage
                            val expected =
                                if (encoded.size == 1) List(16) { encoded.single() } else encoded
                            assertEquals(expected, actual, "$effect enabled=${c.enabled}")
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
