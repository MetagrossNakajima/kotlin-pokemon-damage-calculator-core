package dev.pokemondamage

import dev.pokemondamage.engine.combined.*
import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class TurnEndTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )
    private val state = BattleProgress(100, false, null, null)

    private fun apply(
        p: PokemonState = pokemon,
        s: BattleProgress = state,
        field: BattleField = BattleField(),
        turn: Int = 1,
    ) = TurnEnd(p, field).apply(s, turn.toLong())

    private val sand = BattleField(weather = Weather.SANDSTORM)

    @Test
    fun `sand damage uses current types and effective weather`() {
        assertEquals(88, apply(field = sand).hp)
        for (weather in listOf(null) + Weather.entries) assertEquals(
            if (weather == Weather.SANDSTORM) 88 else 100,
            apply(field = BattleField(weather = weather)).hp,
        )
        for (type in PokemonType.entries) {
            val expected =
                if (type in setOf(PokemonType.ROCK, PokemonType.GROUND, PokemonType.STEEL)) 100
                else 88
            assertEquals(
                expected,
                apply(
                        pokemon.copy(profile = pokemon.profile.copy(types = PokemonTypes(type))),
                        field = sand,
                    )
                    .hp,
            )
            assertEquals(
                expected,
                apply(pokemon.copy(teraType = TeraType.valueOf(type.name)), field = sand).hp,
            )
        }
        assertEquals(100, apply(pokemon.copy(ability = AbilityId("CloudNine")), field = sand).hp)
        assertEquals(100, apply(pokemon.copy(item = ItemId("SafetyGoggles")), field = sand).hp)
        assertEquals(
            88,
            apply(
                    pokemon.copy(item = ItemId("SafetyGoggles")),
                    state.copy(itemConsumed = true),
                    sand,
                )
                .hp,
        )
        assertEquals(
            88,
            apply(
                    pokemon.copy(item = ItemId("SafetyGoggles"), ability = AbilityId("Klutz")),
                    field = sand,
                )
                .hp,
        )
    }

    @TestFactory
    fun `each sand immunity ability works only while active`() =
        listOf("SandVeil", "SandRush", "SandForce", "Overcoat", "MagicGuard").map { ability ->
            dynamicTest(ability) {
                val p = pokemon.copy(ability = AbilityId(ability))
                assertEquals(100, apply(p, field = sand).hp)
                assertEquals(
                    88,
                    apply(
                            p.copy(
                                flags = PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true)),
                            ),
                            field = sand,
                        )
                        .hp,
                )
            }
        }

    @Test
    fun `grassy healing requires grounding and caps at maximum HP`() {
        val grass = BattleField(terrain = Terrain.GRASS)
        assertEquals(112, apply(field = grass).hp)
        assertEquals(200, apply(s = state.copy(hp = 199), field = grass).hp)
        assertEquals(100, apply(pokemon.copy(ability = AbilityId("Levitate")), field = grass).hp)
        assertEquals(
            112,
            apply(pokemon.copy(ability = AbilityId("Levitate")), field = grass.copy(gravity = true))
                .hp,
        )
    }

    @Test
    fun `Leftovers heals only living injured branches with an active item`() {
        val p = pokemon.copy(item = ItemId("Leftovers"))
        assertEquals(112, apply(p).hp)
        assertEquals(200, apply(p, state.copy(hp = 199)).hp)
        assertEquals(200, apply(p, state.copy(hp = 200)).hp)
        assertEquals(100, apply(p, state.copy(itemConsumed = true)).hp)
        assertEquals(100, apply(p.copy(ability = AbilityId("Klutz"))).hp)
        assertEquals(0, apply(p, state.copy(hp = 0)).hp)
    }

    @Test
    fun `status damage Poison Heal Heatproof and Magic Guard retain distinct behavior`() {
        for (status in Status.entries) {
            val p =
                pokemon.copy(
                    status = status,
                    toxicCounter = if (status == Status.TOXIC) 2 else null,
                )
            val s = state.copy(toxicCounter = p.toxicCounter)
            val expected =
                when (status) {
                    Status.BURN -> 88
                    Status.POISON,
                    Status.TOXIC -> 75
                    else -> 100
                }
            assertEquals(expected, apply(p, s).hp)
            assertEquals(100, apply(p.copy(ability = AbilityId("MagicGuard")), s).hp)
            assertEquals(
                if (status in setOf(Status.POISON, Status.TOXIC)) 125 else expected,
                apply(p.copy(ability = AbilityId("PoisonHeal")), s).hp,
            )
        }
        assertEquals(
            94,
            apply(pokemon.copy(status = Status.BURN, ability = AbilityId("Heatproof"))).hp,
        )
        assertEquals(
            200,
            apply(
                    pokemon.copy(status = Status.POISON, ability = AbilityId("PoisonHeal")),
                    state.copy(hp = 199),
                )
                .hp,
        )
        val toxic = pokemon.copy(status = Status.TOXIC, toxicCounter = 1)
        assertEquals(2, apply(toxic).toxicCounter)
        assertEquals(15, apply(toxic, state.copy(toxicCounter = 15)).toxicCounter)
        assertEquals(
            3,
            apply(toxic.copy(ability = AbilityId("PoisonHeal")), state.copy(toxicCounter = 2))
                .toxicCounter,
        )
        assertEquals(2, apply(toxic, state.copy(hp = 1, toxicCounter = 1)).toxicCounter)
        assertEquals(
            1,
            apply(toxic.copy(ability = AbilityId("MagicGuard")), state.copy(toxicCounter = 1))
                .toxicCounter,
        )
    }

    @Test
    fun `all damage and healing fractions have minimum one for tiny max HP`() {
        val tiny = pokemon.copy(stats = pokemon.stats.copy(hp = 2))
        assertEquals(1, apply(tiny, state.copy(hp = 2), sand).hp)
        assertEquals(2, apply(tiny, state.copy(hp = 1), BattleField(terrain = Terrain.GRASS)).hp)
        assertEquals(2, apply(tiny.copy(item = ItemId("Leftovers")), state.copy(hp = 1)).hp)
        assertEquals(
            1,
            apply(
                    tiny.copy(status = Status.BURN, ability = AbilityId("Heatproof")),
                    state.copy(hp = 2),
                )
                .hp,
        )
        assertEquals(
            2,
            apply(
                    tiny.copy(status = Status.POISON, ability = AbilityId("PoisonHeal")),
                    state.copy(hp = 1),
                )
                .hp,
        )
    }

    @Test
    fun `Cud Chew repeats once on its scheduled turn and respects suppression item and Unnerve`() {
        val p =
            pokemon.copy(
                ability = AbilityId("CudChew"),
                item = ItemId("SitrusBerry"),
                itemConsumed = true,
            )
        val scheduled = state.copy(itemConsumed = true, cudChewTurn = 2)
        val healed = apply(p, scheduled, turn = 2)
        assertEquals(150, healed.hp)
        assertNull(healed.cudChewTurn)
        assertTrue(healed.itemConsumed)
        assertEquals(healed, apply(p, healed, turn = 3))
        assertEquals(scheduled, apply(p, scheduled, turn = 1))
        assertEquals(scheduled, apply(p.copy(ability = null), scheduled, turn = 2))
        assertEquals(scheduled, apply(p.copy(item = null), scheduled, turn = 2))
        assertEquals(
            scheduled,
            apply(p, scheduled, BattleField(effects = EnumFlags(FieldEffect.MAGIC_ROOM)), 2),
        )
        assertEquals(
            scheduled,
            apply(p, scheduled, BattleField(effects = EnumFlags(FieldEffect.UNNERVE)), 2),
        )
    }

    @Test
    fun `sand grass Leftovers status and Cud Chew run in source order without revival`() {
        val field = BattleField(weather = Weather.SANDSTORM, terrain = Terrain.GRASS)
        val p = pokemon.copy(item = ItemId("Leftovers"), status = Status.POISON)
        assertEquals(175, apply(p, state.copy(hp = 199), field).hp) // 199-12+12+1-25.
        assertEquals(0, apply(p, state.copy(hp = 12), field).hp) // Sand KO precedes all healing.
        val cud =
            pokemon.copy(
                item = ItemId("SitrusBerry"),
                ability = AbilityId("CudChew"),
                status = Status.POISON,
            )
        val scheduled = state.copy(hp = 25, itemConsumed = true, cudChewTurn = 2)
        assertEquals(0, apply(cud, scheduled, turn = 2).hp) // Poison KO precedes repeat berry.
        val triggered = apply(cud, state.copy(hp = 110), field, 1)
        assertEquals(135, triggered.hp) // 110-12+50+12-25.
        assertEquals(2L, triggered.cudChewTurn)
        val next = apply(cud, triggered, field, 2)
        assertEquals(160, next.hp) // 135-12+12-25+50.
        assertNull(next.cudChewTurn)
    }
}
