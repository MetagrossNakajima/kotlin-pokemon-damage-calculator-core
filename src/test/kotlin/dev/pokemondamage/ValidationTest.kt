package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleSetup
import dev.pokemondamage.model.CalculationLimits
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EntryHazards
import dev.pokemondamage.model.ExactProbability
import dev.pokemondamage.model.HitResult
import dev.pokemondamage.model.InputValidationException
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Spikes
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.ToxicCounter
import dev.pokemondamage.model.Validation
import dev.pokemondamage.model.ValidationCode
import dev.pokemondamage.model.ValidationError
import dev.pokemondamage.model.validate
import dev.pokemondamage.model.validateEnum
import dev.pokemondamage.model.zip
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertSame

class ValidationTest {
    private fun range(path: String) = ValidationError(path, ValidationCode.OUT_OF_RANGE)

    @Test
    fun `stats report every invalid field in declaration order`() {
        val result = validate("defender.stats") { Stats(0, 1000, -1, 1000, 0, 1000) }
        assertEquals(
            listOf("hp", "attack", "defense", "specialAttack", "specialDefense", "speed").map {
                range("defender.stats.$it")
            },
            assertIs<Validation.Invalid>(result).errors,
        )
        val error = assertFailsWith<InputValidationException> { Stats(0, 100, 100, 100, 100, 0) }
        assertEquals(listOf(range("hp"), range("speed")), error.failure.errors)
        assertEquals("hp: OUT_OF_RANGE, speed: OUT_OF_RANGE", error.message)
    }

    @Test
    fun `stage diagnostics and successful values retain constructor semantics`() {
        val invalid = validate { StatStages.fromValues(-7, 7, -7, 7, -7) }
        assertEquals(
            listOf("attack", "defense", "specialAttack", "specialDefense", "speed").map(::range),
            assertIs<Validation.Invalid>(invalid).errors,
        )
        val valid = validate { Stats(1, 999, 100, 100, 100, 100) }
        assertEquals(
            Stats(1, 999, 100, 100, 100, 100),
            assertIs<Validation.Valid<Stats>>(valid).value,
        )
        assertEquals(
            Validation.Valid(StatStages.fromValues()),
            validate { StatStages.fromValues() },
        )
    }

    @Test
    fun `independent invalid inputs combine without executing the model builder`() {
        val stats = validate("stats") { Stats(0, 100, 100, 100, 100, 100) }
        val stages = validate("stages") { StatStages.fromValues(speed = 7) }
        val both = stats.zip(stages) { _, _ -> error("invalid inputs must not reach builder") }
        assertEquals(
            listOf(range("stats.hp"), range("stages.speed")),
            assertIs<Validation.Invalid>(both).errors,
        )
        val goodStats = validate { Stats(100, 100, 100, 100, 100, 100) }
        val goodStages = validate { StatStages.fromValues() }
        assertSame(stats, stats.zip(goodStages) { _, _ -> error("invalid left") })
        assertSame(stages, goodStats.zip(stages) { _, _ -> error("invalid right") })
        val success = goodStats.zip(goodStages) { s, r -> s.hp + r.attack.value }
        assertEquals(Validation.Valid(100), success)
        val rejectedBuild = goodStats.zip(goodStages) { s, _ -> s.copy(hp = 0) }
        assertEquals(listOf(range("hp")), assertIs<Validation.Invalid>(rejectedBuild).errors)
    }

    @Test
    fun `state reports range and consistency errors without losing independent fields`() {
        val p =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(200, 100, 100, 100, 100, 100),
            )
        val result =
            validate("defender") {
                p.copy(
                    currentHp = 201,
                    toxicCounter = ToxicCounter(1),
                    boostedStat = Stat.HP,
                )
            }
        assertEquals(
            listOf(
                ValidationError("defender.currentHp", ValidationCode.INCONSISTENT),
                ValidationError("defender.toxicCounter", ValidationCode.INCONSISTENT),
                ValidationError("defender.boostedStat", ValidationCode.INCONSISTENT),
            ),
            assertIs<Validation.Invalid>(result).errors,
        )
        for (hp in listOf(0, 1000)) {
            assertEquals(
                listOf(range("currentHp")),
                assertIs<Validation.Invalid>(validate { p.copy(currentHp = hp) }).errors,
            )
        }
        val toxic = validate { p.copy(status = Status.TOXIC) }
        assertEquals(
            listOf(ValidationError("toxicCounter", ValidationCode.INCONSISTENT)),
            assertIs<Validation.Invalid>(toxic).errors,
        )
    }

    @Test
    fun `move diagnostics collect power and priority while preserving fixed damage exceptions`() {
        for (power in listOf(-1, 0, 1001)) {
            val result =
                validate("move") {
                    Move(
                        MoveId("Tackle"),
                        PokemonType.NORMAL,
                        power,
                        Category.PHYSICAL,
                        priority = 6,
                    )
                }
            assertEquals(
                listOf(range("move.power"), range("move.priority")),
                assertIs<Validation.Invalid>(result).errors,
            )
        }
        assertIs<Validation.Valid<Move>>(
            validate { Move(MoveId("SeismicToss"), PokemonType.FIGHTING, 0, Category.PHYSICAL) },
        )
    }

    @Test
    fun `setup reports every invalid chip index and combines independent limits and hazards`() {
        val setup =
            validate("setup") {
                BattleSetup(
                    initialDamages =
                        listOf((-1).toBigInteger(), 0.toBigInteger(), (-2).toBigInteger()),
                )
            }
        assertEquals(
            listOf(range("setup.initialDamages[0]"), range("setup.initialDamages[2]")),
            assertIs<Validation.Invalid>(setup).errors,
        )
        val limits = validate("limits") { CalculationLimits(0, -1) }
        val hazards = validate("setup.entryHazards") { EntryHazards(spikes = Spikes.fromLayers(4)) }
        val result = limits.zip(hazards) { _, _ -> error("invalid inputs") }
        assertEquals(
            listOf(
                range("limits.maxOperations"),
                range("limits.maxStates"),
                range("setup.entryHazards.layers"),
            ),
            assertIs<Validation.Invalid>(result).errors,
        )
        val pokemon =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(100, 100, 100, 100, 100, 100),
            )
        val request =
            validate("request") {
                DamageRequest(
                    pokemon,
                    pokemon,
                    Move(MoveId("Tackle"), PokemonType.NORMAL, 40, Category.PHYSICAL),
                    hitIndex = -1,
                )
            }
        assertEquals(
            listOf(range("request.hitIndex")),
            assertIs<Validation.Invalid>(request).errors,
        )
    }

    @Test
    fun `scalar validation preserves required duplicate and range diagnostics`() {
        val ids =
            listOf(
                validate { AbilityId("") },
                validate { ItemId("") },
                validate { MoveId("") },
                validate { PokemonId("") },
            )
        for (id in ids) {
            assertEquals(
                listOf(ValidationError("value", ValidationCode.REQUIRED)),
                assertIs<Validation.Invalid>(id).errors,
            )
        }
        val types = validate { PokemonTypes(PokemonType.FIRE, PokemonType.FIRE) }
        assertEquals(
            listOf(ValidationError("types", ValidationCode.DUPLICATE)),
            assertIs<Validation.Invalid>(types).errors,
        )
        for (value in listOf(Double.NaN, Double.POSITIVE_INFINITY, 0.0, 1000.0, 0.15)) {
            assertEquals(
                listOf(range("weight.value")),
                assertIs<Validation.Invalid>(
                    validate("weight") { PokemonWeight.fromKilograms(value) },
                ).errors,
            )
        }
        assertEquals(
            listOf(range("value")),
            assertIs<Validation.Invalid>(validate { PokemonWeight(0) }).errors,
        )
        assertEquals(
            Validation.Valid(PokemonWeight(9999)),
            validate { PokemonWeight.fromKilograms(999.9) },
        )
    }

    @Test
    fun `enum parsing retains typed values and reports unknown spelling`() {
        for (type in PokemonType.entries) {
            assertEquals(
                Validation.Valid(type),
                validateEnum(type.name, PokemonType.entries),
            )
        }
        assertEquals(Validation.Valid(TeraType.STELLAR), validateEnum("STELLAR", TeraType.entries))
        assertEquals(Validation.Valid(Terrain.GRASS), validateEnum("GRASS", Terrain.entries))
        for (text in listOf("", "Normal", "STELLAR")) {
            assertEquals(
                listOf(ValidationError("value", ValidationCode.UNKNOWN_VALUE)),
                assertIs<Validation.Invalid>(validateEnum(text, PokemonType.entries)).errors,
            )
        }
    }

    @Test
    fun `result model checks can be inspected without throwing`() {
        val probability = validate { ExactProbability((-1).toBigInteger(), 0.toBigInteger()) }
        assertEquals(
            listOf(range("totalWeight"), range("weight")),
            assertIs<Validation.Invalid>(probability).errors,
        )
        val hit = HitResult(40, 100, 100, false, listOf(20), emptyList())
        val result = validate { DamageResult(hit, 0) }
        assertEquals(listOf(range("referenceHp")), assertIs<Validation.Invalid>(result).errors)
    }

    @Test
    fun `diagnostics are immutable nonempty snapshots and do not catch unrelated errors`() {
        val source = mutableListOf(range("hp"))
        val invalid = Validation.Invalid(source)
        source.clear()
        assertEquals(listOf(range("hp")), invalid.errors)
        assertFailsWith<UnsupportedOperationException> { (invalid.errors as MutableList).clear() }
        assertFailsWith<IllegalArgumentException> { Validation.Invalid(emptyList()) }
        val cause = IllegalArgumentException("unrelated input parser")
        assertSame(cause, assertFailsWith<IllegalArgumentException> { validate { throw cause } })
        assertFailsWith<IllegalStateException> {
            Validation.Valid(1).zip(Validation.Valid(2)) { _, _ -> error("bug") }
        }
    }
}
