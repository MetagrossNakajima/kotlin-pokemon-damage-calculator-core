package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.BattleFormat
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
import dev.pokemondamage.model.SideConditions
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.StatStage
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.TimesHit
import dev.pokemondamage.model.ToxicCounter
import dev.pokemondamage.model.Weather
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BattleInputTest {
    private val stats = Stats(200, 123, 111, 150, 140, 90)
    private val profile =
        PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.PSYCHIC), PokemonWeight(40))
    private val pokemon = PokemonState(profile, stats)
    private val move = Move(MoveId("Psychic"), PokemonType.PSYCHIC, 90, Category.SPECIAL)

    @Test
    fun `IDs retain exact spelling and permit custom nonempty IDs`() {
        assertEquals("Custom-Form", PokemonId("Custom-Form").value)
        assertEquals("CustomMove", MoveId("CustomMove").value)
        assertEquals("CustomAbility", AbilityId("CustomAbility").value)
        assertEquals("King'sRock", ItemId("King'sRock").value)
        assertNotEquals(MoveId("Psychic"), MoveId("psychic"))
        assertFailsWith<IllegalArgumentException> { PokemonId("") }
        assertFailsWith<IllegalArgumentException> { MoveId("") }
        assertFailsWith<IllegalArgumentException> { AbilityId("") }
        assertFailsWith<IllegalArgumentException> { ItemId("") }
    }

    @Test
    fun `stat lookup preserves all six independent values`() {
        assertEquals(listOf(200, 123, 111, 150, 140, 90), Stat.entries.map { stats[it] })
        assertEquals(200, stats.hp)
        assertEquals(123, stats.attack)
        assertEquals(111, stats.defense)
        assertEquals(150, stats.specialAttack)
        assertEquals(140, stats.specialDefense)
        assertEquals(90, stats.speed)
        assertEquals(Stats(1, 1, 1, 1, 1, 1), Stats(1, 1, 1, 1, 1, 1))
        assertEquals(999, Stats(999, 999, 999, 999, 999, 999).speed)
        for (invalid in listOf(0, 1000)) {
            val constructors =
                listOf<() -> Stats>(
                    { stats.copy(hp = invalid) },
                    { stats.copy(attack = invalid) },
                    { stats.copy(defense = invalid) },
                    { stats.copy(specialAttack = invalid) },
                    { stats.copy(specialDefense = invalid) },
                    { stats.copy(speed = invalid) },
                )
            for (construct in constructors) {
                assertFailsWith<IllegalArgumentException> {
                    construct()
                }
            }
        }
    }

    @Test
    fun `stat stages default to zero and HP has no stage`() {
        val stages = StatStages.fromValues(-6, -3, 1, 4, 6)
        assertEquals(listOf(null, -6, -3, 1, 4, 6), Stat.entries.map { stages[it]?.value })
        assertEquals(
            listOf(-6, -3, 1, 4, 6),
            listOf(
                stages.attack.value,
                stages.defense.value,
                stages.specialAttack.value,
                stages.specialDefense.value,
                stages.speed.value,
            ),
        )
        assertEquals(
            listOf(null, 0, 0, 0, 0, 0),
            Stat.entries.map { StatStages.fromValues()[it]?.value },
        )
        for (invalid in listOf(-7, 7)) {
            val constructors =
                listOf<() -> StatStages>(
                    { stages.copy(attack = StatStage(invalid)) },
                    { stages.copy(defense = StatStage(invalid)) },
                    { stages.copy(specialAttack = StatStage(invalid)) },
                    { stages.copy(specialDefense = StatStage(invalid)) },
                    { stages.copy(speed = StatStage(invalid)) },
                )
            for (construct in constructors) {
                assertFailsWith<IllegalArgumentException> {
                    construct()
                }
            }
        }
    }

    @Test
    fun `types preserve order and reject duplicates even through copy`() {
        val types = PokemonTypes(PokemonType.FIRE, PokemonType.FLYING)
        assertEquals(PokemonType.FIRE, types.primary)
        assertEquals(PokemonType.FLYING, types.secondary)
        assertTrue(PokemonType.FIRE in types)
        assertTrue(PokemonType.FLYING in types)
        assertFalse(PokemonType.WATER in types)
        assertFalse(PokemonType.WATER in PokemonTypes(PokemonType.FIRE))
        assertEquals(listOf(PokemonType.FIRE, PokemonType.FLYING), types.toList())
        assertEquals(listOf(PokemonType.FIRE), PokemonTypes(PokemonType.FIRE).toList())
        assertFailsWith<IllegalArgumentException> { types.copy(secondary = PokemonType.FIRE) }
        val view = types.toList()
        (view as MutableList).clear()
        assertEquals(listOf(PokemonType.FIRE, PokemonType.FLYING), types.toList())
    }

    @Test
    fun `weight accepts exactly the source domain in tenths of a kilogram`() {
        for (hectograms in 1..9999) {
            val weight = PokemonWeight.fromKilograms(hectograms / 10.0)
            assertEquals(hectograms, weight.hectograms)
            assertEquals(hectograms / 10.0, weight.kilograms)
        }
        for (invalid in listOf(0, 10000, Int.MIN_VALUE, Int.MAX_VALUE)) {
            assertFailsWith<IllegalArgumentException> { PokemonWeight(invalid) }
        }
        for (
        invalid in
        listOf(
            Double.NaN,
            Double.POSITIVE_INFINITY,
            Double.NEGATIVE_INFINITY,
            -1.0,
            0.0,
            0.09,
            0.15,
            999.99,
            1000.0,
        )
        ) {
            assertFailsWith<IllegalArgumentException> { PokemonWeight.fromKilograms(invalid) }
        }
    }

    @Test
    fun `tera retains ordinary type identity and stellar has no ordinary type`() {
        for (type in PokemonType.entries) {
            assertEquals(
                type,
                TeraType.valueOf(type.name).pokemonType,
            )
        }
        assertNull(TeraType.STELLAR.pokemonType)
        assertEquals(19, TeraType.entries.size)
    }

    @Test
    fun `state defaults do not activate or infer abilities or battle flags`() {
        assertEquals(profile, pokemon.profile)
        assertEquals(PokemonId("Mew"), profile.id)
        assertEquals(PokemonTypes(PokemonType.PSYCHIC), profile.types)
        assertEquals(PokemonWeight(40), profile.weight)
        assertEquals(Gender.GENDERLESS, profile.gender)
        assertEquals(stats, pokemon.stats)
        assertEquals(StatStages.fromValues(), pokemon.stages)
        assertNull(pokemon.ability)
        assertNull(pokemon.item)
        assertNull(pokemon.status)
        assertNull(pokemon.currentHp)
        assertEquals(200, pokemon.hp)
        assertNull(pokemon.toxicCounter?.value)
        assertFalse(pokemon.itemConsumed)
        assertNull(pokemon.cudChewTurn)
        assertNull(pokemon.teraType)
        assertNull(pokemon.boostedStat)
        assertEquals(0, pokemon.faintedAllies.value)
        assertEquals(0, pokemon.timesHit.value)
        assertEquals(PokemonFlags(), pokemon.flags)
        assertFalse(pokemon.sideConditions.reflect)
        assertFalse(pokemon.sideConditions.lightScreen)
    }

    @Test
    fun `explicit battle state preserves all supplied fields`() {
        val configured =
            pokemon.copy(
                stages = StatStages.fromValues(attack = 2),
                ability = AbilityId("Blaze"),
                item = ItemId("LifeOrb"),
                status = Status.TOXIC,
                sideConditions = SideConditions(true, true),
                currentHp = 1,
                toxicCounter = ToxicCounter(15),
                itemConsumed = true,
                cudChewTurn = -1,
                teraType = TeraType.STELLAR,
                boostedStat = Stat.ATTACK,
                faintedAllies = FaintedAllies(100),
                timesHit = TimesHit(100),
                flags = PokemonFlags(mapOf(PokemonFlag.GROUNDED to false)),
            )
        assertEquals(2, configured.stages.attack.value)
        assertEquals(AbilityId("Blaze"), configured.ability)
        assertEquals(ItemId("LifeOrb"), configured.item)
        assertEquals(Status.TOXIC, configured.status)
        assertEquals(1, configured.currentHp)
        assertEquals(1, configured.hp)
        assertEquals(15, configured.toxicCounter?.value)
        assertTrue(configured.itemConsumed)
        assertEquals(-1L, configured.cudChewTurn)
        assertEquals(TeraType.STELLAR, configured.teraType)
        assertEquals(Stat.ATTACK, configured.boostedStat)
        assertEquals(100, configured.faintedAllies.value)
        assertEquals(100, configured.timesHit.value)
        assertEquals(false, configured.flags[PokemonFlag.GROUNDED])
        assertTrue(configured.sideConditions.reflect)
        assertTrue(configured.sideConditions.lightScreen)
        // HPが満タンで天候がなくても、入力された特性は発動済みとして扱う。
        assertEquals(AbilityId("Blaze"), pokemon.copy(ability = AbilityId("Blaze")).ability)
        assertEquals(200, pokemon.copy(currentHp = 200).hp)
        assertEquals(
            1,
            pokemon.copy(status = Status.TOXIC, toxicCounter = ToxicCounter(1)).toxicCounter?.value,
        )
    }

    @Test
    fun `invalid and inconsistent state cannot be introduced through copy`() {
        for (hp in listOf(0, 201)) {
            assertFailsWith<IllegalArgumentException> {
                pokemon.copy(currentHp = hp)
            }
        }
        assertFailsWith<IllegalArgumentException> { pokemon.copy(status = Status.TOXIC) }
        assertFailsWith<IllegalArgumentException> { pokemon.copy(toxicCounter = ToxicCounter(1)) }
        assertFailsWith<IllegalArgumentException> {
            pokemon.copy(status = Status.POISON, toxicCounter = ToxicCounter(1))
        }
        for (counter in listOf(0, 16)) {
            assertFailsWith<IllegalArgumentException> {
                pokemon.copy(status = Status.TOXIC, toxicCounter = ToxicCounter(counter))
            }
        }
        assertFailsWith<IllegalArgumentException> { pokemon.copy(boostedStat = Stat.HP) }
        for (count in listOf(-1, 101)) {
            assertFailsWith<IllegalArgumentException> {
                pokemon.copy(
                    faintedAllies = FaintedAllies(count),
                )
            }
            assertFailsWith<IllegalArgumentException> { pokemon.copy(timesHit = TimesHit(count)) }
        }
    }

    @Test
    fun `move metadata preserves caller overrides and validates bounds`() {
        assertEquals(MoveId("Psychic"), move.id)
        assertEquals(PokemonType.PSYCHIC, move.type)
        assertEquals(90, move.power)
        assertEquals(Category.SPECIAL, move.category)
        assertFalse(move.spread)
        assertEquals(0, move.priority)
        assertEquals(EnumFlags(), move.flags)
        val configured =
            move.copy(
                power = 1000,
                category = Category.PHYSICAL,
                priority = 5,
                spread = true,
                flags = EnumFlags(MoveFlag.CONTACT, MoveFlag.PUNCH),
            )
        assertEquals(1000, configured.power)
        assertEquals(Category.PHYSICAL, configured.category)
        assertEquals(5, configured.priority)
        assertTrue(configured.spread)
        assertTrue(MoveFlag.PUNCH in configured.flags)
        assertEquals(-7, move.copy(priority = -7).priority)
        assertEquals(1, move.copy(power = 1).power)
        for (power in listOf(-1, 0, 1001)) {
            assertFailsWith<IllegalArgumentException> {
                move.copy(power = power)
            }
        }
        for (priority in listOf(-8, 6)) {
            assertFailsWith<IllegalArgumentException> {
                move.copy(priority = priority)
            }
        }
    }

    @Test
    fun `battle field and request preserve shared conditions and hit position`() {
        val defaultField = BattleField()
        assertEquals(BattleFormat.SINGLE, defaultField.format)
        assertNull(defaultField.weather)
        assertNull(defaultField.terrain)
        assertFalse(defaultField.gravity)
        assertEquals(EnumFlags(), defaultField.effects)
        val field =
            BattleField(
                BattleFormat.DOUBLE,
                Weather.RAIN,
                Terrain.ELECTRIC,
                true,
                EnumFlags(FieldEffect.HELPING_HAND),
            )
        val request = DamageRequest(pokemon, pokemon.copy(currentHp = 50), move, field, true, 2)
        assertEquals(pokemon, request.attacker)
        assertEquals(50, request.defender.hp)
        assertEquals(move, request.move)
        assertEquals(field, request.field)
        assertEquals(BattleFormat.DOUBLE, request.field.format)
        assertEquals(Weather.RAIN, request.field.weather)
        assertEquals(Terrain.ELECTRIC, request.field.terrain)
        assertTrue(request.field.gravity)
        assertTrue(FieldEffect.HELPING_HAND in request.field.effects)
        assertTrue(request.critical)
        assertEquals(2L, request.hitIndex)
        val defaults = DamageRequest(pokemon, pokemon, move)
        assertEquals(defaultField, defaults.field)
        assertFalse(defaults.critical)
        assertEquals(0L, defaults.hitIndex)
        assertFailsWith<IllegalArgumentException> { request.copy(hitIndex = -1) }
    }
}
