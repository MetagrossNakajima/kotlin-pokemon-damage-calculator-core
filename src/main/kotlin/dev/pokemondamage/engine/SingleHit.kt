package dev.pokemondamage.engine

import dev.pokemondamage.engine.damage.CriticalHit
import dev.pokemondamage.engine.damage.DamageModifiers
import dev.pokemondamage.engine.damage.PreRandomDamage
import dev.pokemondamage.engine.damage.Stab
import dev.pokemondamage.engine.power.FinalPower
import dev.pokemondamage.engine.stats.AttackStat
import dev.pokemondamage.engine.stats.DefenseStat
import dev.pokemondamage.math.DamageRoll
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.HitResult
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.Status

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
        // やけど補正（こんじょう･からげんきは対象外）
        val burned =
            context.physical &&
                context.attacker.status == Status.BURN &&
                context.attackerAbility != AbilityId("Guts") &&
                context.move.original.id != MoveId("Facade")
        // 85〜100の16通りの乱数を計算
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
