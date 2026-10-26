package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.EnumFlags
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
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.Weather
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

class MovePreparationTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(40)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun context(
        name: String = "Tackle",
        attacker: PokemonState = pokemon,
        defender: PokemonState = pokemon,
        field: BattleField = BattleField(),
        type: PokemonType = PokemonType.NORMAL,
        power: Int = 50,
        flags: EnumFlags<MoveFlag> = EnumFlags(),
        category: Category = Category.SPECIAL,
    ): DamageContext =
        DamageContext(
            DamageRequest(
                attacker,
                defender,
                Move(MoveId(name), type, power, category, flags = flags),
                field,
            ),
        )

    @Test
    fun `ordinary move retains metadata and inputs remain unchanged`() {
        val original =
            Move(
                MoveId("Custom"),
                PokemonType.FIRE,
                77,
                Category.PHYSICAL,
                true,
                EnumFlags(MoveFlag.CONTACT),
                2,
            )
        val request = DamageRequest(pokemon, pokemon, original, hitIndex = 3)
        val context = DamageContext(request)
        assertSame(request, context.request)
        assertSame(original, context.move.original)
        assertEquals(TeraType.FIRE, context.move.type)
        assertEquals(77, context.move.power)
        assertEquals(Category.PHYSICAL, context.move.category)
        assertEquals(3L, context.request.hitIndex)
        assertEquals(77, original.power)
    }

    @Test
    fun `Judgment uses only an active plate and leaves the caller move untouched`() {
        val attacker = pokemon.copy(item = ItemId("FlamePlate"), ability = AbilityId("Normalize"))
        val prepared = context("Judgment", attacker).move
        assertEquals(TeraType.FIRE, prepared.type)
        assertEquals(PokemonType.NORMAL, prepared.original.type)
        assertEquals(
            TeraType.NORMAL,
            context("Judgment", attacker.copy(itemConsumed = true)).move.type,
        )
        assertEquals(
            TeraType.NORMAL,
            context("Judgment", attacker.copy(item = ItemId("Charcoal"))).move.type,
        )
        assertEquals(
            TeraType.NORMAL,
            context("Judgment", attacker.copy(item = ItemId("UnknownPlate"))).move.type,
        )
        assertEquals(
            TeraType.NORMAL,
            context("Judgment", attacker.copy(item = ItemId("BlankPlate"))).move.type,
        )
    }

    @Test
    fun `Ivy Cudgel custom species retains caller type and Normalize applies after the form`() {
        assertEquals(TeraType.ICE, context("IvyCudgel", type = PokemonType.ICE).move.type)
        val ogerpon =
            pokemon.copy(
                profile = pokemon.profile.copy(id = PokemonId("Ogerpon-Hearthflame")),
                ability = AbilityId("Normalize"),
            )
        assertEquals(TeraType.NORMAL, context("IvyCudgel", ogerpon).move.type)
    }

    @Test
    fun `Shell Side Arm updates category and contact without changing original flags`() {
        val physical =
            context(
                "ShellSideArm",
                pokemon.copy(stages = StatStages.fromValues(attack = 1)),
                type = PokemonType.POISON,
            )
        assertEquals(Category.PHYSICAL, physical.move.category)
        assertTrue(physical.contact)
        assertFalse(MoveFlag.CONTACT in physical.move.original.flags)
        val special =
            context(
                "ShellSideArm",
                category = Category.PHYSICAL,
                flags = EnumFlags(MoveFlag.CONTACT, MoveFlag.BULLET),
            )
        assertEquals(Category.SPECIAL, special.move.category)
        assertFalse(special.contact)
        assertTrue(MoveFlag.BULLET in special.move.flags)
        assertTrue(MoveFlag.CONTACT in special.move.original.flags)
        val longReach =
            context(
                "ShellSideArm",
                pokemon.copy(
                    stages = StatStages.fromValues(attack = 1),
                    ability = AbilityId("LongReach"),
                ),
            )
        assertEquals(Category.PHYSICAL, longReach.move.category)
        assertFalse(longReach.contact)
    }

    @Test
    fun `charge moves retain the caller supplied stages instead of adding another boost`() {
        val boosted = pokemon.copy(stages = StatStages.fromValues(specialAttack = 1))
        for (name in listOf("MeteorBeam", "ElectroShot")) {
            val prepared = context(name, boosted)
            assertSame(boosted, prepared.attacker)
            assertEquals(1, prepared.attacker.stages.specialAttack.value)
        }
    }

    @Test
    fun `Tera Blast uses tera type and staged offensive stats with special winning ties`() {
        assertEquals(TeraType.NORMAL, context("TeraBlast").move.type)
        for (tera in TeraType.entries) {
            val equal = context("TeraBlast", pokemon.copy(teraType = tera)).move
            assertEquals(tera, equal.type)
            assertEquals(if (tera == TeraType.STELLAR) 100 else 80, equal.power)
            assertEquals(Category.SPECIAL, equal.category)
        }
        val physical =
            pokemon.copy(
                teraType = TeraType.WATER,
                stages = StatStages.fromValues(attack = 1),
                ability = AbilityId("Normalize"),
            )
        assertEquals(Category.PHYSICAL, context("TeraBlast", physical).move.category)
        assertEquals(TeraType.WATER, context("TeraBlast", physical).move.type)
        assertEquals(
            Category.SPECIAL,
            context("TeraBlast", physical.copy(stages = StatStages.fromValues(specialAttack = 1)))
                .move
                .category,
        )
        assertEquals(
            Category.SPECIAL,
            context(
                "TeraBlast",
                pokemon.copy(
                    teraType = TeraType.FIRE,
                    ability = AbilityId("HugePower"),
                    item = ItemId("ChoiceBand"),
                ),
            ).move
                .category,
        )
        assertEquals(
            TeraType.FLYING,
            context("TeraBlast", pokemon.copy(ability = AbilityId("Aerilate"))).move.type,
        )
    }

    @Test
    fun `Tera Starstorm depends on Stellar Terapagos form and tera activation`() {
        assertEquals(TeraType.NORMAL, context("TeraStarstorm").move.type)
        val stellar =
            pokemon.copy(
                profile = pokemon.profile.copy(id = PokemonId("Terapagos-Stellar")),
                stages = StatStages.fromValues(attack = 1),
            )
        assertEquals(TeraType.STELLAR, context("TeraStarstorm", stellar).move.type)
        assertEquals(Category.SPECIAL, context("TeraStarstorm", stellar).move.category)
        assertEquals(
            Category.PHYSICAL,
            context("TeraStarstorm", stellar.copy(teraType = TeraType.STELLAR)).move.category,
        )
        assertEquals(120, context("TeraStarstorm", stellar, power = 120).move.power)
    }

    @Test
    fun `Photon Geyser adapts category even when Normalize changes its type`() {
        val attacker =
            pokemon.copy(
                stages = StatStages.fromValues(attack = 2),
                ability = AbilityId("Normalize"),
            )
        val move = context("PhotonGeyser", attacker, type = PokemonType.PSYCHIC).move
        assertEquals(Category.PHYSICAL, move.category)
        assertEquals(TeraType.NORMAL, move.type)
        assertEquals(Category.SPECIAL, context("PhotonGeyser").move.category)
    }

    @Test
    fun `Weather Ball follows every effective weather before skin abilities`() {
        val types =
            mapOf(
                null to TeraType.NORMAL,
                Weather.SUNLIGHT to TeraType.FIRE,
                Weather.RAIN to TeraType.WATER,
                Weather.SANDSTORM to TeraType.ROCK,
                Weather.SNOW to TeraType.ICE,
            )
        for ((weather, type) in types) {
            val prepared =
                context(
                    "WeatherBall",
                    pokemon.copy(ability = AbilityId("Aerilate")),
                    field = BattleField(weather = weather),
                ).move
            assertEquals(type, prepared.type, "$weather")
            assertEquals(if (weather == null) 50 else 100, prepared.power, "$weather")
        }
        val suppressed =
            context(
                "WeatherBall",
                defender = pokemon.copy(ability = AbilityId("CloudNine")),
                field = BattleField(weather = Weather.SUNLIGHT),
            ).move
        assertEquals(TeraType.NORMAL, suppressed.type)
        assertEquals(50, suppressed.power)
    }

    @Test
    fun `Utility Umbrella blocks sun and rain but preserves sand and snow Weather Ball`() {
        val attacker = pokemon.copy(item = ItemId("UtilityUmbrella"))
        for (weather in Weather.entries) {
            val move = context("WeatherBall", attacker, field = BattleField(weather = weather)).move
            val expected =
                when (weather) {
                    Weather.SANDSTORM -> TeraType.ROCK
                    Weather.SNOW -> TeraType.ICE
                    else -> TeraType.NORMAL
                }
            assertEquals(expected, move.type)
            assertEquals(
                if (weather in setOf(Weather.SANDSTORM, Weather.SNOW)) 100 else 50,
                move.power,
            )
        }
        assertEquals(50, context("WeatherBall", attacker).move.power)
        assertEquals(
            TeraType.FIRE,
            context(
                "WeatherBall",
                attacker.copy(itemConsumed = true),
                field = BattleField(weather = Weather.SUNLIGHT),
            ).move
                .type,
        )
        assertEquals(
            100,
            context(
                "WeatherBall",
                defender = attacker,
                field = BattleField(weather = Weather.SUNLIGHT),
            ).move
                .power,
        )
    }

    @Test
    fun `Mega Sol Weather Ball preserves umbrella power exception and actual sand or snow type`() {
        val attacker = pokemon.copy(ability = AbilityId("MegaSol"))
        for (weather in listOf(null) + Weather.entries) {
            val plain =
                context("WeatherBall", attacker, field = BattleField(weather = weather)).move
            assertEquals(TeraType.FIRE, plain.type)
            assertEquals(100, plain.power)
            val umbrella =
                context(
                    "WeatherBall",
                    attacker.copy(item = ItemId("UtilityUmbrella")),
                    field = BattleField(weather = weather),
                ).move
            assertEquals(
                when (weather) {
                    Weather.SANDSTORM -> TeraType.ROCK
                    Weather.SNOW -> TeraType.ICE
                    else -> TeraType.NORMAL
                },
                umbrella.type,
            )
            assertEquals(100, umbrella.power)
        }
        val suppressed =
            context(
                "WeatherBall",
                attacker.copy(item = ItemId("UtilityUmbrella")),
                pokemon.copy(ability = AbilityId("AirLock")),
                BattleField(weather = Weather.SNOW),
            )
        assertNull(suppressed.weather)
        assertEquals(50, suppressed.move.power)
        assertEquals(TeraType.NORMAL, suppressed.move.type)
    }

    @Test
    fun `Terrain Pulse requires terrain and grounding and precedes Normalize`() {
        val types =
            mapOf(
                Terrain.ELECTRIC to TeraType.ELECTRIC,
                Terrain.GRASS to TeraType.GRASS,
                Terrain.MISTY to TeraType.FAIRY,
                Terrain.PSYCHIC to TeraType.PSYCHIC,
            )
        assertEquals(50, context("TerrainPulse").move.power)
        for ((terrain, type) in types) {
            val move =
                context(
                    "TerrainPulse",
                    pokemon.copy(ability = AbilityId("Normalize")),
                    field = BattleField(terrain = terrain),
                ).move
            assertEquals(type, move.type)
            assertEquals(100, move.power)
            val airborne =
                context(
                    "TerrainPulse",
                    pokemon.copy(ability = AbilityId("Levitate")),
                    field = BattleField(terrain = terrain),
                ).move
            assertEquals(TeraType.NORMAL, airborne.type)
            assertEquals(50, airborne.power)
        }
    }

    @Test
    fun `Raging Bull follows Tauros form and Normalize override`() {
        for (
        (id, type) in
        mapOf(
            "Tauros-Paldea-Combat" to TeraType.FIGHTING,
            "Tauros-Paldea-Blaze" to TeraType.FIRE,
            "Tauros-Paldea-Aqua" to TeraType.WATER,
            "Tauros" to TeraType.NORMAL,
        )
        ) {
            val attacker = pokemon.copy(profile = pokemon.profile.copy(id = PokemonId(id)))
            assertEquals(type, context("RagingBull", attacker).move.type)
            assertEquals(
                TeraType.NORMAL,
                context("RagingBull", attacker.copy(ability = AbilityId("Normalize"))).move.type,
            )
        }
    }

    @Test
    fun `each skin converts Normal but leaves other types unchanged`() {
        for (
        (name, type) in
        mapOf(
            "Galvanize" to TeraType.ELECTRIC,
            "Aerilate" to TeraType.FLYING,
            "Pixilate" to TeraType.FAIRY,
            "Refrigerate" to TeraType.ICE,
            "Dragonize" to TeraType.DRAGON,
        )
        ) {
            val attacker = pokemon.copy(ability = AbilityId(name))
            assertEquals(type, context(attacker = attacker).move.type, name)
            assertEquals(
                TeraType.WATER,
                context(attacker = attacker, type = PokemonType.WATER).move.type,
                name,
            )
        }
    }

    @Test
    fun `Liquid Voice changes only sound moves and Normalize changes arbitrary types`() {
        val singer = pokemon.copy(ability = AbilityId("LiquidVoice"))
        assertEquals(
            TeraType.WATER,
            context(attacker = singer, flags = EnumFlags(MoveFlag.SOUND)).move.type,
        )
        assertEquals(TeraType.NORMAL, context(attacker = singer).move.type)
        assertEquals(
            TeraType.NORMAL,
            context(
                attacker = pokemon.copy(ability = AbilityId("Normalize")),
                type = PokemonType.FIRE,
            ).move
                .type,
        )
        val muted = singer.copy(flags = PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true)))
        assertEquals(
            TeraType.NORMAL,
            context(attacker = muted, flags = EnumFlags(MoveFlag.SOUND)).move.type,
        )
    }
}
