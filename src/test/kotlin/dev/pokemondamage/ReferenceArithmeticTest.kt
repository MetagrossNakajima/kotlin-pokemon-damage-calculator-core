package dev.pokemondamage

import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.math.DamageRoll
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.rules.TypeChart
import kotlin.test.Test
import kotlin.test.assertEquals

class ReferenceArithmeticTest {
    private fun rows(file: String): List<List<String>> =
        checkNotNull(javaClass.getResourceAsStream("/reference/$file"))
            .bufferedReader()
            .useLines { lines ->
                lines.filterNot { it.startsWith('#') }.map { it.split('\t') }.toList()
            }

    @Test
    fun `all 324 type matchups agree with Reference generation nine`() {
        val cases = rows("types.tsv")
        assertEquals(324, cases.size)
        assertEquals(324, cases.map { it.take(2) }.toSet().size)
        for ((attack, defense, expected) in cases) {
            assertEquals(
                expected.toDouble(),
                TypeChart.effectiveness(
                    PokemonType.valueOf(attack),
                    PokemonType.valueOf(defense),
                ),
                "$attack against $defense",
            )
        }
    }

    @Test
    fun `base damage agrees with Reference including overflow`() {
        val cases = rows("base-damage.tsv")
        assertEquals(150, cases.size)
        for (row in cases) {
            val (power, attack, defense, expected) = row.map(String::toInt)
            assertEquals(expected, BattleMath.baseDamage(power, attack, defense), row.toString())
        }
    }

    @Test
    fun `all final damage rolls agree with Reference`() {
        val cases = rows("damage-rolls.tsv")
        assertEquals(22400, cases.size)
        for (row in cases) {
            assertEquals(
                row[6].toInt(),
                DamageRoll.calculate(
                    baseDamage = row[0].toInt(),
                    randomPercent = row[1].toInt(),
                    effectiveness = row[2].toDouble(),
                    burned = row[3].toBooleanStrict(),
                    stab = row[4].toInt(),
                    finalModifier = row[5].toInt(),
                ),
                row.toString(),
            )
        }
    }

    @Test
    fun `immunity remains zero despite minimum damage rule`() {
        assertEquals(0, DamageRoll.calculate(46, 100, 0.0, false, 6144, 4096))
    }
}
