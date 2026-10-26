package dev.pokemondamage.engine.stats

import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.model.*

/** Already-active paradox abilities select the highest staged stat; ties use battle stat order. */
internal object ParadoxBoost {
    fun applies(pokemon: PokemonState, ability: AbilityId?, stat: Stat): Boolean {
        if (ability !in abilities) return false
        return (pokemon.boostedStat ?: highestStat(pokemon)) == stat
    }

    private fun highestStat(pokemon: PokemonState): Stat {
        val stats = pokemon.stats
        val stages = pokemon.stages
        return listOf(
                Stat.ATTACK to BattleMath.rankedStat(stats.attack, stages.attack),
                Stat.DEFENSE to BattleMath.rankedStat(stats.defense, stages.defense),
                Stat.SPECIAL_ATTACK to
                    BattleMath.rankedStat(stats.specialAttack, stages.specialAttack),
                Stat.SPECIAL_DEFENSE to
                    BattleMath.rankedStat(stats.specialDefense, stages.specialDefense),
                Stat.SPEED to BattleMath.rankedStat(stats.speed, stages.speed),
            )
            .maxBy { it.second }
            .first
    }

    private val abilities = setOf(AbilityId("QuarkDrive"), AbilityId("Protosynthesis"))
}
