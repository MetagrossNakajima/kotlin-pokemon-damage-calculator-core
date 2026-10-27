package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.power.PowerModifiers
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FaintedAllies
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.Gender
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
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.ToxicCounter
import dev.pokemondamage.model.Weather
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PowerModifiersTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(201, 100, 100, 100, 100, 100),
        )

    private fun result(
        a: PokemonState = pokemon,
        d: PokemonState = pokemon,
        name: String = "Custom",
        type: PokemonType = PokemonType.NORMAL,
        category: Category = Category.PHYSICAL,
        flags: EnumFlags<MoveFlag> = EnumFlags(),
        field: BattleField = BattleField(),
        power: Long = 60,
    ) = PowerModifiers
        .calculate(
            DamageContext(
                DamageRequest(
                    a,
                    d,
                    Move(MoveId(name), type, 60, category, flags = flags),
                    field,
                ),
            ),
            power,
        ).finish()

    private fun airborne(p: PokemonState) =
        p.copy(
            flags = PokemonFlags(mapOf(PokemonFlag.GROUNDED to false)),
            ability = AbilityId("Levitate"),
        )

    @Test
    fun `no power effects leave an empty identity chain`() {
        val result = result()
        assertEquals(4096, result.value)
        assertTrue(result.trace.isEmpty())
    }

    @TestFactory
    fun `flag abilities each boost only eligible moves`() =
        listOf(
            Triple("StrongJaw", MoveFlag.BITE, 6144),
            Triple("MegaLauncher", MoveFlag.PULSE, 6144),
            Triple("Sharpness", MoveFlag.SHARPNESS, 6144),
            Triple("SheerForce", MoveFlag.SHEER_FORCE, 5325),
            Triple("ToughClaws", MoveFlag.CONTACT, 5325),
            Triple("PunkRock", MoveFlag.SOUND, 5325),
            Triple("IronFist", MoveFlag.PUNCH, 4915),
            Triple("Reckless", MoveFlag.RECOIL, 4915),
        ).map { (ability, flag, expected) ->
            dynamicTest(ability) {
                val a = pokemon.copy(ability = AbilityId(ability))
                assertEquals(expected, result(a, flags = EnumFlags(flag)).value)
                assertEquals(
                    listOf(ability),
                    result(a, flags = EnumFlags(flag)).trace.map { it.id },
                )
                assertEquals(4096, result(a).value)
                assertEquals(4096, result(flags = EnumFlags(flag)).value)
                assertEquals(
                    4096,
                    result(
                        a.copy(
                            flags =
                                PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true)),
                        ),
                        flags = EnumFlags(flag),
                    ).value,
                )
            }
        }

    @Test
    fun `Technician uses unmodified power at the sixty boundary`() {
        val a = pokemon.copy(ability = AbilityId("Technician"))
        for (power in listOf(1L, 59L, 60L)) {
            assertEquals(6144, result(a, power = power).value)
        }
        for (power in listOf(61L, 100L, Int.MAX_VALUE.toLong() + 1)) {
            assertEquals(
                4096,
                result(a, power = power).value,
            )
        }
        assertEquals(
            9216,
            result(a, field = BattleField(effects = EnumFlags(FieldEffect.HELPING_HAND))).value,
        )
    }

    @TestFactory
    fun `category abilities honor the effective category`() =
        listOf("FlareBoost", "ToxicBoost").map { ability ->
            dynamicTest(ability) {
                for (category in Category.entries) {
                    assertEquals(
                        if ((ability == "ToxicBoost") == (category == Category.PHYSICAL)) {
                            6144
                        } else {
                            4096
                        },
                        result(
                            pokemon.copy(ability = AbilityId(ability)),
                            category = category,
                        ).value,
                    )
                }
            }
        }

    @Test
    fun `typed abilities and active Analytic apply without automatic setup`() {
        for (type in PokemonType.entries) {
            assertEquals(
                if (type in setOf(PokemonType.GROUND, PokemonType.ROCK, PokemonType.STEEL)) {
                    5325
                } else {
                    4096
                },
                result(pokemon.copy(ability = AbilityId("SandForce")), type = type).value,
            )
            assertEquals(
                if (type == PokemonType.STEEL) 6144 else 4096,
                result(pokemon.copy(ability = AbilityId("SteelySpirit")), type = type).value,
            )
            assertEquals(
                if (type == PokemonType.FIRE) 5120 else 4096,
                result(d = pokemon.copy(ability = AbilityId("DrySkin")), type = type).value,
            )
        }
        assertEquals(5325, result(pokemon.copy(ability = AbilityId("Analytic"))).value)
        assertEquals(
            4096,
            result(
                pokemon.copy(ability = AbilityId("MoldBreaker")),
                pokemon.copy(ability = AbilityId("DrySkin")),
                type = PokemonType.FIRE,
            ).value,
        )
    }

    @Test
    fun `Rivalry compares both genders and excludes genderless targets`() {
        for (a in Gender.entries) {
            for (d in Gender.entries) {
                val attacker =
                    pokemon.copy(
                        ability = AbilityId("Rivalry"),
                        profile = pokemon.profile.copy(gender = a),
                    )
                val defender = pokemon.copy(profile = pokemon.profile.copy(gender = d))
                assertEquals(
                    if (a == Gender.GENDERLESS || d == Gender.GENDERLESS) {
                        4096
                    } else if (a == d) {
                        5120
                    } else {
                        3072
                    },
                    result(attacker, defender).value,
                )
            }
        }
    }

    @Test
    fun `Supreme Overlord has exact increments and caps at five allies`() {
        val expected = listOf(4096, 4506, 4915, 5325, 5734, 6144, 6144)
        for ((count, multiplier) in expected.withIndex()) {
            assertEquals(
                multiplier,
                result(
                    pokemon.copy(
                        ability = AbilityId("SupremeOverlord"),
                        faintedAllies = FaintedAllies(count),
                    ),
                ).value,
            )
        }
        assertEquals(
            6144,
            result(
                pokemon.copy(
                    ability = AbilityId("SupremeOverlord"),
                    faintedAllies = FaintedAllies(100),
                ),
            ).value,
        )
    }

    @Test
    fun `Facade and Brine check their respective status and HP conditions`() {
        for (status in Status.entries) {
            val a =
                pokemon.copy(
                    status = status,
                    toxicCounter = if (status == Status.TOXIC) ToxicCounter(1) else null,
                )
            assertEquals(
                if (status in setOf(Status.BURN, Status.POISON, Status.TOXIC, Status.PARALYSIS)) {
                    8192
                } else {
                    4096
                },
                result(a, name = "Facade").value,
            )
        }
        assertEquals(4096, result(name = "Facade").value)
        assertEquals(8192, result(d = pokemon.copy(currentHp = 100), name = "Brine").value)
        assertEquals(4096, result(d = pokemon.copy(currentHp = 101), name = "Brine").value)
    }

    @Test
    fun `Knock Off checks possession consumption and explicit removability even with Klutz`() {
        assertEquals(4096, result(name = "KnockOff").value)
        val d = pokemon.copy(item = ItemId("LifeOrb"), ability = AbilityId("Klutz"))
        assertEquals(6144, result(d = d, name = "KnockOff").value)
        assertEquals(4096, result(d = d.copy(itemConsumed = true), name = "KnockOff").value)
        for (removable in listOf(true, false)) {
            assertEquals(
                if (removable) 6144 else 4096,
                result(
                    d =
                        d.copy(
                            flags = PokemonFlags(mapOf(PokemonFlag.ITEM_REMOVABLE to removable)),
                        ),
                    name = "KnockOff",
                ).value,
            )
        }
    }

    @TestFactory
    fun `solar moves weaken in non-sunny effective weather`() =
        listOf("SolarBeam", "SolarBlade").map { move ->
            dynamicTest(move) {
                assertEquals(4096, result(name = move).value)
                for (weather in Weather.entries) {
                    assertEquals(
                        if (weather == Weather.SUNLIGHT) 4096 else 2048,
                        result(name = move, field = BattleField(weather = weather)).value,
                    )
                }
                assertEquals(
                    4096,
                    result(
                        d = pokemon.copy(ability = AbilityId("CloudNine")),
                        name = move,
                        field = BattleField(weather = Weather.RAIN),
                    ).value,
                )
            }
        }

    @TestFactory
    fun `collision moves use chart effectiveness before Tera Shell`() =
        listOf("CollisionCourse", "ElectroDrift").map { move ->
            dynamicTest(move) {
                val d =
                    pokemon.copy(
                        profile = pokemon.profile.copy(types = PokemonTypes(PokemonType.GRASS)),
                    )
                assertEquals(5461, result(d = d, name = move, type = PokemonType.FIRE).value)
                assertEquals(4096, result(d = d, name = move, type = PokemonType.NORMAL).value)
                assertEquals(
                    5461,
                    result(
                        d = d.copy(ability = AbilityId("TeraShell")),
                        name = move,
                        type = PokemonType.FIRE,
                    ).value,
                )
            }
        }

    @Test
    fun `field boosts and sports require correct category and type`() {
        assertEquals(
            6144,
            result(field = BattleField(effects = EnumFlags(FieldEffect.HELPING_HAND))).value,
        )
        assertEquals(
            5325,
            result(field = BattleField(effects = EnumFlags(FieldEffect.POWER_SPOT))).value,
        )
        assertEquals(
            5325,
            result(
                category = Category.SPECIAL,
                field = BattleField(effects = EnumFlags(FieldEffect.BATTERY)),
            ).value,
        )
        assertEquals(
            4096,
            result(field = BattleField(effects = EnumFlags(FieldEffect.BATTERY))).value,
        )
        for (
        (effect, type) in
        listOf(
            FieldEffect.MUD_SPORT to PokemonType.ELECTRIC,
            FieldEffect.WATER_SPORT to PokemonType.FIRE,
        )
        ) {
            assertEquals(
                1352,
                result(type = type, field = BattleField(effects = EnumFlags(effect))).value,
            )
            assertEquals(4096, result(field = BattleField(effects = EnumFlags(effect))).value)
        }
    }

    @Test
    fun `terrain boosts use attacker grounding and reductions use defender grounding`() {
        for (
        (terrain, type) in
        listOf(
            Terrain.ELECTRIC to PokemonType.ELECTRIC,
            Terrain.GRASS to PokemonType.GRASS,
            Terrain.PSYCHIC to PokemonType.PSYCHIC,
        )
        ) {
            val field = BattleField(terrain = terrain)
            assertEquals(5325, result(type = type, field = field).value)
            assertEquals(4096, result(airborne(pokemon), type = type, field = field).value)
            assertEquals(5325, result(d = airborne(pokemon), type = type, field = field).value)
        }
        val mist = BattleField(terrain = Terrain.MISTY)
        assertEquals(2048, result(type = PokemonType.DRAGON, field = mist).value)
        assertEquals(
            4096,
            result(d = airborne(pokemon), type = PokemonType.DRAGON, field = mist).value,
        )
        assertEquals(4096, result(field = mist).value)
        for (name in listOf("Earthquake", "Bulldoze")) {
            assertEquals(
                2048,
                result(name = name, field = BattleField(terrain = Terrain.GRASS)).value,
            )
            assertEquals(
                4096,
                result(
                    d = airborne(pokemon),
                    name = name,
                    field = BattleField(terrain = Terrain.GRASS),
                ).value,
            )
        }
    }

    @Test
    fun `terrain moves gravity and Charge retain independent conditions`() {
        for (terrain in listOf(null) + Terrain.entries) {
            val field = BattleField(terrain = terrain)
            assertEquals(
                if (terrain == Terrain.PSYCHIC) 6144 else 4096,
                result(name = "ExpandingForce", field = field).value,
            )
            assertEquals(
                4096,
                result(airborne(pokemon), name = "ExpandingForce", field = field).value,
            )
            assertEquals(
                if (terrain == Terrain.ELECTRIC) 6144 else 4096,
                result(name = "Psyblade", field = field).value,
            )
            assertEquals(
                if (terrain == Terrain.ELECTRIC) 8192 else 4096,
                result(name = "RisingVoltage", field = field).value,
            )
            assertEquals(
                4096,
                result(d = airborne(pokemon), name = "RisingVoltage", field = field).value,
            )
        }
        assertEquals(4096, result(name = "GravApple").value)
        assertEquals(6144, result(name = "GravApple", field = BattleField(gravity = true)).value)
        for (charge in listOf(true, false)) {
            val a = pokemon.copy(flags = PokemonFlags(mapOf(PokemonFlag.CHARGE to charge)))
            assertEquals(if (charge) 8192 else 4096, result(a, type = PokemonType.ELECTRIC).value)
            assertEquals(4096, result(a).value)
        }
    }

    @Test
    fun `auras use active defender ability and Aura Break reverses their boost`() {
        for (
        (type, aura, effect) in
        listOf(
            Triple(PokemonType.FAIRY, "FairyAura", FieldEffect.FAIRY_AURA),
            Triple(PokemonType.DARK, "DarkAura", FieldEffect.DARK_AURA),
        )
        ) {
            val a = pokemon.copy(ability = AbilityId(aura))
            val field = BattleField(effects = EnumFlags(effect))
            assertEquals(5448, result(a, type = type).value)
            assertEquals(5448, result(d = a, type = type).value)
            assertEquals(5448, result(type = type, field = field).value)
            assertEquals(4096, result(type = type).value)
            assertEquals(
                3072,
                result(pokemon.copy(ability = AbilityId("AuraBreak")), type = type, field = field)
                    .value,
            )
            assertEquals(
                3072,
                result(
                    d = pokemon.copy(ability = AbilityId("AuraBreak")),
                    type = type,
                    field = field,
                ).value,
            )
            assertEquals(
                3072,
                result(
                    a,
                    type = type,
                    field = BattleField(effects = EnumFlags(FieldEffect.AURA_BREAK)),
                ).value,
            )
            assertEquals(
                4096,
                result(
                    type = type,
                    field = BattleField(effects = EnumFlags(FieldEffect.AURA_BREAK)),
                ).value,
            )
            assertEquals(
                5448,
                result(pokemon.copy(ability = AbilityId("MoldBreaker")), a, type = type).value,
            )
        }
    }

    @TestFactory
    fun `skins boost only eligible converted moves`() =
        listOf(
            "Normalize",
            "Aerilate",
            "Pixilate",
            "Refrigerate",
            "Galvanize",
            "Dragonize",
        ).map { ability ->
            dynamicTest(ability) {
                val a = pokemon.copy(ability = AbilityId(ability))
                assertEquals(4915, result(a).value)
                assertEquals(
                    if (ability == "Normalize") 4915 else 4096,
                    result(a, type = PokemonType.WATER).value,
                )
                assertEquals(4096, result(a, name = "WeatherBall").value)
                assertEquals(4096, result(a, name = "Judgment").value)
                assertEquals(4915, result(a, name = "TerrainPulse").value)
                assertEquals(
                    4096,
                    result(
                        airborne(a).copy(ability = AbilityId(ability)),
                        name = "TerrainPulse",
                        field = BattleField(terrain = Terrain.ELECTRIC),
                    ).value,
                )
                assertEquals(4915, result(a, name = "TeraBlast").value)
                assertEquals(
                    4096,
                    result(a.copy(teraType = TeraType.WATER), name = "TeraBlast").value,
                )
            }
        }

    @Test
    fun `items distinguish category flags type and consumption`() {
        for (
        (item, category) in
        listOf("MuscleBand" to Category.PHYSICAL, "WiseGlasses" to Category.SPECIAL)
        ) {
            val a = pokemon.copy(item = ItemId(item))
            assertEquals(4505, result(a, category = category).value)
            assertEquals(
                4096,
                result(
                    a,
                    category =
                        if (category == Category.PHYSICAL) {
                            Category.SPECIAL
                        } else {
                            Category.PHYSICAL
                        },
                ).value,
            )
        }
        val glove = pokemon.copy(item = ItemId("PunchingGlove"))
        assertEquals(4506, result(glove, flags = EnumFlags(MoveFlag.PUNCH)).value)
        assertEquals(4096, result(glove).value)
        assertEquals(
            4506,
            result(
                glove.copy(ability = AbilityId("ToughClaws")),
                flags = EnumFlags(MoveFlag.PUNCH, MoveFlag.CONTACT),
            ).value,
        )
        val gem = pokemon.copy(item = ItemId("NormalGem"))
        assertEquals(5325, result(gem).value)
        assertEquals(4096, result(gem, type = PokemonType.WATER).value)
        assertEquals(4096, result(gem.copy(itemConsumed = true)).value)
        val charcoal = pokemon.copy(item = ItemId("Charcoal"))
        assertEquals(4915, result(charcoal, type = PokemonType.FIRE).value)
        assertEquals(4096, result(charcoal).value)
    }

    @TestFactory
    fun `legendary items require both a matching species and move type`() =
        listOf(
            Triple(
                "AdamantOrb",
                listOf("Dialga", "Dialga-Origin"),
                listOf(PokemonType.STEEL, PokemonType.DRAGON),
            ),
            Triple(
                "AdamantCrystal",
                listOf("Dialga", "Dialga-Origin"),
                listOf(PokemonType.STEEL, PokemonType.DRAGON),
            ),
            Triple(
                "LustrousOrb",
                listOf("Palkia", "Palkia-Origin"),
                listOf(PokemonType.WATER, PokemonType.DRAGON),
            ),
            Triple(
                "LustrousGlobe",
                listOf("Palkia", "Palkia-Origin"),
                listOf(PokemonType.WATER, PokemonType.DRAGON),
            ),
            Triple(
                "GriseousOrb",
                listOf("Giratina", "Giratina-Origin"),
                listOf(PokemonType.GHOST, PokemonType.DRAGON),
            ),
            Triple(
                "GriseousCore",
                listOf("Giratina", "Giratina-Origin"),
                listOf(PokemonType.GHOST, PokemonType.DRAGON),
            ),
            Triple(
                "SoulDew",
                listOf("Latias", "Latios"),
                listOf(PokemonType.PSYCHIC, PokemonType.DRAGON),
            ),
        ).map { (item, species, types) ->
            dynamicTest(item) {
                for (id in species + "Mew") {
                    for (type in PokemonType.entries) {
                        val a =
                            pokemon.copy(
                                item = ItemId(item),
                                profile = pokemon.profile.copy(id = PokemonId(id)),
                            )
                        assertEquals(
                            if (id in species && type in types) 4915 else 4096,
                            result(a, type = type).value,
                            "$id $type",
                        )
                    }
                }
            }
        }

    @Test
    fun `ordered chain rounds each modifier and records all intermediate values`() {
        val a = pokemon.copy(ability = AbilityId("SheerForce"), item = ItemId("WiseGlasses"))
        val r =
            result(
                a,
                category = Category.SPECIAL,
                flags = EnumFlags(MoveFlag.SHEER_FORCE),
                field =
                    BattleField(
                        effects =
                            EnumFlags(
                                FieldEffect.HELPING_HAND,
                                FieldEffect.BATTERY,
                                FieldEffect.POWER_SPOT,
                            ),
                    ),
            )
        assertEquals(
            listOf("HelpingHand", "SheerForce", "Battery", "PowerSpot", "WiseGlasses"),
            r.trace.map { it.id },
        )
        assertEquals(listOf(4096L, 6144L, 7988L, 10385L, 13501L), r.trace.map { it.before })
        assertEquals(listOf(6144L, 7988L, 10385L, 13501L, 14849L), r.trace.map { it.after })
        assertEquals(14849, r.value)
    }
}
