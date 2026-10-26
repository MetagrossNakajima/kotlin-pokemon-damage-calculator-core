package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.TypeEffectiveness
import dev.pokemondamage.model.*

internal object FixedDamage {
    fun calculate(context: DamageContext): HitResult {
        val move = context.move.original
        val id = move.id.value
        val hp = context.defender.hp
        val attackerHp = context.attacker.hp
        val immune =
            TypeEffectiveness.calculate(context) == 0.0 ||
                id == "SheerCold" && PokemonType.ICE in context.defenderTypes ||
                id in ohkoMoves && context.defenderAbility == AbilityId("Sturdy")
        val damage =
            when (id) {
                "SuperFang",
                "Ruination" -> maxOf(1, hp / 2)
                "NaturesMadness" -> hp / 2
                "GuardianofAlola" -> hp * 3 / 4
                "FinalGambit" -> attackerHp
                "Endeavor" -> maxOf(0, hp - attackerHp)
                "SonicBoom" -> 20
                "DragonRage" -> 40
                "SeismicToss",
                "NightShade" -> 50
                else -> hp
            }
        val physical = move.category == Category.PHYSICAL
        return HitResult(
            move.power,
            if (physical) context.attacker.stats.attack else context.attacker.stats.specialAttack,
            if (physical) context.defender.stats.defense else context.defender.stats.specialDefense,
            false,
            listOf(if (immune) 0 else damage),
            emptyList(),
            DamageKind.FIXED,
        )
    }

    private val ohkoMoves = setOf("Fissure", "SheerCold", "HornDrill", "Guillotine")
}
