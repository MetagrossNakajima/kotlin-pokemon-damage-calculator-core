package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class DamageContextTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(40)),
            Stats(200, 100, 100, 100, 100, 100),
        )
    private val move = Move(MoveId("Tackle"), PokemonType.NORMAL, 40, Category.PHYSICAL)

    private fun context(
        attacker: PokemonState = pokemon,
        defender: PokemonState = pokemon,
        move: Move = this.move,
        field: BattleField = BattleField(),
    ) = DamageContext(DamageRequest(attacker, defender, move, field))

    @Test
    fun `mold breakers ignore eligible abilities and preserve unignorable abilities`() {
        for (name in listOf("MoldBreaker", "Teravolt", "Turboblaze")) {
            val attacker = pokemon.copy(ability = AbilityId(name))
            val defender = pokemon.copy(ability = AbilityId("Levitate"))
            val ctx = context(attacker, defender)
            assertEquals(attacker, ctx.attacker)
            assertEquals(defender, ctx.defender)
            assertEquals(AbilityId("Levitate"), ctx.activeDefenderAbility)
            assertNull(ctx.defenderAbility)
            assertTrue(ctx.defenderGrounded)
            assertEquals(
                AbilityId("ShadowShield"),
                context(attacker, defender.copy(ability = AbilityId("ShadowShield")))
                    .defenderAbility,
            )
            assertNull(context(attacker).defenderAbility)
        }
        val levitate = context(defender = pokemon.copy(ability = AbilityId("Levitate")))
        assertEquals(AbilityId("Levitate"), levitate.defenderAbility)
        assertFalse(levitate.defenderGrounded)
    }

    @Test
    fun `ability ignoring moves work without mold breaker`() {
        for (name in listOf("SunsteelStrike", "MoongeistBeam", "PhotonGeyser")) {
            assertNull(
                context(
                    defender = pokemon.copy(ability = AbilityId("Multiscale")),
                    move = move.copy(id = MoveId(name)),
                ).defenderAbility,
                name,
            )
        }
    }

    @Test
    fun `Ability Shield protects against mold breaker only while effective`() {
        val attacker = pokemon.copy(ability = AbilityId("MoldBreaker"))
        val defender = pokemon.copy(ability = AbilityId("Levitate"), item = ItemId("AbilityShield"))
        assertEquals(AbilityId("Levitate"), context(attacker, defender).defenderAbility)
        assertEquals(ItemId("AbilityShield"), context(attacker, defender).defenderItem)
        assertNull(context(attacker, defender.copy(itemConsumed = true)).defenderAbility)
        assertNull(context(attacker, defender.copy(ability = null)).defenderAbility)
        assertNull(
            context(
                attacker,
                defender,
                field = BattleField(effects = EnumFlags(FieldEffect.MAGIC_ROOM)),
            ).defenderAbility,
        )
    }

    @Test
    fun `weather suppression uses defender ability before move-specific ignoring`() {
        val ctx =
            context(
                defender = pokemon.copy(ability = AbilityId("AirLock")),
                move = move.copy(id = MoveId("SunsteelStrike")),
                field = BattleField(weather = Weather.RAIN),
            )
        assertNull(ctx.weather)
        assertEquals(Weather.RAIN, ctx.field.weather)
        val megaSol = pokemon.copy(ability = AbilityId("MegaSol"))
        assertEquals(Weather.SUNLIGHT, context(megaSol).weather)
        assertNull(context(megaSol, pokemon.copy(ability = AbilityId("CloudNine"))).weather)
        assertEquals(Weather.RAIN, context(field = BattleField(weather = Weather.RAIN)).weather)
    }

    @Test
    fun `physical defense selection follows effective category and three special moves`() {
        assertTrue(context().physical)
        assertTrue(context().physicalDefense)
        val special = move.copy(category = Category.SPECIAL)
        assertFalse(context(move = special).physical)
        assertFalse(context(move = special).physicalDefense)
        for (name in listOf("Psyshock", "Psystrike", "SecretSword")) {
            val ctx = context(move = special.copy(id = MoveId(name)))
            assertFalse(ctx.physical)
            assertTrue(ctx.physicalDefense)
        }
    }

    @Test
    fun `Unnerve and both As One abilities block berries as does the field`() {
        assertFalse(context().unnerve)
        for (name in listOf("Unnerve", "AsOneGlastrier", "AsOneSpectrier")) {
            assertTrue(context(attacker = pokemon.copy(ability = AbilityId(name))).unnerve, name)
        }
        assertTrue(context(field = BattleField(effects = EnumFlags(FieldEffect.UNNERVE))).unnerve)
        assertFalse(
            context(
                attacker = pokemon.copy(ability = AbilityId("Unnerve")),
                defender = pokemon.copy(ability = AbilityId("NeutralizingGas")),
            ).unnerve,
        )
    }

    @Test
    fun `contact is removed by Long Reach and by Punching Glove for punches only`() {
        val contact = move.copy(flags = EnumFlags(MoveFlag.CONTACT))
        val punch = move.copy(flags = EnumFlags(MoveFlag.CONTACT, MoveFlag.PUNCH))
        assertFalse(context().contact)
        assertTrue(context(move = contact).contact)
        assertFalse(context(pokemon.copy(ability = AbilityId("LongReach")), move = contact).contact)
        val glove = pokemon.copy(item = ItemId("PunchingGlove"))
        assertFalse(context(glove, move = punch).contact)
        assertTrue(context(glove, move = contact).contact)
        assertTrue(context(glove.copy(itemConsumed = true), move = punch).contact)
        assertEquals(ItemId("PunchingGlove"), context(glove).attackerItem)
    }

    @Test
    fun `context exposes current defending types and attacker grounding`() {
        val ctx =
            context(
                attacker = pokemon.copy(ability = AbilityId("Levitate")),
                defender = pokemon.copy(teraType = TeraType.FAIRY),
            )
        assertEquals(PokemonTypes(PokemonType.FAIRY), ctx.defenderTypes)
        assertFalse(ctx.attackerGrounded)
        assertTrue(context().attackerGrounded)
    }
}
