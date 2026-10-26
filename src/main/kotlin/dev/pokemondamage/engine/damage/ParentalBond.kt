package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleFormat
import dev.pokemondamage.rules.MoveRules

internal object ParentalBond {
    // おやこあい
    fun applies(context: DamageContext): Boolean =
        context.attackerAbility == AbilityId("ParentalBond") &&
            !MoveRules.isNaturalMultiHit(context.move.original.id) &&
            !(context.field.format == BattleFormat.DOUBLE && context.move.original.spread)
}
