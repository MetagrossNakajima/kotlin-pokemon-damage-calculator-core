package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.*
import dev.pokemondamage.rules.BattleEffects
import dev.pokemondamage.rules.TypeChart
import java.math.BigInteger

/** HP events resolve berry consumption immediately, never reviving a fainted branch. */
internal class HealthEvents(private val defender: PokemonState, private val field: BattleField) {
    fun damage(
        state: BattleProgress,
        amount: BigInteger,
        turn: Long,
        attackDamage: Boolean = false,
    ): BattleProgress {
        if (state.hp == 0) return state
        val lost = amount.min(state.hp.toBigInteger()).toInt()
        val damaged =
            state.copy(
                hp = state.hp - lost,
                attackDamage =
                    if (attackDamage) state.attackDamage + amount else state.attackDamage,
            )
        if (
            lost == 0 ||
                damaged.hp == 0 ||
                damaged.hp > defender.stats.hp / 2 ||
                BattleEffects.item(defender, field, itemConsumed = state.itemConsumed) !=
                    ItemId("SitrusBerry") ||
                FieldEffect.UNNERVE in field.effects
        )
            return damaged
        return berry(damaged, turn, repeat = false)
    }

    fun berry(state: BattleProgress, turn: Long, repeat: Boolean): BattleProgress {
        val ability = BattleEffects.ability(defender, field, itemConsumed = state.itemConsumed)
        var healing = maxOf(1, defender.stats.hp / 4)
        if (ability == AbilityId("Ripen")) healing *= 2
        var hp = minOf(defender.stats.hp, state.hp + healing)
        if (ability == AbilityId("CheekPouch"))
            hp = minOf(defender.stats.hp, hp + maxOf(1, defender.stats.hp / 3))
        return state.copy(
            hp = hp,
            itemConsumed = true,
            cudChewTurn =
                if (repeat) null
                else if (ability == AbilityId("CudChew")) turn + 1 else state.cudChewTurn,
        )
    }

    /** Stealth Rock, Spikes, then explicit chip events, checking berries between events. */
    fun setup(state: BattleProgress, setup: BattleSetup): BattleProgress {
        val ability = BattleEffects.ability(defender, field)
        val item = BattleEffects.item(defender, field)
        val protected = item == ItemId("Heavy-DutyBoots") || ability == AbilityId("MagicGuard")
        var current = state
        if (setup.entryHazards.stealthRock && !protected) {
            val factor =
                BattleEffects.currentTypes(defender).toList().fold(1.0) { factor, type ->
                    factor * TypeChart.effectiveness(PokemonType.ROCK, type)
                }
            current =
                damage(
                    current,
                    maxOf(1, (defender.stats.hp * factor / 8).toInt()).toBigInteger(),
                    0,
                )
        }
        if (
            !protected &&
                setup.entryHazards.spikesLayers > 0 &&
                BattleEffects.isGrounded(defender, field, ability, item)
        ) {
            val denominator =
                when (setup.entryHazards.spikesLayers) {
                    1 -> 8
                    2 -> 6
                    else -> 4
                }
            current = damage(current, maxOf(1, defender.stats.hp / denominator).toBigInteger(), 0)
        }
        for (amount in setup.initialDamages) current = damage(current, amount, 0)
        return current
    }
}
