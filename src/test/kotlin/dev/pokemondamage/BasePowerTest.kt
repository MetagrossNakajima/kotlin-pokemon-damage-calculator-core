package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.power.BasePower
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.FaintedAllies
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
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.TimesHit
import dev.pokemondamage.model.ToxicCounter
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class BasePowerTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun power(
        name: String,
        a: PokemonState = pokemon,
        d: PokemonState = pokemon,
        input: Int = 50,
        type: PokemonType = PokemonType.NORMAL,
        hit: Int = 0,
    ): Long =
        BasePower.calculate(
            DamageContext(
                DamageRequest(
                    a,
                    d,
                    Move(MoveId(name), type, input, Category.PHYSICAL),
                    hitIndex = hit.toLong(),
                ),
            ),
        )

    private fun weight(value: Int) =
        pokemon.copy(profile = pokemon.profile.copy(weight = PokemonWeight(value)))

    @Test
    fun `ordinary power is caller supplied and move preparation happens first`() {
        assertEquals(73L, power("Custom", input = 73))
        assertEquals(0L, power("SeismicToss", input = 0))
        assertEquals(100L, power("TeraBlast", pokemon.copy(teraType = TeraType.STELLAR)))
    }

    @TestFactory
    fun `escalating hit power preserves exact hit positions`() =
        listOf("TripleAxel", "TripleKick").map { name ->
            dynamicTest(name) {
                assertEquals(
                    listOf(20L, 40L, 60L),
                    (0..2).map { power(name, input = 20, hit = it) },
                )
                assertEquals(2147483648000L, power(name, input = 1000, hit = Int.MAX_VALUE))
            }
        }

    @TestFactory
    fun `absolute weight moves cover every threshold on both sides`() =
        listOf("LowKick", "GrassKnot").map { name ->
            dynamicTest(name) {
                val cases =
                    mapOf(
                        1 to 20L,
                        99 to 20L,
                        100 to 40L,
                        101 to 40L,
                        249 to 40L,
                        250 to 60L,
                        251 to 60L,
                        499 to 60L,
                        500 to 80L,
                        501 to 80L,
                        999 to 80L,
                        1000 to 100L,
                        1001 to 100L,
                        1999 to 100L,
                        2000 to 120L,
                        2001 to 120L,
                        9999 to 120L,
                    )
                for ((weight, expected) in cases) {
                    assertEquals(
                        expected,
                        power(name, d = weight(weight)),
                        "$weight hg",
                    )
                }
                assertEquals(
                    40L,
                    power(name, d = weight(99).copy(ability = AbilityId("HeavyMetal"))),
                )
                assertEquals(
                    20L,
                    power(name, d = weight(199).copy(ability = AbilityId("LightMetal"))),
                )
                assertEquals(20L, power(name, d = weight(199).copy(item = ItemId("FloatStone"))))
                assertEquals(
                    40L,
                    power(
                        name,
                        a = pokemon.copy(ability = AbilityId("MoldBreaker")),
                        d = weight(199).copy(ability = AbilityId("LightMetal")),
                    ),
                )
            }
        }

    @TestFactory
    fun `relative weight moves cover ratios and independent weight modifiers`() =
        listOf("HeavySlam", "HeatCrash").map { name ->
            dynamicTest(name) {
                for (
                (attacker, expected) in
                mapOf(
                    1 to 40L,
                    199 to 40L,
                    200 to 60L,
                    299 to 60L,
                    300 to 80L,
                    399 to 80L,
                    400 to 100L,
                    499 to 100L,
                    500 to 120L,
                    9999 to 120L,
                )
                ) {
                    assertEquals(
                        expected,
                        power(name, a = weight(attacker), d = weight(100)),
                        "attacker=$attacker hg",
                    )
                }
                assertEquals(
                    120L,
                    power(
                        name,
                        a = weight(250).copy(ability = AbilityId("HeavyMetal")),
                        d = weight(100),
                    ),
                )
                assertEquals(
                    40L,
                    power(
                        name,
                        a = weight(250).copy(ability = AbilityId("LightMetal")),
                        d = weight(100),
                    ),
                )
                assertEquals(
                    40L,
                    power(name, a = weight(250).copy(item = ItemId("FloatStone")), d = weight(100)),
                )
                assertEquals(
                    120L,
                    power(
                        name,
                        a = weight(250),
                        d = weight(100).copy(ability = AbilityId("LightMetal")),
                    ),
                )
            }
        }

    @Test
    fun `Acrobatics uses active item and the source Normal Gem condition`() {
        assertEquals(100L, power("Acrobatics"))
        assertEquals(50L, power("Acrobatics", pokemon.copy(item = ItemId("LifeOrb"))))
        assertEquals(
            100L,
            power("Acrobatics", pokemon.copy(item = ItemId("LifeOrb"), itemConsumed = true)),
        )
        assertEquals(
            100L,
            power(
                "Acrobatics",
                pokemon.copy(item = ItemId("LifeOrb"), ability = AbilityId("Klutz")),
            ),
        )
        assertEquals(100L, power("Acrobatics", pokemon.copy(item = ItemId("NormalGem"))))
        assertEquals(
            50L,
            power(
                "Acrobatics",
                pokemon.copy(item = ItemId("NormalGem")),
                type = PokemonType.FLYING,
            ),
        )
    }

    @Test
    fun `Hex responds to each status and to effective Comatose`() {
        assertEquals(50L, power("Hex"))
        for (status in Status.entries) {
            assertEquals(
                100L,
                power(
                    "Hex",
                    d =
                        pokemon.copy(
                            status = status,
                            toxicCounter = if (status == Status.TOXIC) ToxicCounter(1) else null,
                        ),
                ),
                status.name,
            )
        }
        assertEquals(100L, power("Hex", d = pokemon.copy(ability = AbilityId("Comatose"))))
        assertEquals(
            50L,
            power(
                "Hex",
                d =
                    pokemon.copy(
                        ability = AbilityId("Comatose"),
                        flags = PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true)),
                    ),
            ),
        )
    }

    @TestFactory
    fun `first moving attacks use explicit turn order`() =
        listOf("FishiousRend", "BoltBeak").map { name ->
            dynamicTest(name) {
                assertEquals(50L, power(name))
                assertEquals(
                    100L,
                    power(
                        name,
                        pokemon.copy(flags = PokemonFlags(mapOf(PokemonFlag.MOVES_FIRST to true))),
                    ),
                )
                assertEquals(
                    50L,
                    power(
                        name,
                        pokemon.copy(flags = PokemonFlags(mapOf(PokemonFlag.MOVES_FIRST to false))),
                    ),
                )
            }
        }

    @Test
    fun `Assurance checks the defenders damaged flag`() {
        assertEquals(50L, power("Assurance"))
        assertEquals(
            100L,
            power(
                "Assurance",
                d =
                    pokemon.copy(
                        flags = PokemonFlags(mapOf(PokemonFlag.DAMAGED_THIS_TURN to true)),
                    ),
            ),
        )
        assertEquals(
            50L,
            power(
                "Assurance",
                d =
                    pokemon.copy(
                        flags = PokemonFlags(mapOf(PokemonFlag.DAMAGED_THIS_TURN to false)),
                    ),
            ),
        )
        assertEquals(
            50L,
            power(
                "Assurance",
                a =
                    pokemon.copy(
                        flags = PokemonFlags(mapOf(PokemonFlag.DAMAGED_THIS_TURN to true)),
                    ),
            ),
        )
    }

    @Test
    fun `Last Respects counts all supplied fainted allies while Rage Fist caps at six hits`() {
        for (count in 0..100) {
            assertEquals(
                50L * (1 + count),
                power("LastRespects", pokemon.copy(faintedAllies = FaintedAllies(count))),
            )
        }
        for (
        (count, expected) in
        mapOf(0 to 50L, 1 to 100L, 5 to 300L, 6 to 350L, 7 to 350L, 100 to 350L)
        ) {
            assertEquals(expected, power("RageFist", pokemon.copy(timesHit = TimesHit(count))))
        }
    }

    @TestFactory
    fun `attacker HP moves preserve floor and minimum one`() =
        listOf("Eruption", "WaterSpout", "DragonEnergy").map { name ->
            dynamicTest(name) {
                for (
                (hp, expected) in
                mapOf(1 to 1L, 2 to 1L, 3 to 2L, 100 to 75L, 199 to 149L, 200 to 150L)
                ) {
                    assertEquals(expected, power(name, pokemon.copy(currentHp = hp)))
                }
                assertEquals(150L, power(name))
                assertEquals(
                    1L,
                    power(name, pokemon.copy(stats = pokemon.stats.copy(hp = 999), currentHp = 1)),
                )
            }
        }

    @TestFactory
    fun `Flail and Reversal cover each HP boundary`() =
        listOf("Flail", "Reversal").map { name ->
            dynamicTest(name) {
                val cases =
                    mapOf(
                        1 to 200L,
                        2 to 150L,
                        4 to 150L,
                        5 to 100L,
                        9 to 100L,
                        10 to 80L,
                        16 to 80L,
                        17 to 40L,
                        32 to 40L,
                        33 to 20L,
                        48 to 20L,
                    )
                for ((hp, expected) in cases) {
                    assertEquals(
                        expected,
                        power(
                            name,
                            pokemon.copy(stats = pokemon.stats.copy(hp = 48), currentHp = hp),
                        ),
                        "HP=$hp/48",
                    )
                }
                assertEquals(200L, power(name, pokemon.copy(currentHp = 1)))
            }
        }

    @TestFactory
    fun `target HP moves use current defender HP`() =
        listOf(
            "CrushGrip" to 120L,
            "WringOut" to 120L,
            "HardPress" to 100L,
        ).map { (name, expected) ->
            dynamicTest(name) {
                for (
                (hp, value) in
                listOf(1 to 1L, 100 to expected / 2, 200 to expected)
                ) {
                    assertEquals(
                        value,
                        power(name, d = pokemon.copy(currentHp = hp)),
                        "HP=$hp",
                    )
                }
            }
        }

    @TestFactory
    fun `boost counting moves count positive stages and ignore negative ones`() =
        listOf("StoredPower", "PowerTrip").map { name ->
            dynamicTest(name) {
                assertEquals(20L, power(name))
                assertEquals(
                    620L,
                    power(name, pokemon.copy(stages = StatStages.fromValues(6, 6, 6, 6, 6))),
                )
                assertEquals(
                    20L,
                    power(name, pokemon.copy(stages = StatStages.fromValues(-6, -6, -6, -6, -6))),
                )
                assertEquals(
                    140L,
                    power(name, pokemon.copy(stages = StatStages.fromValues(1, -6, 2, -3, 3))),
                )
                assertEquals(
                    20L,
                    power(name, d = pokemon.copy(stages = StatStages.fromValues(6, 6, 6, 6, 6))),
                )
            }
        }
}
