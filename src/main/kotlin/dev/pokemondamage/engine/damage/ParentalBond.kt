package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.*
import dev.pokemondamage.rules.MoveRules

internal object ParentalBond {
    fun applies(context: DamageContext): Boolean =
        context.attackerAbility == AbilityId("ParentalBond") &&
            !MoveRules.isNaturalMultiHit(context.move.original.id) &&
            !(context.field.format == BattleFormat.DOUBLE && context.move.original.spread)
}
