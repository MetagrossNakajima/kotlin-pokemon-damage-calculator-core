package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.stats.AttackStat
import dev.pokemondamage.engine.stats.DefenseStat
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
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
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.Weather
import dev.pokemondamage.model.zip
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ReferenceStatTest {
    private fun stats(text: String): Stats =
        text.split(',').map(String::toInt).let { Stats(it[0], it[1], it[2], it[3], it[4], it[5]) }

    private fun stages(text: String): StatStages =
        text
            .split(
                ',',
            ).map(String::toInt)
            .let { StatStages.fromValues(it[0], it[1], it[2], it[3], it[4]) }

    @Test
    fun `attack and defense stages agree with Reference under explicit active conditions`() {
        val lines =
            checkNotNull(javaClass.getResourceAsStream("/reference/stats.tsv"))
                .bufferedReader()
                .useLines { lines -> lines.filterNot { it.startsWith('#') }.toList() }
        val columns = lines.first().split('\t')
        val cases = lines.drop(1).map { columns.zip(it.split('\t')).toMap() }
        assertEquals(1122, cases.size)
        assertEquals(cases.size, cases.map { it.getValue("id") }.toSet().size)
        val differences = mutableListOf<String>()
        for (r in cases) {
            fun value(key: String) = r.getValue(key)

            fun optional(key: String) = value(key).takeUnless { it == "-" }

            fun pokemon(role: String) =
                PokemonState(
                    PokemonProfile(
                        PokemonId(value("${role}Id")),
                        value("${role}Types").split(',').map(PokemonType::valueOf).let {
                            PokemonTypes(it[0], it.getOrNull(1))
                        },
                        PokemonWeight(40),
                    ),
                    stats(value("${role}Stats")),
                    stages(value("${role}Stages")),
                    ability = AbilityId(value("${role}Ability")),
                    item = optional("${role}Item")?.let(::ItemId),
                    status = Status.BURN,
                    currentHp = 40,
                    boostedStat = optional("${role}Boost")?.let(Stat::valueOf),
                    flags =
                        if (role == "d") {
                            PokemonFlags(
                                mapOf(
                                    PokemonFlag.CAN_EVOLVE to value("canEvolve").toBooleanStrict(),
                                ),
                            )
                        } else {
                            PokemonFlags()
                        },
                )
            val effects = optional("effects")?.split(',')?.map(FieldEffect::valueOf).orEmpty()
            val context =
                DamageContext(
                    DamageRequest(
                        pokemon("a"),
                        pokemon("d"),
                        Move(
                            MoveId(value("move")),
                            PokemonType.valueOf(value("type")),
                            value("power").toInt(),
                            Category.valueOf(value("category")),
                            flags =
                                if (value("contact").toBooleanStrict()) {
                                    EnumFlags(MoveFlag.CONTACT)
                                } else {
                                    EnumFlags()
                                },
                        ),
                        BattleField(
                            weather = optional("weather")?.let(Weather::valueOf),
                            terrain = optional("terrain")?.let(Terrain::valueOf),
                            effects = EnumFlags(*effects.toTypedArray()),
                        ),
                        critical = value("critical").toBooleanStrict(),
                    ),
                )
            val critical = value("critical").toBooleanStrict()
            val attack = AttackStat.calculate(context, critical).value
            val defense = DefenseStat.calculate(context, critical).value
            if (attack != value("attack").toInt()) {
                differences += "${value("id")} attack expected=${value("attack")} actual=$attack"
            }
            if (defense != value("defense").toInt()) {
                differences += "${value("id")} defense expected=${value("defense")} actual=$defense"
            }
            val full =
                assertIs<Calculation.Success<DamageResult>>(calculateDamage(context.request)).value
            val encoded =
                value("damage")
                    .removePrefix("[")
                    .removeSuffix("]")
                    .split(',')
                    .map(String::toInt)
            val expected = if (encoded.size == 1) List(16) { encoded.single() } else encoded
            if (full.hit.rolls != expected) {
                differences += "${value("id")} damage expected=$expected actual=${full.hit.rolls}"
            }
        }
        assertEquals(emptyList(), differences)
    }
}
