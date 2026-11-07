package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Status
import dev.pokemondamage.rules.MoveRules

internal object CriticalHit {
    fun applies(context: DamageContext): Boolean =
        (
            context.request.critical ||
                MoveRules.isGuaranteedCritical(context.move.original.id) ||
                (
                    // ひとでなし
                    context.attackerAbility == AbilityId("Merciless") &&
                        context.defender.status in poisonStatuses
                )
        ) &&
            context.defenderAbility !in preventingAbilities

    private val poisonStatuses = setOf(Status.POISON, Status.TOXIC)

    // カブトアーマー･シェルアーマー
    private val preventingAbilities = setOf(AbilityId("BattleArmor"), AbilityId("ShellArmor"))
}
