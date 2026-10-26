package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.BattleSetup
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.Spikes
import dev.pokemondamage.rules.BattleEffects
import dev.pokemondamage.rules.TypeChart
import java.math.BigInteger

/** HP events resolve berry consumption immediately, never reviving a fainted branch. */
internal class HealthEvents(
    private val defender: PokemonState,
    private val field: BattleField,
) {
    fun damage(
        state: BattleProgress,
        amount: BigInteger,
        turn: Long,
        attackDamage: Boolean = false,
    ): BattleProgress {
        if (state.hp == 0) {
            return state
        }
        val lost = amount.min(state.hp.toBigInteger()).toInt()
        val accumulatedDamage =
            if (attackDamage) {
                state.attackDamage + amount
            } else {
                state.attackDamage
            }
        val damaged =
            state.copy(
                hp = state.hp - lost,
                attackDamage = accumulatedDamage,
            )
        if (
            lost == 0 ||
            damaged.hp == 0 ||
            damaged.hp > defender.stats.hp / 2 ||
            BattleEffects.item(defender, field, itemConsumed = state.itemConsumed) !=
            ItemId("SitrusBerry") ||
            FieldEffect.UNNERVE in field.effects
        ) {
            return damaged
        }
        return berry(damaged, turn, repeat = false)
    }

    fun berry(
        state: BattleProgress,
        turn: Long,
        repeat: Boolean,
    ): BattleProgress {
        val ability = BattleEffects.ability(defender, field, itemConsumed = state.itemConsumed)
        val baseHealing = maxOf(1, defender.stats.hp / 4)
        val healing = if (ability == AbilityId("Ripen")) baseHealing * 2 else baseHealing
        val afterBerry = minOf(defender.stats.hp, state.hp + healing)
        val hp =
            if (ability == AbilityId("CheekPouch")) {
                minOf(defender.stats.hp, afterBerry + maxOf(1, defender.stats.hp / 3))
            } else {
                afterBerry
            }
        val nextCudChewTurn =
            when {
                repeat -> null
                ability == AbilityId("CudChew") -> turn + 1
                else -> state.cudChewTurn
            }
        return state.copy(
            hp = hp,
            itemConsumed = true,
            cudChewTurn = nextCudChewTurn,
        )
    }

    /** Stealth Rock, Spikes, then explicit chip events, checking berries between events. */
    fun setup(
        state: BattleProgress,
        setup: BattleSetup,
    ): BattleProgress {
        val ability = BattleEffects.ability(defender, field)
        val item = BattleEffects.item(defender, field)
        val protected = item == ItemId("Heavy-DutyBoots") || ability == AbilityId("MagicGuard")
        val afterStealthRock =
            if (setup.entryHazards.stealthRock && !protected) {
                val factor =
                    BattleEffects.currentTypes(defender).toList().fold(1.0) { factor, type ->
                        factor * TypeChart.effectiveness(PokemonType.ROCK, type)
                    }
                damage(
                    state,
                    maxOf(1, (defender.stats.hp * factor / 8).toInt()).toBigInteger(),
                    0,
                )
            } else {
                state
            }
        val spikesDenominator = setup.entryHazards.spikes.damageDenominator
        val afterSpikes =
            if (
                !protected &&
                spikesDenominator != null &&
                BattleEffects.isGrounded(defender, field, ability, item)
            ) {
                damage(
                    afterStealthRock,
                    maxOf(1, defender.stats.hp / spikesDenominator).toBigInteger(),
                    0,
                )
            } else {
                afterStealthRock
            }
        return setup.initialDamages.fold(afterSpikes) { current, amount ->
            damage(current, amount, 0)
        }
    }
}
