package dev.pokemondamage

import dev.pokemondamage.model.*
import dev.pokemondamage.rules.BattleEffects
import kotlin.test.*

class BattleEffectsTest {
    private val field = BattleField()
    private val normal =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.PSYCHIC), PokemonWeight(41)),
            Stats(200, 100, 100, 100, 100, 100),
        )
    private val guts = normal.copy(ability = AbilityId("Guts"))
    private val gas = normal.copy(ability = AbilityId("NeutralizingGas"))
    private val shield = ItemId("AbilityShield")

    private fun flags(vararg entries: Pair<PokemonFlag, Boolean>) = PokemonFlags(mapOf(*entries))

    @Test
    fun `active ability does not infer activation from status HP or weather`() {
        assertEquals(AbilityId("Guts"), BattleEffects.ability(guts, field))
        assertNull(BattleEffects.ability(normal, field))
        assertEquals(AbilityId("Guts"), BattleEffects.ability(guts, field, opponent = normal))
        assertNull(
            BattleEffects.ability(
                guts.copy(flags = flags(PokemonFlag.ABILITY_SUPPRESSED to true)),
                field,
            ),
        )
        assertEquals(
            AbilityId("Guts"),
            BattleEffects.ability(
                guts.copy(flags = flags(PokemonFlag.ABILITY_SUPPRESSED to false)),
                field,
            ),
        )
    }

    @Test
    fun `neutralizing gas suppresses opponents but not itself`() {
        val gasField = field.copy(effects = EnumFlags(FieldEffect.NEUTRALIZING_GAS))
        assertNull(BattleEffects.ability(guts, gasField))
        assertNull(BattleEffects.ability(guts, field, gas))
        assertEquals(AbilityId("NeutralizingGas"), BattleEffects.ability(gas, gasField, gas))
        val suppressedGas = gas.copy(flags = flags(PokemonFlag.ABILITY_SUPPRESSED to true))
        assertEquals(AbilityId("Guts"), BattleEffects.ability(guts, field, suppressedGas))
        assertNull(BattleEffects.ability(suppressedGas, gasField))
        assertNull(
            BattleEffects.ability(
                guts,
                field,
                gas.copy(flags = flags(PokemonFlag.ABILITY_SUPPRESSED to false)),
            ),
        )
    }

    @Test
    fun `ability shield takes precedence over gas and individual suppression`() {
        val shielded =
            guts.copy(item = shield, flags = flags(PokemonFlag.ABILITY_SUPPRESSED to true))
        val gasField = field.copy(effects = EnumFlags(FieldEffect.NEUTRALIZING_GAS))
        assertEquals(AbilityId("Guts"), BattleEffects.ability(shielded, gasField, gas))
        assertNull(BattleEffects.ability(shielded.copy(ability = null), field))
        assertEquals(
            AbilityId("Klutz"),
            BattleEffects.ability(shielded.copy(ability = AbilityId("Klutz")), gasField),
        )
        assertNull(BattleEffects.ability(shielded.copy(itemConsumed = true), field))
        assertNull(BattleEffects.ability(shielded, field, itemConsumed = true))
        assertEquals(
            AbilityId("Guts"),
            BattleEffects.ability(shielded.copy(itemConsumed = true), field, itemConsumed = false),
        )
        assertNull(
            BattleEffects.ability(
                shielded.copy(flags = flags(PokemonFlag.ITEM_SUPPRESSED to true)),
                gasField,
            ),
        )
        assertEquals(
            AbilityId("Guts"),
            BattleEffects.ability(
                shielded.copy(flags = flags(PokemonFlag.ITEM_SUPPRESSED to false)),
                gasField,
            ),
        )
        assertNull(
            BattleEffects.ability(
                shielded,
                field.copy(effects = EnumFlags(FieldEffect.MAGIC_ROOM)),
            ),
        )
    }

    @Test
    fun `item consumption and suppression are independent of ability activation`() {
        val orb = normal.copy(item = ItemId("LifeOrb"))
        assertEquals(ItemId("LifeOrb"), BattleEffects.item(orb, field))
        assertNull(BattleEffects.item(normal, field))
        assertNull(BattleEffects.item(orb.copy(itemConsumed = true), field))
        assertNull(BattleEffects.item(orb, field, itemConsumed = true))
        assertEquals(
            ItemId("LifeOrb"),
            BattleEffects.item(orb.copy(itemConsumed = true), field, itemConsumed = false),
        )
        assertEquals(
            ItemId("LifeOrb"),
            BattleEffects.item(orb.copy(itemConsumed = true), field, ignoreConsumption = true),
        )
        assertEquals(ItemId("LifeOrb"), BattleEffects.item(orb, field, ignoreConsumption = true))
        assertNull(
            BattleEffects.item(orb.copy(flags = flags(PokemonFlag.ITEM_SUPPRESSED to true)), field),
        )
        assertEquals(
            ItemId("LifeOrb"),
            BattleEffects.item(
                orb.copy(flags = flags(PokemonFlag.ITEM_SUPPRESSED to false)),
                field,
            ),
        )
        assertNull(BattleEffects.item(orb, field.copy(effects = EnumFlags(FieldEffect.MAGIC_ROOM))))
        assertNull(
            BattleEffects.item(
                orb.copy(flags = flags(PokemonFlag.ITEM_SUPPRESSED to true)),
                field,
                ignoreConsumption = true,
            ),
        )
    }

    @Test
    fun `klutz disables items unless its ability is suppressed`() {
        val klutz = normal.copy(ability = AbilityId("Klutz"), item = ItemId("LifeOrb"))
        assertNull(BattleEffects.item(klutz, field))
        assertEquals(ItemId("LifeOrb"), BattleEffects.item(klutz, field, gas))
        assertEquals(
            ItemId("LifeOrb"),
            BattleEffects.item(
                klutz.copy(flags = flags(PokemonFlag.ABILITY_SUPPRESSED to true)),
                field,
            ),
        )
        assertNull(BattleEffects.item(klutz.copy(item = shield), field, gas))
    }

    @Test
    fun `tera replaces defensive types except for stellar`() {
        assertEquals(PokemonTypes(PokemonType.PSYCHIC), BattleEffects.currentTypes(normal))
        assertEquals(
            PokemonTypes(PokemonType.PSYCHIC),
            BattleEffects.currentTypes(normal.copy(teraType = TeraType.STELLAR)),
        )
        assertEquals(
            PokemonTypes(PokemonType.WATER),
            BattleEffects.currentTypes(normal.copy(teraType = TeraType.WATER)),
        )
    }

    @Test
    fun `grounding uses effective types abilities and items`() {
        val flying =
            normal.copy(profile = normal.profile.copy(types = PokemonTypes(PokemonType.FLYING)))
        assertTrue(BattleEffects.isGrounded(normal, field, null, null))
        assertFalse(BattleEffects.isGrounded(flying, field, null, null))
        assertTrue(
            BattleEffects.isGrounded(flying.copy(teraType = TeraType.WATER), field, null, null),
        )
        assertFalse(
            BattleEffects.isGrounded(flying.copy(teraType = TeraType.STELLAR), field, null, null),
        )
        for (ability in listOf("Levitate", "Eelevate")) {
            assertFalse(BattleEffects.isGrounded(normal, field, AbilityId(ability), null), ability)
        }
        assertFalse(BattleEffects.isGrounded(normal, field, null, ItemId("AirBalloon")))
        assertTrue(BattleEffects.isGrounded(normal, field, AbilityId("Guts"), ItemId("LifeOrb")))
    }

    @Test
    fun `forced grounding takes precedence over explicit airborne state`() {
        val airborne = normal.copy(flags = flags(PokemonFlag.GROUNDED to false))
        assertFalse(BattleEffects.isGrounded(airborne, field, null, null))
        assertTrue(
            BattleEffects.isGrounded(
                airborne,
                field.copy(gravity = true),
                AbilityId("Levitate"),
                ItemId("AirBalloon"),
            ),
        )
        assertTrue(
            BattleEffects.isGrounded(airborne, field, AbilityId("Levitate"), ItemId("IronBall")),
        )
        val grounded =
            normal.copy(flags = flags(PokemonFlag.GROUNDED to true), teraType = TeraType.FLYING)
        assertTrue(
            BattleEffects.isGrounded(grounded, field, AbilityId("Levitate"), ItemId("AirBalloon")),
        )
    }

    @Test
    fun `cloud nine and air lock suppress each weather`() {
        for (weather in Weather.entries) {
            val weatherField = field.copy(weather = weather)
            assertEquals(
                weather,
                BattleEffects.weather(weatherField, listOf(null, AbilityId("Guts"))),
            )
            for (ability in listOf("CloudNine", "AirLock")) {
                assertNull(
                    BattleEffects.weather(weatherField, listOf(null, AbilityId(ability))),
                    "$weather $ability",
                )
            }
        }
        assertNull(BattleEffects.weather(field, emptyList()))
        assertFalse(BattleEffects.weatherSuppressed(emptyList()))
    }

    @Test
    fun `weight modifiers floor in hectograms and never reduce below one`() {
        assertEquals(41, BattleEffects.weightHectograms(normal, null, null))
        assertEquals(82, BattleEffects.weightHectograms(normal, AbilityId("HeavyMetal"), null))
        assertEquals(20, BattleEffects.weightHectograms(normal, AbilityId("LightMetal"), null))
        assertEquals(20, BattleEffects.weightHectograms(normal, null, ItemId("FloatStone")))
        assertEquals(
            10,
            BattleEffects.weightHectograms(normal, AbilityId("LightMetal"), ItemId("FloatStone")),
        )
        assertEquals(
            41,
            BattleEffects.weightHectograms(normal, AbilityId("HeavyMetal"), ItemId("FloatStone")),
        )
        val tiny = normal.copy(profile = normal.profile.copy(weight = PokemonWeight(1)))
        assertEquals(
            1,
            BattleEffects.weightHectograms(tiny, AbilityId("LightMetal"), ItemId("FloatStone")),
        )
    }
}
