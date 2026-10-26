package dev.pokemondamage.engine.stats

import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.Stat

/** 発動済みのこだいかっせい・クォークチャージはランク込みの最高能力を選ぶ。同値なら能力順で優先する。 */
internal object ParadoxBoost {
    // こだいかっせい･クォークチャージ
    fun applies(
        pokemon: PokemonState,
        ability: AbilityId?,
        stat: Stat,
    ): Boolean {
        if (ability !in abilities) {
            return false
        }
        return (pokemon.boostedStat ?: highestStat(pokemon)) == stat
    }

    private fun highestStat(pokemon: PokemonState): Stat {
        val stats = pokemon.stats
        val stages = pokemon.stages
        // ランク込みの最高能力を選び、同値なら攻撃→防御→特攻→特防→素早さを優先
        return listOf(
            Stat.ATTACK to BattleMath.rankedStat(stats.attack, stages.attack),
            Stat.DEFENSE to BattleMath.rankedStat(stats.defense, stages.defense),
            Stat.SPECIAL_ATTACK to
                BattleMath.rankedStat(stats.specialAttack, stages.specialAttack),
            Stat.SPECIAL_DEFENSE to
                BattleMath.rankedStat(stats.specialDefense, stages.specialDefense),
            Stat.SPEED to BattleMath.rankedStat(stats.speed, stages.speed),
        ).maxBy { it.second }
            .first
    }

    private val abilities = setOf(AbilityId("QuarkDrive"), AbilityId("Protosynthesis"))
}
