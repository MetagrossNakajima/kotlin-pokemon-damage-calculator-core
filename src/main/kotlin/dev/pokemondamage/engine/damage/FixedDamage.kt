package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.TypeEffectiveness
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageKind
import dev.pokemondamage.model.HitResult
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.rules.FixedDamageKind

internal object FixedDamage {
    fun calculate(
        context: DamageContext,
        kind: FixedDamageKind,
    ): HitResult {
        val move = context.move.original
        val id = move.id.value
        val hp = context.defender.hp
        val attackerHp = context.attacker.hp
        val immune =
            TypeEffectiveness.calculate(context) == 0.0 ||
                (id == "SheerCold" && PokemonType.ICE in context.defenderTypes) ||
                (
                    kind == FixedDamageKind.ONE_HIT_KO &&
                        context.defenderAbility == AbilityId("Sturdy")
                )
        val damage =
            when (kind) {
                FixedDamageKind.HALF_CURRENT_HP -> maxOf(1, hp / 2)
                FixedDamageKind.THREE_QUARTERS_CURRENT_HP -> hp * 3 / 4
                FixedDamageKind.ATTACKER_HP -> attackerHp
                FixedDamageKind.HP_DIFFERENCE -> maxOf(0, hp - attackerHp)
                FixedDamageKind.TWENTY -> 20
                FixedDamageKind.FORTY -> 40
                FixedDamageKind.LEVEL -> 50
                FixedDamageKind.ONE_HIT_KO -> hp
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
}
