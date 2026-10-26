package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ReferenceStatAbilityPairsTest {
    @TestFactory
    fun `each stat ability matches native damage and has an activating control pair`():
        List<org.junit.jupiter.api.DynamicTest> {
        val lines =
            javaClass
                .getResourceAsStream("/reference/stats.tsv")!!
                .bufferedReader()
                .readLines()
                .filterNot { it.startsWith('#') }
        val columns = lines.first().split('\t')
        val groups =
            lines
                .drop(1)
                .map { columns.zip(it.split('\t')).toMap() }
                .filter { it.getValue("controlRole") != "-" }
                .groupBy { "AbilityId/${it.getValue(it.getValue("controlRole") + "Ability")}" }
        assertEquals(35, groups.size)
        return groups.map { (effect, rows) ->
            dynamicTest(effect) {
                var activatingPairs = 0
                for (r in rows) {
                    fun value(key: String) = r.getValue(key)
                    fun optional(key: String) = value(key).takeUnless { it == "-" }
                    fun pokemon(role: String): PokemonState {
                        val stats = value("${role}Stats").split(',').map(String::toInt)
                        val stages = value("${role}Stages").split(',').map(String::toInt)
                        val types = value("${role}Types").split(',').map(PokemonType::valueOf)
                        return PokemonState(
                            PokemonProfile(
                                PokemonId(value("${role}Id")),
                                PokemonTypes(types[0], types.getOrNull(1)),
                                PokemonWeight(40),
                            ),
                            Stats(stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]),
                            StatStages(stages[0], stages[1], stages[2], stages[3], stages[4]),
                            ability = AbilityId(value("${role}Ability")),
                            item = optional("${role}Item")?.let(::ItemId),
                            status = Status.BURN,
                            currentHp = 40,
                            boostedStat = optional("${role}Boost")?.let(Stat::valueOf),
                            flags =
                                if (role == "d")
                                    PokemonFlags(
                                        mapOf(
                                            PokemonFlag.CAN_EVOLVE to
                                                value("canEvolve").toBooleanStrict(),
                                        ),
                                    )
                                else PokemonFlags(),
                        )
                    }
                    val effects =
                        optional("effects")?.split(',')?.map(FieldEffect::valueOf).orEmpty()
                    val request =
                        DamageRequest(
                            pokemon("a"),
                            pokemon("d"),
                            Move(
                                MoveId(value("move")),
                                PokemonType.valueOf(value("type")),
                                value("power").toInt(),
                                Category.valueOf(value("category")),
                                flags =
                                    if (value("contact").toBooleanStrict())
                                        EnumFlags(MoveFlag.CONTACT)
                                    else EnumFlags(),
                            ),
                            BattleField(
                                weather = optional("weather")?.let(Weather::valueOf),
                                terrain = optional("terrain")?.let(Terrain::valueOf),
                                effects = EnumFlags(*effects.toTypedArray()),
                            ),
                            critical = value("critical").toBooleanStrict(),
                        )
                    val control =
                        if (value("controlRole") == "a")
                            request.copy(
                                attacker =
                                    request.attacker.copy(
                                        ability = AbilityId("Illuminate"),
                                        boostedStat = null,
                                    ),
                            )
                        else
                            request.copy(
                                defender =
                                    request.defender.copy(
                                        ability = AbilityId("Illuminate"),
                                        boostedStat = null,
                                    ),
                            )
                    fun calculate(input: DamageRequest) =
                        assertIs<Calculation.Success<DamageResult>>(calculateDamage(input))
                            .value
                            .hit
                            .rolls
                    fun expected(key: String): List<Int> {
                        val encoded =
                            value(key)
                                .removePrefix("[")
                                .removeSuffix("]")
                                .split(',')
                                .map(String::toInt)
                        return if (encoded.size == 1) List(16) { encoded.single() } else encoded
                    }
                    val active = calculate(request)
                    val inactive = calculate(control)
                    assertEquals(expected("damage"), active, "${value("id")} active")
                    assertEquals(expected("controlDamage"), inactive, "${value("id")} control")
                    if (active != inactive) activatingPairs++
                }
                assertTrue(
                    activatingPairs > 0,
                    "$effect must change damage in at least one tested activation condition",
                )
            }
        }
    }
}
