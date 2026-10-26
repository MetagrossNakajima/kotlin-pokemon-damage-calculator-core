package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.damage.DamageModifiers
import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class DamageModifiersTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun result(
        a: PokemonState = pokemon,
        d: PokemonState = pokemon,
        name: String = "Custom",
        type: PokemonType = PokemonType.NORMAL,
        category: Category = Category.PHYSICAL,
        flags: EnumFlags<MoveFlag> = EnumFlags(),
        field: BattleField = BattleField(),
        critical: Boolean = false,
        effectiveness: Double = 1.0,
        hit: Int = 0,
    ) =
        DamageModifiers.calculate(
            DamageContext(
                DamageRequest(
                    a,
                    d,
                    Move(MoveId(name), type, 60, category, flags = flags),
                    field,
                    hitIndex = hit.toLong(),
                ),
            ),
            critical,
            effectiveness,
        )

    @Test
    fun `no damage modifiers yield identity and no trace`() {
        val r = result()
        assertEquals(4096, r.value)
        assertEquals(emptyList(), r.trace)
    }

    @Test
    fun `screens follow move category rather than defensive stat and respect battle format`() {
        for (format in BattleFormat.entries) for (category in Category.entries) for (reflect in
            listOf(true, false)) for (light in listOf(true, false)) {
            val d = pokemon.copy(sideConditions = SideConditions(reflect, light))
            val expected =
                if (if (category == Category.PHYSICAL) reflect else light)
                    if (format == BattleFormat.SINGLE) 2048 else 2732
                else 4096
            assertEquals(
                expected,
                result(d = d, category = category, field = BattleField(format = format)).value,
            )
            assertEquals(
                4096,
                result(
                        d = d,
                        category = category,
                        field = BattleField(format = format),
                        critical = true,
                    )
                    .value,
            )
        }
        val d = pokemon.copy(sideConditions = SideConditions(reflect = true))
        assertEquals(4096, result(d = d, name = "Psyshock", category = Category.SPECIAL).value)
        assertEquals(
            2048,
            result(
                    d = d.copy(sideConditions = SideConditions(lightScreen = true)),
                    name = "Psyshock",
                    category = Category.SPECIAL,
                )
                .value,
        )
    }

    @TestFactory
    fun `each screen breaking move bypasses both screens`() =
        listOf("BrickBreak", "RagingBull", "PsychicFangs").map { name ->
            dynamicTest(name) {
                for (category in Category.entries) assertEquals(
                    4096,
                    result(
                            d = pokemon.copy(sideConditions = SideConditions(true, true)),
                            name = name,
                            category = category,
                        )
                        .value,
                )
            }
        }

    @Test
    fun `Infiltrator bypasses screens only while active`() {
        val a = pokemon.copy(ability = AbilityId("Infiltrator"))
        val d = pokemon.copy(sideConditions = SideConditions(true, true))
        assertEquals(4096, result(a, d).value)
        assertEquals(
            2048,
            result(a.copy(flags = PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true))), d)
                .value,
        )
    }

    @TestFactory
    fun `effectiveness abilities cover immunity resisted neutral and super effective values`() =
        listOf("Neuroforce", "TintedLens", "SolidRock", "Filter", "PrismArmor").map { ability ->
            dynamicTest(ability) {
                for (effectiveness in listOf(0.0, 0.25, 0.5, 1.0, 2.0, 4.0)) {
                    val offensive = ability in setOf("Neuroforce", "TintedLens")
                    val a = if (offensive) pokemon.copy(ability = AbilityId(ability)) else pokemon
                    val d = if (offensive) pokemon else pokemon.copy(ability = AbilityId(ability))
                    val expected =
                        when {
                            ability == "TintedLens" && effectiveness < 1 -> 8192
                            ability == "Neuroforce" && effectiveness > 1 -> 5120
                            !offensive && effectiveness > 1 -> 3072
                            else -> 4096
                        }
                    assertEquals(expected, result(a, d, effectiveness = effectiveness).value)
                }
            }
        }

    @Test
    fun `Sniper requires a critical hit`() {
        val a = pokemon.copy(ability = AbilityId("Sniper"))
        assertEquals(6144, result(a, critical = true).value)
        assertEquals(4096, result(a).value)
        assertEquals(4096, result(critical = true).value)
    }

    @TestFactory
    fun `active full HP abilities apply only to the first hit`() =
        listOf("Multiscale", "ShadowShield").map { ability ->
            dynamicTest(ability) {
                val d = pokemon.copy(ability = AbilityId(ability), currentHp = 1)
                assertEquals(
                    2048,
                    result(d = d).value,
                ) // Caller explicitly supplies an active ability.
                assertEquals(4096, result(d = d, hit = 1).value)
                assertEquals(
                    if (ability == "ShadowShield") 2048 else 4096,
                    result(pokemon.copy(ability = AbilityId("MoldBreaker")), d).value,
                )
            }
        }

    @Test
    fun `Fluffy fire and contact modifiers chain independently`() {
        val d = pokemon.copy(ability = AbilityId("Fluffy"))
        assertEquals(4096, result(d = d).value)
        assertEquals(2048, result(d = d, flags = EnumFlags(MoveFlag.CONTACT)).value)
        assertEquals(8192, result(d = d, type = PokemonType.FIRE).value)
        val both = result(d = d, type = PokemonType.FIRE, flags = EnumFlags(MoveFlag.CONTACT))
        assertEquals(4096, both.value)
        assertEquals(listOf("FluffyContact", "FluffyFire"), both.trace.map { it.id })
        assertEquals(
            8192,
            result(
                    pokemon.copy(ability = AbilityId("LongReach")),
                    d,
                    type = PokemonType.FIRE,
                    flags = EnumFlags(MoveFlag.CONTACT),
                )
                .value,
        )
        assertEquals(
            4096,
            result(
                    pokemon.copy(ability = AbilityId("MoldBreaker")),
                    d,
                    type = PokemonType.FIRE,
                    flags = EnumFlags(MoveFlag.CONTACT),
                )
                .value,
        )
    }

    @TestFactory
    fun `defensive flag abilities require their move flag`() =
        listOf("WaveShield" to MoveFlag.CONTACT, "PunkRock" to MoveFlag.SOUND).map { (ability, flag)
            ->
            dynamicTest(ability) {
                val d = pokemon.copy(ability = AbilityId(ability))
                assertEquals(2048, result(d = d, flags = EnumFlags(flag)).value)
                assertEquals(4096, result(d = d).value)
                assertEquals(4096, result(flags = EnumFlags(flag)).value)
            }
        }

    @Test
    fun `Ice Scales follows special category even when the move targets Defense`() {
        val d = pokemon.copy(ability = AbilityId("IceScales"))
        assertEquals(4096, result(d = d).value)
        assertEquals(2048, result(d = d, category = Category.SPECIAL).value)
        assertEquals(2048, result(d = d, category = Category.SPECIAL, name = "Psyshock").value)
    }

    @Test
    fun `Expert Belt and Life Orb use exact final modifier constants`() {
        for (effectiveness in listOf(0.5, 1.0, 2.0, 4.0)) {
            assertEquals(
                if (effectiveness > 1) 4915 else 4096,
                result(pokemon.copy(item = ItemId("ExpertBelt")), effectiveness = effectiveness)
                    .value,
            )
            assertEquals(
                5324,
                result(pokemon.copy(item = ItemId("LifeOrb")), effectiveness = effectiveness).value,
            )
        }
        assertEquals(
            4096,
            result(pokemon.copy(item = ItemId("LifeOrb"), ability = AbilityId("Klutz"))).value,
        )
    }

    @TestFactory
    fun `every resist berry matches its type and requires super effective damage except Chilan`() =
        listOf(
                "OccaBerry",
                "PasshoBerry",
                "WacanBerry",
                "RindoBerry",
                "YacheBerry",
                "ChopleBerry",
                "KebiaBerry",
                "ShucaBerry",
                "CobaBerry",
                "PayapaBerry",
                "TangaBerry",
                "ChartiBerry",
                "KasibBerry",
                "HabanBerry",
                "ColburBerry",
                "BabiriBerry",
                "RoseliBerry",
                "ChilanBerry",
            )
            .zip(
                listOf(
                    PokemonType.FIRE,
                    PokemonType.WATER,
                    PokemonType.ELECTRIC,
                    PokemonType.GRASS,
                    PokemonType.ICE,
                    PokemonType.FIGHTING,
                    PokemonType.POISON,
                    PokemonType.GROUND,
                    PokemonType.FLYING,
                    PokemonType.PSYCHIC,
                    PokemonType.BUG,
                    PokemonType.ROCK,
                    PokemonType.GHOST,
                    PokemonType.DRAGON,
                    PokemonType.DARK,
                    PokemonType.STEEL,
                    PokemonType.FAIRY,
                    PokemonType.NORMAL,
                ),
            )
            .map { (berry, type) ->
                dynamicTest(berry) {
                    val d = pokemon.copy(item = ItemId(berry))
                    for (effectiveness in listOf(0.5, 1.0, 2.0)) {
                        assertEquals(
                            if (type == PokemonType.NORMAL || effectiveness > 1) 2048 else 4096,
                            result(d = d, type = type, effectiveness = effectiveness).value,
                        )
                    }
                    assertEquals(
                        1024,
                        result(
                                d = d.copy(ability = AbilityId("Ripen")),
                                type = type,
                                effectiveness = 2.0,
                            )
                            .value,
                    )
                    assertEquals(
                        4096,
                        result(d = d, type = type, effectiveness = 2.0, hit = 1).value,
                    )
                    assertEquals(
                        4096,
                        result(d = d.copy(itemConsumed = true), type = type, effectiveness = 2.0)
                            .value,
                    )
                    assertEquals(
                        4096,
                        result(
                                d = d,
                                type =
                                    if (type == PokemonType.NORMAL) PokemonType.WATER
                                    else PokemonType.NORMAL,
                                effectiveness = 2.0,
                            )
                            .value,
                    )
                    assertEquals(
                        4096,
                        result(
                                pokemon.copy(ability = AbilityId("Unnerve")),
                                d,
                                type = type,
                                effectiveness = 2.0,
                            )
                            .value,
                    )
                    assertEquals(
                        4096,
                        result(
                                d = d,
                                type = type,
                                effectiveness = 2.0,
                                field = BattleField(effects = EnumFlags(FieldEffect.UNNERVE)),
                            )
                            .value,
                    )
                }
            }

    @Test
    fun `screen Friend Guard Life Orb and berry preserve order and half-up chaining`() {
        val r =
            result(
                pokemon.copy(item = ItemId("LifeOrb")),
                pokemon.copy(
                    item = ItemId("ChilanBerry"),
                    sideConditions = SideConditions(reflect = true),
                ),
                field =
                    BattleField(
                        format = BattleFormat.DOUBLE,
                        effects = EnumFlags(FieldEffect.FRIEND_GUARD),
                    ),
            )
        assertEquals(
            listOf("Screen", "FriendGuard", "LifeOrb", "ChilanBerry"),
            r.trace.map { it.id },
        )
        assertEquals(listOf(2732L, 2049L, 2663L, 1332L), r.trace.map { it.after })
        assertEquals(1332, r.value)
    }
}
