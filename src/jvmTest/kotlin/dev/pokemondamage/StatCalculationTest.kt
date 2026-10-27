package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.stats.AttackStat
import dev.pokemondamage.engine.stats.DefenseStat
import dev.pokemondamage.engine.stats.ParadoxBoost
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
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
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StatCalculationTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(40)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun context(
        a: PokemonState = pokemon,
        d: PokemonState = pokemon,
        category: Category = Category.PHYSICAL,
        type: PokemonType = PokemonType.NORMAL,
        name: String = "Tackle",
        effects: EnumFlags<FieldEffect> = EnumFlags(),
        weather: Weather? = null,
    ) = DamageContext(
        DamageRequest(
            a,
            d,
            Move(MoveId(name), type, 50, category),
            BattleField(weather = weather, effects = effects),
        ),
    )

    private fun attack(
        c: DamageContext,
        critical: Boolean = false,
    ) = AttackStat.calculate(c, critical).value

    private fun defense(
        c: DamageContext,
        critical: Boolean = false,
    ) = DefenseStat.calculate(c, critical).value

    private fun species(name: String) = pokemon.profile.copy(id = PokemonId(name))

    private data class Effect(
        val id: String,
        val category: Category,
        val type: PokemonType,
        val expected: Int,
    )

    @TestFactory
    fun `individual attack ability effects`() =
        listOf(
            Effect("SlowStart", Category.PHYSICAL, PokemonType.NORMAL, 50),
            Effect("Defeatist", Category.PHYSICAL, PokemonType.NORMAL, 50),
            Effect("Transistor", Category.SPECIAL, PokemonType.ELECTRIC, 130),
            Effect("HadronEngine", Category.SPECIAL, PokemonType.NORMAL, 133),
            Effect("OrichalcumPulse", Category.PHYSICAL, PokemonType.NORMAL, 133),
            Effect("FlowerGift", Category.PHYSICAL, PokemonType.NORMAL, 150),
            Effect("Guts", Category.PHYSICAL, PokemonType.NORMAL, 150),
            Effect("Overgrow", Category.SPECIAL, PokemonType.GRASS, 150),
            Effect("Blaze", Category.SPECIAL, PokemonType.FIRE, 150),
            Effect("Torrent", Category.PHYSICAL, PokemonType.WATER, 150),
            Effect("Swarm", Category.PHYSICAL, PokemonType.BUG, 150),
            Effect("FlashFire", Category.SPECIAL, PokemonType.FIRE, 150),
            Effect("SolarPower", Category.SPECIAL, PokemonType.NORMAL, 150),
            Effect("Plus", Category.SPECIAL, PokemonType.NORMAL, 150),
            Effect("Minus", Category.SPECIAL, PokemonType.NORMAL, 150),
            Effect("RockyPayload", Category.PHYSICAL, PokemonType.ROCK, 150),
            Effect("Steelworker", Category.SPECIAL, PokemonType.STEEL, 150),
            Effect("FireMane", Category.SPECIAL, PokemonType.FIRE, 150),
            Effect("DragonsMaw", Category.SPECIAL, PokemonType.DRAGON, 150),
            Effect("GorillaTactics", Category.PHYSICAL, PokemonType.NORMAL, 150),
            Effect("HugePower", Category.PHYSICAL, PokemonType.NORMAL, 200),
            Effect("PurePower", Category.PHYSICAL, PokemonType.NORMAL, 200),
            Effect("WaterBubble", Category.SPECIAL, PokemonType.WATER, 200),
            Effect("Stakeout", Category.PHYSICAL, PokemonType.NORMAL, 200),
        ).map { e ->
            dynamicTest(e.id) {
                val c =
                    context(
                        a = pokemon.copy(ability = AbilityId(e.id)),
                        category = e.category,
                        type = e.type,
                    )
                assertEquals(e.expected, attack(c))
                assertEquals(
                    listOf("Rank", e.id, "attackModifiers"),
                    AttackStat.calculate(c, false).trace.map { it.id },
                )
                val suppressed =
                    pokemon.copy(
                        ability = AbilityId(e.id),
                        flags = PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true)),
                    )
                assertEquals(
                    100,
                    attack(context(a = suppressed, category = e.category, type = e.type)),
                )
            }
        }

    @Test
    fun `category and type restrictions do not activate unrelated attack modifiers`() {
        for (
        name in
        listOf(
            "SlowStart",
            "OrichalcumPulse",
            "FlowerGift",
            "Guts",
            "GorillaTactics",
            "HugePower",
            "PurePower",
        )
        ) {
            assertEquals(
                100,
                attack(
                    context(
                        a = pokemon.copy(ability = AbilityId(name)),
                        category = Category.SPECIAL,
                    ),
                ),
                name,
            )
        }
        for (name in listOf("HadronEngine", "SolarPower", "Plus", "Minus")) {
            assertEquals(100, attack(context(a = pokemon.copy(ability = AbilityId(name)))), name)
        }
        for (
        name in
        listOf(
            "Transistor",
            "FlashFire",
            "WaterBubble",
            "Overgrow",
            "Blaze",
            "Torrent",
            "Swarm",
            "RockyPayload",
            "Steelworker",
            "FireMane",
            "DragonsMaw",
        )
        ) {
            assertEquals(100, attack(context(a = pokemon.copy(ability = AbilityId(name)))), name)
        }
        assertEquals(
            50,
            attack(
                context(
                    a = pokemon.copy(ability = AbilityId("Defeatist")),
                    category = Category.SPECIAL,
                ),
            ),
        )
        assertEquals(
            200,
            attack(
                context(
                    a = pokemon.copy(ability = AbilityId("Stakeout")),
                    category = Category.SPECIAL,
                ),
            ),
        )
    }

    @TestFactory
    fun `defender abilities reducing attacking stat`() =
        listOf(
            "ThickFat" to PokemonType.FIRE,
            "ThickFat" to PokemonType.ICE,
            "Heatproof" to PokemonType.FIRE,
            "WaterBubble" to PokemonType.FIRE,
            "PurifyingSalt" to PokemonType.GHOST,
        ).map { (name, type) ->
            dynamicTest("$name/$type") {
                val defender = pokemon.copy(ability = AbilityId(name))
                assertEquals(50, attack(context(d = defender, type = type)))
                assertEquals(100, attack(context(d = defender)))
                assertEquals(
                    100,
                    attack(
                        context(
                            a = pokemon.copy(ability = AbilityId("MoldBreaker")),
                            d = defender,
                            type = type,
                        ),
                    ),
                )
            }
        }

    @Test
    fun `attack ruin abilities and fields respect category and same-ability immunity`() {
        for (
        (name, category, effect) in
        listOf(
            Triple("VesselofRuin", Category.SPECIAL, FieldEffect.VESSEL_OF_RUIN),
            Triple("TabletsofRuin", Category.PHYSICAL, FieldEffect.TABLETS_OF_RUIN),
        )
        ) {
            val other = if (category == Category.PHYSICAL) Category.SPECIAL else Category.PHYSICAL
            val bearer = pokemon.copy(ability = AbilityId(name))
            assertEquals(75, attack(context(d = bearer, category = category)))
            assertEquals(75, attack(context(category = category, effects = EnumFlags(effect))))
            assertEquals(
                75,
                attack(context(d = bearer, category = category, effects = EnumFlags(effect))),
            )
            assertEquals(
                100,
                attack(
                    context(
                        a = bearer,
                        d = bearer,
                        category = category,
                        effects = EnumFlags(effect),
                    ),
                ),
            )
            assertEquals(
                100,
                attack(context(d = bearer, category = other, effects = EnumFlags(effect))),
            )
            assertEquals(
                75,
                attack(
                    context(
                        a = pokemon.copy(ability = AbilityId("MoldBreaker")),
                        d = bearer,
                        category = category,
                    ),
                ),
            )
        }
    }

    @Test
    fun `ally attack effects apply once and only to their designated category or type`() {
        assertEquals(150, attack(context(effects = EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT))))
        assertEquals(
            100,
            attack(
                context(
                    category = Category.SPECIAL,
                    effects = EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT),
                ),
            ),
        )
        assertEquals(
            150,
            attack(
                context(
                    a = pokemon.copy(ability = AbilityId("FlowerGift")),
                    effects = EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT),
                ),
            ),
        )
        assertEquals(
            150,
            attack(
                context(type = PokemonType.STEEL, effects = EnumFlags(FieldEffect.STEELY_SPIRIT)),
            ),
        )
        assertEquals(100, attack(context(effects = EnumFlags(FieldEffect.STEELY_SPIRIT))))
    }

    @TestFactory
    fun `species-specific attack items`() =
        listOf(
            Triple("ThickClub", "Marowak", Category.PHYSICAL),
            Triple("ThickClub", "Marowak-Alola", Category.PHYSICAL),
            Triple("ThickClub", "Cubone", Category.PHYSICAL),
            Triple("DeepSeaTooth", "Clamperl", Category.SPECIAL),
            Triple("LightBall", "Pikachu", Category.PHYSICAL),
            Triple("LightBall", "Pikachu", Category.SPECIAL),
        ).map { (item, species, category) ->
            dynamicTest("$item/$species/$category") {
                val attacker = pokemon.copy(profile = species(species), item = ItemId(item))
                assertEquals(200, attack(context(a = attacker, category = category)))
                assertEquals(
                    100,
                    attack(
                        context(
                            a = attacker.copy(profile = pokemon.profile),
                            category = category,
                        ),
                    ),
                )
                assertEquals(
                    100,
                    attack(
                        context(a = attacker.copy(itemConsumed = true), category = category),
                    ),
                )
            }
        }

    @Test
    fun `attack items enforce category`() {
        for (
        (item, category) in
        listOf("ChoiceBand" to Category.PHYSICAL, "ChoiceSpecs" to Category.SPECIAL)
        ) {
            val attacker = pokemon.copy(item = ItemId(item))
            assertEquals(150, attack(context(a = attacker, category = category)))
            assertEquals(
                100,
                attack(
                    context(
                        a = attacker,
                        category =
                            if (category == Category.PHYSICAL) {
                                Category.SPECIAL
                            } else {
                                Category.PHYSICAL
                            },
                    ),
                ),
            )
        }
        assertEquals(
            100,
            attack(
                context(
                    a = pokemon.copy(profile = species("Cubone"), item = ItemId("ThickClub")),
                    category = Category.SPECIAL,
                ),
            ),
        )
        assertEquals(
            100,
            attack(
                context(
                    a = pokemon.copy(profile = species("Clamperl"), item = ItemId("DeepSeaTooth")),
                ),
            ),
        )
    }

    @TestFactory
    fun `individual defense abilities`() =
        listOf(
            "FlowerGift" to Category.SPECIAL,
            "MarvelScale" to Category.PHYSICAL,
            "GrassPelt" to Category.PHYSICAL,
            "FurCoat" to Category.PHYSICAL,
        ).map { (name, category) ->
            dynamicTest(name) {
                val defender = pokemon.copy(ability = AbilityId(name))
                assertEquals(
                    if (name == "FurCoat") 200 else 150,
                    defense(context(d = defender, category = category)),
                )
                assertEquals(
                    100,
                    defense(
                        context(
                            d = defender,
                            category =
                                if (category == Category.PHYSICAL) {
                                    Category.SPECIAL
                                } else {
                                    Category.PHYSICAL
                                },
                        ),
                    ),
                )
                assertEquals(
                    100,
                    defense(
                        context(
                            a = pokemon.copy(ability = AbilityId("MoldBreaker")),
                            d = defender,
                            category = category,
                        ),
                    ),
                )
            }
        }

    @Test
    fun `defense ruin effects respect defensive category and same-ability immunity`() {
        for (
        (name, category, effect) in
        listOf(
            Triple("BeadsofRuin", Category.SPECIAL, FieldEffect.BEADS_OF_RUIN),
            Triple("SwordofRuin", Category.PHYSICAL, FieldEffect.SWORD_OF_RUIN),
        )
        ) {
            val bearer = pokemon.copy(ability = AbilityId(name))
            assertEquals(75, defense(context(a = bearer, category = category)))
            assertEquals(75, defense(context(category = category, effects = EnumFlags(effect))))
            assertEquals(
                100,
                defense(
                    context(
                        a = bearer,
                        d = bearer,
                        category = category,
                        effects = EnumFlags(effect),
                    ),
                ),
            )
            assertEquals(
                100,
                defense(
                    context(
                        a = bearer,
                        category =
                            if (category == Category.PHYSICAL) {
                                Category.SPECIAL
                            } else {
                                Category.PHYSICAL
                            },
                        effects = EnumFlags(effect),
                    ),
                ),
            )
        }
        assertEquals(
            150,
            defense(
                context(
                    category = Category.SPECIAL,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            ),
        )
        assertEquals(100, defense(context(effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT))))
    }

    @Test
    fun `Eviolite requires explicit evolution eligibility and Assault Vest uses special defense`() {
        val eviolite = pokemon.copy(item = ItemId("Eviolite"))
        assertEquals(100, defense(context(d = eviolite)))
        assertEquals(
            100,
            defense(
                context(
                    d = eviolite.copy(flags = PokemonFlags(mapOf(PokemonFlag.CAN_EVOLVE to false))),
                ),
            ),
        )
        for (category in Category.entries) {
            assertEquals(
                150,
                defense(
                    context(
                        d =
                            eviolite.copy(
                                flags = PokemonFlags(mapOf(PokemonFlag.CAN_EVOLVE to true)),
                            ),
                        category = category,
                    ),
                ),
            )
        }
        val vest = pokemon.copy(item = ItemId("AssaultVest"))
        assertEquals(100, defense(context(d = vest)))
        assertEquals(150, defense(context(d = vest, category = Category.SPECIAL)))
        assertEquals(
            100,
            defense(context(d = vest, category = Category.SPECIAL, name = "Psyshock")),
        )
    }

    @Test
    fun `Deep Sea Scale and Metal Powder require correct species and battle state`() {
        val scale = pokemon.copy(profile = species("Clamperl"), item = ItemId("DeepSeaScale"))
        assertEquals(200, defense(context(d = scale, category = Category.SPECIAL)))
        assertEquals(100, defense(context(d = scale)))
        assertEquals(
            100,
            defense(
                context(d = scale.copy(profile = pokemon.profile), category = Category.SPECIAL),
            ),
        )
        val powder = pokemon.copy(profile = species("Ditto"), item = ItemId("MetalPowder"))
        assertEquals(200, defense(context(d = powder)))
        assertEquals(100, defense(context(d = powder, category = Category.SPECIAL)))
        assertEquals(100, defense(context(d = powder.copy(profile = pokemon.profile))))
        assertEquals(
            100,
            defense(
                context(
                    d = powder.copy(flags = PokemonFlags(mapOf(PokemonFlag.TRANSFORMED to true))),
                ),
            ),
        )
        assertEquals(
            200,
            defense(
                context(
                    d = powder.copy(flags = PokemonFlags(mapOf(PokemonFlag.TRANSFORMED to false))),
                ),
            ),
        )
    }

    @Test
    fun `critical and Unaware ignore only the specified stages`() {
        for (stage in -6..6) {
            val attacker =
                pokemon.copy(
                    stages = StatStages.fromValues(attack = stage, specialAttack = stage),
                )
            val defender =
                pokemon.copy(
                    stages = StatStages.fromValues(defense = stage, specialDefense = stage),
                )
            val expected =
                listOf(25, 28, 33, 40, 50, 66, 100, 150, 200, 250, 300, 350, 400)[stage + 6]
            for (category in Category.entries) {
                val c = context(attacker, defender, category)
                assertEquals(expected, attack(c))
                assertEquals(expected, defense(c))
                assertEquals(if (stage < 0) 100 else expected, attack(c, true))
                assertEquals(if (stage > 0) 100 else expected, defense(c, true))
                assertEquals(
                    100,
                    attack(
                        context(attacker, defender.copy(ability = AbilityId("Unaware")), category),
                    ),
                )
                assertEquals(
                    100,
                    defense(
                        context(attacker.copy(ability = AbilityId("Unaware")), defender, category),
                    ),
                )
            }
        }
        for (name in listOf("SacredSword", "ChipAway", "DarkestLariat")) {
            assertEquals(
                100,
                defense(
                    context(
                        d = pokemon.copy(stages = StatStages.fromValues(defense = 6)),
                        name = name,
                    ),
                ),
            )
            assertEquals(
                100,
                defense(
                    context(
                        d = pokemon.copy(stages = StatStages.fromValues(defense = -6)),
                        name = name,
                    ),
                ),
            )
        }
    }

    @Test
    fun `Foul Play borrows only defender attack and stages while Body Press uses defense`() {
        val attacker = pokemon.copy(ability = AbilityId("HugePower"), item = ItemId("ChoiceBand"))
        val defender =
            pokemon.copy(
                stats = pokemon.stats.copy(attack = 120),
                stages = StatStages.fromValues(attack = 1),
                ability = AbilityId("Defeatist"),
                item = ItemId("ChoiceBand"),
            )
        assertEquals(540, attack(context(attacker, defender, name = "FoulPlay")))
        val press =
            pokemon.copy(
                stats = pokemon.stats.copy(defense = 120),
                stages = StatStages.fromValues(defense = 1),
                ability = AbilityId("HugePower"),
            )
        assertEquals(360, attack(context(press, name = "BodyPress")))
        assertEquals(
            240,
            attack(
                context(press, name = "BodyPress", effects = EnumFlags(FieldEffect.WONDER_ROOM)),
            ),
        )
    }

    @Test
    fun `Hustle is rounded separately before the attack modifier chain`() {
        val attacker =
            pokemon.copy(
                stats = pokemon.stats.copy(attack = 101),
                ability = AbilityId("Hustle"),
                item = ItemId("ChoiceBand"),
            )
        val result = AttackStat.calculate(context(attacker), false)
        assertEquals(226, result.value)
        assertEquals(
            listOf("Rank", "Hustle", "ChoiceBand", "attackModifiers"),
            result.trace.map { it.id },
        )
        assertEquals(101L, result.trace[1].before)
        assertEquals(151L, result.trace[1].after)
        assertEquals(6144L, result.trace[1].numerator)
        assertEquals(100, attack(context(attacker, category = Category.SPECIAL)))
    }

    @Test
    fun `Body Press uses original Defense with Special Defense stages in Wonder Room`() {
        val attacker =
            pokemon.copy(
                stats = pokemon.stats.copy(defense = 120, specialDefense = 300),
                stages = StatStages.fromValues(defense = 2, specialDefense = -2),
            )
        val c = context(attacker, name = "BodyPress", effects = EnumFlags(FieldEffect.WONDER_ROOM))
        assertEquals(60, attack(c))
        assertEquals(120, attack(c, true))
        val reduced =
            attacker.copy(
                stages = StatStages.fromValues(defense = -2, specialDefense = 2),
            )
        val negative =
            context(reduced, name = "BodyPress", effects = EnumFlags(FieldEffect.WONDER_ROOM))
        assertEquals(240, attack(negative))
        assertEquals(240, attack(negative, true))
    }

    @Test
    fun `Wonder Room swaps raw defensive stats but preserves category stages`() {
        val defender =
            pokemon.copy(
                stats = pokemon.stats.copy(defense = 80, specialDefense = 150),
                stages = StatStages.fromValues(defense = 2, specialDefense = -1),
            )
        assertEquals(160, defense(context(d = defender)))
        assertEquals(100, defense(context(d = defender, category = Category.SPECIAL)))
        assertEquals(
            300,
            defense(context(d = defender, effects = EnumFlags(FieldEffect.WONDER_ROOM))),
        )
        assertEquals(
            53,
            defense(
                context(
                    d = defender,
                    category = Category.SPECIAL,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            ),
        )
    }

    @Test
    fun `weather defense uses current types and correct defensive category`() {
        for (
        (weather, type, category) in
        listOf(
            Triple(Weather.SANDSTORM, PokemonType.ROCK, Category.SPECIAL),
            Triple(Weather.SNOW, PokemonType.ICE, Category.PHYSICAL),
        )
        ) {
            val defender =
                pokemon.copy(
                    profile = pokemon.profile.copy(types = PokemonTypes(type)),
                    stats = pokemon.stats.copy(defense = 101, specialDefense = 101),
                )
            val result =
                DefenseStat.calculate(
                    context(d = defender, category = category, weather = weather),
                    false,
                )
            assertEquals(151, result.value)
            assertEquals(
                listOf("Rank", "WeatherDefense", "defenseModifiers"),
                result.trace.map { it.id },
            )
            assertEquals(
                101,
                defense(
                    context(
                        d = defender,
                        category =
                            if (category == Category.PHYSICAL) {
                                Category.SPECIAL
                            } else {
                                Category.PHYSICAL
                            },
                        weather = weather,
                    ),
                ),
            )
            assertEquals(
                101,
                defense(
                    context(
                        d = defender.copy(teraType = TeraType.WATER),
                        category = category,
                        weather = weather,
                    ),
                ),
            )
            assertEquals(
                101,
                defense(
                    context(
                        a = pokemon.copy(ability = AbilityId("AirLock")),
                        d = defender,
                        category = category,
                        weather = weather,
                    ),
                ),
            )
        }
    }

    @Test
    fun `Paradox abilities distinguish attack defense and nonselected stats`() {
        for (name in listOf("QuarkDrive", "Protosynthesis")) {
            val ability = AbilityId(name)
            for (stat in Stat.entries) {
                if (stat == Stat.HP) {
                    continue
                }
                val boosted = pokemon.copy(ability = ability, boostedStat = stat)
                for (category in Category.entries) {
                    assertEquals(
                        if (
                            stat ==
                            if (category == Category.PHYSICAL) {
                                Stat.ATTACK
                            } else {
                                Stat.SPECIAL_ATTACK
                            }
                        ) {
                            130
                        } else {
                            100
                        },
                        attack(context(a = boosted, category = category)),
                    )
                    assertEquals(
                        if (
                            stat ==
                            if (category == Category.PHYSICAL) {
                                Stat.DEFENSE
                            } else {
                                Stat.SPECIAL_DEFENSE
                            }
                        ) {
                            130
                        } else {
                            100
                        },
                        defense(context(d = boosted, category = category)),
                    )
                }
            }
            assertTrue(ParadoxBoost.applies(pokemon, ability, Stat.ATTACK))
            assertFalse(ParadoxBoost.applies(pokemon, ability, Stat.SPEED))
            assertFalse(ParadoxBoost.applies(pokemon, ability, Stat.HP))
            assertTrue(
                ParadoxBoost.applies(
                    pokemon.copy(stages = StatStages.fromValues(defense = 1, specialAttack = 1)),
                    ability,
                    Stat.DEFENSE,
                ),
            )
            assertTrue(
                ParadoxBoost.applies(
                    pokemon.copy(
                        stages = StatStages.fromValues(specialAttack = 1, specialDefense = 1),
                    ),
                    ability,
                    Stat.SPECIAL_ATTACK,
                ),
            )
            assertTrue(
                ParadoxBoost.applies(
                    pokemon.copy(stages = StatStages.fromValues(specialDefense = 1, speed = 1)),
                    ability,
                    Stat.SPECIAL_DEFENSE,
                ),
            )
            assertTrue(
                ParadoxBoost.applies(
                    pokemon.copy(stages = StatStages.fromValues(speed = 1)),
                    ability,
                    Stat.SPEED,
                ),
            )
        }
        assertFalse(ParadoxBoost.applies(pokemon, null, Stat.ATTACK))
        assertFalse(ParadoxBoost.applies(pokemon, AbilityId("HugePower"), Stat.ATTACK))
    }
}
