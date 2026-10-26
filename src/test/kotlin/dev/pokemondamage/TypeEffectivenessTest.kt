package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.TypeEffectiveness
import dev.pokemondamage.model.*
import dev.pokemondamage.rules.TypeChart
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class TypeEffectivenessTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(40)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun defender(type: PokemonType, secondary: PokemonType? = null) =
        pokemon.copy(profile = pokemon.profile.copy(types = PokemonTypes(type, secondary)))

    private fun context(
        type: PokemonType,
        a: PokemonState = pokemon,
        d: PokemonState = pokemon,
        name: String = "Tackle",
        gravity: Boolean = false,
        flags: EnumFlags<MoveFlag> = EnumFlags(),
    ) =
        DamageContext(
            DamageRequest(
                a,
                d,
                Move(MoveId(name), type, 50, Category.SPECIAL, flags = flags),
                BattleField(gravity = gravity),
            ),
        )

    private fun effect(
        type: PokemonType,
        a: PokemonState = pokemon,
        d: PokemonState = pokemon,
        name: String = "Tackle",
        gravity: Boolean = false,
        flags: EnumFlags<MoveFlag> = EnumFlags(),
    ) = TypeEffectiveness.calculate(context(type, a, d, name, gravity, flags))

    @Test
    fun `ordinary type combinations multiply and tera replaces defensive typing`() {
        for (attack in PokemonType.entries) for (primary in PokemonType.entries) {
            assertEquals(
                TypeChart.effectiveness(attack, primary),
                effect(attack, d = defender(primary)),
            )
            for (secondary in PokemonType.entries.filter { it != primary }) {
                val expected =
                    TypeChart.effectiveness(attack, primary) *
                        TypeChart.effectiveness(attack, secondary)
                assertEquals(expected, effect(attack, d = defender(primary, secondary)))
                assertEquals(
                    TypeChart.effectiveness(attack, PokemonType.WATER),
                    effect(
                        attack,
                        d = defender(primary, secondary).copy(teraType = TeraType.WATER),
                    ),
                )
            }
        }
    }

    @Test
    fun `Stellar is neutral before tera and super effective against every tera type`() {
        val attacker = pokemon.copy(teraType = TeraType.STELLAR)
        assertEquals(1.0, effect(PokemonType.NORMAL, attacker, name = "TeraBlast"))
        for (type in TeraType.entries) assertEquals(
            2.0,
            effect(PokemonType.NORMAL, attacker, pokemon.copy(teraType = type), "TeraBlast"),
        )
    }

    @TestFactory
    fun `Scrappy and Minds Eye lift only Normal and Fighting Ghost immunity`() =
        listOf("Scrappy", "MindsEye").map { name ->
            dynamicTest(name) {
                val attacker = pokemon.copy(ability = AbilityId(name))
                assertEquals(1.0, effect(PokemonType.NORMAL, attacker, defender(PokemonType.GHOST)))
                assertEquals(
                    2.0,
                    effect(
                        PokemonType.FIGHTING,
                        attacker,
                        defender(PokemonType.GHOST, PokemonType.NORMAL),
                    ),
                )
                assertEquals(0.0, effect(PokemonType.PSYCHIC, attacker, defender(PokemonType.DARK)))
            }
        }

    @Test
    fun `Ring Target lifts type immunity while preserving second-type resistance`() {
        val ghostSteel =
            defender(PokemonType.GHOST, PokemonType.STEEL).copy(item = ItemId("RingTarget"))
        assertEquals(0.5, effect(PokemonType.NORMAL, d = ghostSteel))
        assertEquals(1.0, effect(PokemonType.WATER, d = ghostSteel))
        assertEquals(0.0, effect(PokemonType.NORMAL, d = ghostSteel.copy(itemConsumed = true)))
        assertEquals(
            0.0,
            effect(PokemonType.NORMAL, d = ghostSteel.copy(ability = AbilityId("Klutz"))),
        )
        assertEquals(
            0.0,
            effect(PokemonType.WATER, d = ghostSteel.copy(ability = AbilityId("WaterAbsorb"))),
        )
    }

    @Test
    fun `Gravity and explicit grounding preserve Ground effectiveness of the second type`() {
        val flyingSteel = defender(PokemonType.FLYING, PokemonType.STEEL)
        assertEquals(0.0, effect(PokemonType.GROUND, d = flyingSteel))
        assertEquals(2.0, effect(PokemonType.GROUND, d = flyingSteel, gravity = true))
        assertEquals(
            2.0,
            effect(
                PokemonType.GROUND,
                d = flyingSteel.copy(flags = PokemonFlags(mapOf(PokemonFlag.GROUNDED to true))),
            ),
        )
        assertEquals(
            0.0,
            effect(
                PokemonType.GROUND,
                d = flyingSteel.copy(flags = PokemonFlags(mapOf(PokemonFlag.GROUNDED to false))),
            ),
        )
        assertEquals(
            1.0,
            effect(PokemonType.GROUND, d = flyingSteel.copy(item = ItemId("IronBall"))),
        )
        assertEquals(1.0, effect(PokemonType.GROUND, d = flyingSteel, name = "ThousandArrows"))
        assertEquals(
            2.0,
            effect(PokemonType.GROUND, d = defender(PokemonType.STEEL), name = "ThousandArrows"),
        )
        assertEquals(
            0.0,
            effect(
                PokemonType.NORMAL,
                d = defender(PokemonType.GHOST).copy(item = ItemId("IronBall")),
            ),
        )
    }

    @Test
    fun `Freeze Dry overrides Water matchup and Flying Press multiplies both attack types`() {
        assertEquals(
            2.0,
            effect(PokemonType.ICE, d = defender(PokemonType.WATER), name = "FreezeDry"),
        )
        assertEquals(
            4.0,
            effect(
                PokemonType.ICE,
                d = defender(PokemonType.WATER, PokemonType.FLYING),
                name = "FreezeDry",
            ),
        )
        assertEquals(
            0.5,
            effect(PokemonType.ICE, d = defender(PokemonType.STEEL), name = "FreezeDry"),
        )
        for (type in PokemonType.entries) {
            val expected =
                TypeChart.effectiveness(PokemonType.FIGHTING, type) *
                    TypeChart.effectiveness(PokemonType.FLYING, type)
            assertEquals(
                expected,
                effect(PokemonType.FIGHTING, d = defender(type), name = "FlyingPress"),
                type.name,
            )
        }
    }

    @TestFactory
    fun `element absorbing abilities block matching types and obey Mold Breaker`() =
        listOf(
                "EarthEater" to PokemonType.GROUND,
                "FlashFire" to PokemonType.FIRE,
                "WellBakedBody" to PokemonType.FIRE,
                "WaterAbsorb" to PokemonType.WATER,
                "StormDrain" to PokemonType.WATER,
                "DrySkin" to PokemonType.WATER,
                "VoltAbsorb" to PokemonType.ELECTRIC,
                "LightningRod" to PokemonType.ELECTRIC,
                "MotorDrive" to PokemonType.ELECTRIC,
                "SapSipper" to PokemonType.GRASS,
            )
            .map { (name, type) ->
                dynamicTest(name) {
                    val target = pokemon.copy(ability = AbilityId(name))
                    assertEquals(0.0, effect(type, d = target))
                    assertEquals(1.0, effect(PokemonType.NORMAL, d = target))
                    assertEquals(
                        1.0,
                        effect(type, pokemon.copy(ability = AbilityId("MoldBreaker")), target),
                    )
                    assertEquals(
                        0.0,
                        effect(
                            type,
                            pokemon.copy(ability = AbilityId("MoldBreaker")),
                            target.copy(item = ItemId("AbilityShield")),
                        ),
                    )
                }
            }

    @TestFactory
    fun `Levitate and Eelevate are bypassed by grounding or Thousand Arrows`() =
        listOf("Levitate", "Eelevate").map { name ->
            dynamicTest(name) {
                val target = pokemon.copy(ability = AbilityId(name))
                assertEquals(0.0, effect(PokemonType.GROUND, d = target))
                assertEquals(1.0, effect(PokemonType.GROUND, d = target, gravity = true))
                assertEquals(1.0, effect(PokemonType.GROUND, d = target, name = "ThousandArrows"))
                assertEquals(
                    1.0,
                    effect(PokemonType.GROUND, d = target.copy(item = ItemId("IronBall"))),
                )
                assertEquals(
                    1.0,
                    effect(
                        PokemonType.GROUND,
                        d = target.copy(flags = PokemonFlags(mapOf(PokemonFlag.GROUNDED to true))),
                    ),
                )
                assertEquals(
                    1.0,
                    effect(
                        PokemonType.GROUND,
                        pokemon.copy(ability = AbilityId("MoldBreaker")),
                        target,
                    ),
                )
            }
        }

    @Test
    fun `Air Balloon blocks Ground but Earth Eater still blocks Thousand Arrows under Gravity`() {
        val target = pokemon.copy(item = ItemId("AirBalloon"))
        assertEquals(0.0, effect(PokemonType.GROUND, d = target))
        assertEquals(1.0, effect(PokemonType.GROUND, d = target, name = "ThousandArrows"))
        assertEquals(1.0, effect(PokemonType.GROUND, d = target, gravity = true))
        assertEquals(1.0, effect(PokemonType.GROUND, d = target.copy(itemConsumed = true)))
        assertEquals(
            1.0,
            effect(
                PokemonType.GROUND,
                d = pokemon.copy(flags = PokemonFlags(mapOf(PokemonFlag.GROUNDED to false))),
            ),
        )
        assertEquals(
            0.0,
            effect(
                PokemonType.GROUND,
                d = pokemon.copy(ability = AbilityId("EarthEater")),
                name = "ThousandArrows",
                gravity = true,
            ),
        )
    }

    @TestFactory
    fun `move trait immunities require their respective flags`() =
        listOf(
                "Soundproof" to MoveFlag.SOUND,
                "Bulletproof" to MoveFlag.BULLET,
                "WindRider" to MoveFlag.WIND,
            )
            .map { (name, flag) ->
                dynamicTest(name) {
                    val target = pokemon.copy(ability = AbilityId(name))
                    assertEquals(
                        0.0,
                        effect(PokemonType.NORMAL, d = target, flags = EnumFlags(flag)),
                    )
                    assertEquals(1.0, effect(PokemonType.NORMAL, d = target))
                    assertEquals(1.0, effect(PokemonType.NORMAL, flags = EnumFlags(flag)))
                    assertEquals(
                        1.0,
                        effect(
                            PokemonType.NORMAL,
                            pokemon.copy(ability = AbilityId("MoldBreaker")),
                            target,
                            flags = EnumFlags(flag),
                        ),
                    )
                }
            }

    @Test
    fun `Wonder Guard uses combined effectiveness and Tera Shell preserves immunities`() {
        val wonder = defender(PokemonType.GRASS).copy(ability = AbilityId("WonderGuard"))
        assertEquals(2.0, effect(PokemonType.FIRE, d = wonder))
        assertEquals(0.0, effect(PokemonType.NORMAL, d = wonder))
        assertEquals(0.0, effect(PokemonType.GRASS, d = wonder))
        assertEquals(
            0.0,
            effect(
                PokemonType.FIRE,
                d =
                    wonder.copy(
                        profile =
                            wonder.profile.copy(
                                types = PokemonTypes(PokemonType.GRASS, PokemonType.WATER),
                            ),
                    ),
            ),
        )
        val shell = defender(PokemonType.GHOST).copy(ability = AbilityId("TeraShell"))
        assertEquals(0.0, effect(PokemonType.NORMAL, d = shell))
        assertEquals(0.5, effect(PokemonType.GHOST, d = shell))
        assertEquals(0.5, effect(PokemonType.WATER, d = shell.copy(currentHp = 1)))
        assertEquals(
            2.0,
            effect(PokemonType.GHOST, pokemon.copy(ability = AbilityId("MoldBreaker")), shell),
        )
    }
}
