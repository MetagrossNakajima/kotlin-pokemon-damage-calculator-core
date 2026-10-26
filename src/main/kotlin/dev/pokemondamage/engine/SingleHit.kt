package dev.pokemondamage.engine

import dev.pokemondamage.engine.damage.*
import dev.pokemondamage.engine.power.FinalPower
import dev.pokemondamage.engine.stats.AttackStat
import dev.pokemondamage.engine.stats.DefenseStat
import dev.pokemondamage.math.DamageRoll
import dev.pokemondamage.model.*

internal object SingleHit {
    fun calculate(context: DamageContext): HitResult {
        val critical = CriticalHit.applies(context)
        val power = FinalPower.calculate(context)
        val attack = AttackStat.calculate(context, critical)
        val defense = DefenseStat.calculate(context, critical)
        val base =
            PreRandomDamage.calculate(context, power.value, attack.value, defense.value, critical)
        val effectiveness = TypeEffectiveness.calculate(context)
        val modifier = DamageModifiers.calculate(context, critical, effectiveness)
        val stab = Stab.calculate(context)
        val burned =
            context.physical &&
                context.attacker.status == Status.BURN &&
                context.attackerAbility != AbilityId("Guts") &&
                context.move.original.id != MoveId("Facade")
        val rolls =
            (85..100).map {
                DamageRoll.calculateTraced(
                    base.value,
                    it,
                    effectiveness,
                    burned,
                    stab,
                    modifier.value,
                )
            }
        return HitResult(
            power.value,
            attack.value,
            defense.value,
            critical,
            rolls.map { it.value },
            power.trace +
                attack.trace +
                defense.trace +
                base.trace +
                modifier.trace +
                rolls.flatMap { it.trace },
        )
    }
}
