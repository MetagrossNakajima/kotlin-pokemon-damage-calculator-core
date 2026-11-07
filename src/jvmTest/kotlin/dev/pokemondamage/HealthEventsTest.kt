package dev.pokemondamage

import dev.pokemondamage.engine.combined.BattleProgress
import dev.pokemondamage.engine.combined.HealthEvents
import dev.pokemondamage.math.BigInteger
import dev.pokemondamage.math.toBigInteger
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.BattleSetup
import dev.pokemondamage.model.EntryHazards
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Spikes
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.TeraType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class HealthEventsTest {
    private val defender =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )
    private val state = BattleProgress(200, false, null, null)

    private fun events(
        p: PokemonState = defender,
        field: BattleField = BattleField(),
    ) = HealthEvents(p, field)

    @Test
    fun `damage caps HP but records full attack amount and stops after fainting`() {
        val huge = BigInteger.ONE.shiftLeft(100)
        val fainted = events().damage(state, huge, 1, true)
        assertEquals(0, fainted.hp)
        assertEquals(huge, fainted.attackDamage)
        assertEquals(fainted, events().damage(fainted, huge, 2, true))
        assertEquals(state, events().damage(state, BigInteger.ZERO, 1, true))
        assertEquals(state.copy(hp = 175), events().damage(state, 25.toBigInteger(), 1))
    }

    @Test
    fun `Sitrus checks half HP after each damaging event and never revives`() {
        val p = defender.copy(item = ItemId("SitrusBerry"))
        val events = events(p)
        assertEquals(state.copy(hp = 101), events.damage(state, 99.toBigInteger(), 1))
        assertEquals(
            state.copy(hp = 150, itemConsumed = true),
            events.damage(state, 100.toBigInteger(), 1),
        )
        assertEquals(state.copy(hp = 0), events.damage(state, 200.toBigInteger(), 1))
        assertEquals(
            state.copy(hp = 50, itemConsumed = true),
            events.damage(state.copy(hp = 150, itemConsumed = true), 100.toBigInteger(), 2),
        )
        assertEquals(
            state.copy(hp = 100),
            events(p, BattleField(effects = EnumFlags(FieldEffect.UNNERVE)))
                .damage(state, 100.toBigInteger(), 1),
        )
        assertEquals(
            state.copy(hp = 100),
            events(p.copy(ability = AbilityId("Klutz"))).damage(state, 100.toBigInteger(), 1),
        )
        assertEquals(state.copy(hp = 90), events.damage(state.copy(hp = 90), BigInteger.ZERO, 1))
    }

    @Test
    fun `Ripen Cheek Pouch and Cud Chew have distinct healing and scheduling`() {
        for ((ability, hp) in listOf("Ripen" to 200, "CheekPouch" to 200, "CudChew" to 150)) {
            val events =
                events(defender.copy(item = ItemId("SitrusBerry"), ability = AbilityId(ability)))
            val healed = events.damage(state, 100.toBigInteger(), 1)
            assertEquals(hp, healed.hp)
            assertTrue(healed.itemConsumed)
            assertEquals(if (ability == "CudChew") 2L else null, healed.cudChewTurn)
            assertEquals(state.copy(hp = 200, itemConsumed = true), events.berry(healed, 2, true))
        }
        val cud = events(defender.copy(ability = AbilityId("CudChew")))
        assertEquals(
            2147483648L,
            cud.berry(state.copy(hp = 1), Int.MAX_VALUE.toLong(), false).cudChewTurn,
        )
        val tiny = defender.copy(stats = defender.stats.copy(hp = 2), item = ItemId("SitrusBerry"))
        assertEquals(2, events(tiny).damage(state.copy(hp = 2), BigInteger.ONE, 1).hp)
    }

    @Test
    fun `Ripen doubles rounded Sitrus healing below the maximum HP cap`() {
        val p =
            defender.copy(
                stats = defender.stats.copy(hp = 201),
                item = ItemId("SitrusBerry"),
                ability = AbilityId("Ripen"),
            )
        val initial = state.copy(hp = 201)
        // 201 - 150 + 2 × ⌊201 / 4⌋ = 151。どちらの結果も回復上限には届かない。
        assertEquals(
            initial.copy(hp = 151, itemConsumed = true),
            events(p).damage(initial, 150.toBigInteger(), 1),
        )
        assertEquals(
            initial.copy(hp = 101, itemConsumed = true),
            events(p.copy(ability = null)).damage(initial, 150.toBigInteger(), 1),
        )
    }

    @Test
    fun `hazards use type grounding layers and protection while manual chip remains explicit`() {
        val hazards =
            BattleSetup(EntryHazards(true, Spikes.THREE_LAYERS), listOf(10.toBigInteger()))
        assertEquals(115, events().setup(state, hazards).hp)
        for (layers in 0..3) {
            assertEquals(
                listOf(200, 175, 167, 150)[layers],
                events()
                    .setup(
                        state,
                        BattleSetup(EntryHazards(spikes = Spikes.fromLayers(layers))),
                    ).hp,
            )
        }
        for (
        p in
        listOf(
            defender.copy(item = ItemId("Heavy-DutyBoots")),
            defender.copy(ability = AbilityId("MagicGuard")),
        )
        ) {
            assertEquals(190, events(p).setup(state, hazards).hp)
        }
        val flying =
            defender.copy(
                profile =
                    defender.profile.copy(
                        types = PokemonTypes(PokemonType.FIRE, PokemonType.FLYING),
                    ),
            )
        assertEquals(
            100,
            events(flying).setup(state, BattleSetup(EntryHazards(true, Spikes.THREE_LAYERS))).hp,
        )
        assertEquals(
            50,
            events(flying, BattleField(gravity = true))
                .setup(state, BattleSetup(EntryHazards(true, Spikes.THREE_LAYERS)))
                .hp,
        )
        assertEquals(
            125,
            events(flying.copy(teraType = TeraType.NORMAL))
                .setup(state, BattleSetup(EntryHazards(true, Spikes.THREE_LAYERS)))
                .hp,
        )
        val tiny = defender.copy(stats = defender.stats.copy(hp = 1))
        assertEquals(
            0,
            events(
                tiny,
            ).setup(state.copy(hp = 1), BattleSetup(EntryHazards(true, Spikes.THREE_LAYERS))).hp,
        )
    }

    @Test
    fun `setup checks berry between hazards and each manual chip`() {
        val events =
            events(defender.copy(item = ItemId("SitrusBerry"), ability = AbilityId("CudChew")))
        val r =
            events.setup(
                state.copy(hp = 120),
                BattleSetup(
                    EntryHazards(true, Spikes.THREE_LAYERS),
                    listOf(10.toBigInteger(), BigInteger.ZERO),
                ),
            )
        assertEquals(85, r.hp) // 120 - 25 + 50 - 50 - 10.
        assertEquals(1L, r.cudChewTurn)
        assertEquals(BigInteger.ZERO, r.attackDamage)
        assertNull(r.toxicCounter?.value)
        assertTrue(r.itemConsumed)
    }
}
