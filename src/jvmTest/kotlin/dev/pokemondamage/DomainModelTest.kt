package dev.pokemondamage

import dev.pokemondamage.model.BattleFormat
import dev.pokemondamage.model.EntryHazards
import dev.pokemondamage.model.FaintedAllies
import dev.pokemondamage.model.InputValidationException
import dev.pokemondamage.model.Spikes
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.StatStage
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.TimesHit
import dev.pokemondamage.model.ToxicCounter
import dev.pokemondamage.model.Validation
import dev.pokemondamage.model.ValidationCode
import dev.pokemondamage.model.ValidationError
import dev.pokemondamage.model.Weather
import dev.pokemondamage.model.validate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertNull

class DomainModelTest {
    @Test
    fun `spikes distinguishes absence from all three damage fractions`() {
        assertEquals(
            listOf(null, 8, 6, 4),
            (0..3).map { Spikes.fromLayers(it).damageDenominator },
        )
        assertEquals(Spikes.TWO_LAYERS, EntryHazards(spikes = Spikes.TWO_LAYERS).spikes)
        for (layers in listOf(Int.MIN_VALUE, -1, 4, Int.MAX_VALUE)) {
            val result = validate { Spikes.fromLayers(layers) }
            assertEquals(
                listOf(ValidationError("layers", ValidationCode.OUT_OF_RANGE)),
                assertIs<Validation.Invalid>(result).errors,
            )
        }
    }

    @Test
    fun `stat ranks own exact fractions and critical filtering`() {
        assertEquals(
            listOf(
                2 to 8,
                2 to 7,
                2 to 6,
                2 to 5,
                2 to 4,
                2 to 3,
                2 to 2,
                3 to 2,
                4 to 2,
                5 to 2,
                6 to 2,
                7 to 2,
                8 to 2,
            ),
            (-6..6).map { StatStage(it).let { stage -> stage.numerator to stage.denominator } },
        )
        for ((rank, positive, negative) in listOf(
            Triple(-6, 0, -6),
            Triple(0, 0, 0),
            Triple(6, 6, 0),
        )) {
            val stage = StatStage(rank)
            assertEquals(StatStage(positive), stage.ignoringNegative())
            assertEquals(StatStage(negative), stage.ignoringPositive())
            assertEquals(positive, stage.positive)
        }
        val stages = StatStages(attack = StatStage(2), speed = StatStage(-1))
        assertEquals(StatStage(2), stages[Stat.ATTACK])
        assertEquals(StatStage(-1), stages[Stat.SPEED])
        assertNull(stages[Stat.HP])
        for (value in listOf(-7, 7)) assertFailsWith<InputValidationException> { StatStage(value) }
    }

    @Test
    fun `toxic counter advances once and saturates at fifteen`() {
        var counter = ToxicCounter.INITIAL
        val sequence =
            buildList {
                repeat(17) {
                    add(counter.value)
                    counter = counter.next()
                }
            }
        assertEquals((1..15).toList() + listOf(15, 15), sequence)
        for (value in listOf(
            0,
            16,
        )) {
            assertFailsWith<InputValidationException> { ToxicCounter(value) }
        }
    }

    @Test
    fun `historical counters preserve their distinct power caps and exact modifiers`() {
        assertEquals(
            listOf(4096, 4506, 4915, 5325, 5734, 6144, 6144),
            (0..6).map { FaintedAllies(it).supremeOverlordModifier },
        )
        assertEquals(
            listOf(50L, 300L, 350L, 5050L),
            listOf(0, 5, 6, 100).map { FaintedAllies(it).lastRespectsPower },
        )
        assertEquals(
            listOf(50L, 300L, 350L, 350L, 350L),
            listOf(0, 5, 6, 7, 100).map { TimesHit(it).rageFistPower },
        )
        assertEquals(6144, FaintedAllies(100).supremeOverlordModifier)
        for (value in listOf(-1, 101)) {
            assertFailsWith<InputValidationException> { FaintedAllies(value) }
            assertFailsWith<InputValidationException> { TimesHit(value) }
        }
    }

    @Test
    fun `environment mappings distinguish move conversion from terrain boosts`() {
        assertEquals(
            listOf(TeraType.FIRE, TeraType.WATER, TeraType.ROCK, TeraType.ICE),
            Weather.entries.map { it.weatherBallType },
        )
        assertEquals(
            listOf(TeraType.ELECTRIC, TeraType.GRASS, TeraType.FAIRY, TeraType.PSYCHIC),
            Terrain.entries.map { it.terrainPulseType },
        )
        assertEquals(
            listOf(TeraType.ELECTRIC, TeraType.GRASS, null, TeraType.PSYCHIC),
            Terrain.entries.map { it.boostedType },
        )
        assertEquals(listOf(2048, 2732), BattleFormat.entries.map { it.screenModifier })
    }
}
