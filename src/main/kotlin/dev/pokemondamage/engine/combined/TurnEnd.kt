package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.ToxicCounter
import dev.pokemondamage.model.Weather
import dev.pokemondamage.rules.BattleEffects

/** Supported end-of-turn events in their battle order, with berry checks after each HP loss. */
internal class TurnEnd(
    private val defender: PokemonState,
    private val field: BattleField,
) {
    private val health = HealthEvents(defender, field)

    fun apply(
        state: BattleProgress,
        turn: Long,
    ): BattleProgress {
        val afterSand = sand(state, turn)
        val afterGrass = grass(afterSand)
        val afterLeftovers = leftovers(afterGrass)
        val afterStatus = status(afterLeftovers, turn)
        return cudChew(afterStatus, turn)
    }

    private fun ability(state: BattleProgress) =
        BattleEffects.ability(defender, field, itemConsumed = state.itemConsumed)

    private fun item(state: BattleProgress) =
        BattleEffects.item(defender, field, itemConsumed = state.itemConsumed)

    private fun heal(
        state: BattleProgress,
        amount: Int,
    ) = state.copy(hp = minOf(defender.stats.hp, state.hp + amount))

    private fun sand(
        state: BattleProgress,
        turn: Long,
    ): BattleProgress {
        val ability = ability(state)
        if (
            state.hp == 0 ||
            BattleEffects.weather(field, listOf(ability)) != Weather.SANDSTORM ||
            BattleEffects.currentTypes(defender).toList().any { it in sandTypes } ||
            ability in sandAbilities ||
            item(state) == ItemId("SafetyGoggles")
        ) {
            return state
        }
        return health.damage(state, maxOf(1, defender.stats.hp / 16).toBigInteger(), turn)
    }

    private fun grass(state: BattleProgress): BattleProgress {
        if (
            state.hp == 0 ||
            field.terrain != Terrain.GRASS ||
            !BattleEffects.isGrounded(defender, field, ability(state), item(state))
        ) {
            return state
        }
        return heal(state, maxOf(1, defender.stats.hp / 16))
    }

    private fun leftovers(state: BattleProgress): BattleProgress {
        if (state.hp == 0 || state.hp == defender.stats.hp || item(state) != ItemId("Leftovers")) {
            return state
        }
        return heal(state, maxOf(1, defender.stats.hp / 16))
    }

    private fun status(
        state: BattleProgress,
        turn: Long,
    ): BattleProgress {
        val ability = ability(state)
        if (state.hp == 0 || ability == AbilityId("MagicGuard")) {
            return state
        }
        val status = defender.status
        val damage =
            when (status) {
                Status.BURN -> {
                    val divisor = if (ability == AbilityId("Heatproof")) 32 else 16
                    defender.stats.hp / divisor
                }

                Status.POISON -> {
                    defender.stats.hp / 8
                }

                Status.TOXIC -> {
                    defender.stats.hp * (state.toxicCounter ?: ToxicCounter.INITIAL).value /
                        16
                }

                else -> {
                    return state
                }
            }
        val poisoned = status == Status.POISON || status == Status.TOXIC
        val updated =
            if (poisoned && ability == AbilityId("PoisonHeal")) {
                heal(state, maxOf(1, defender.stats.hp / 8))
            } else {
                health.damage(state, maxOf(1, damage).toBigInteger(), turn)
            }
        if (status == Status.TOXIC) {
            val nextCounter = (updated.toxicCounter ?: ToxicCounter.INITIAL).next()
            return updated.copy(toxicCounter = nextCounter)
        }
        return updated
    }

    private fun cudChew(
        state: BattleProgress,
        turn: Long,
    ): BattleProgress {
        if (
            state.hp == 0 ||
            state.cudChewTurn != turn ||
            BattleEffects.ability(defender, field) != AbilityId("CudChew") ||
            BattleEffects.item(
                defender,
                field,
                itemConsumed = state.itemConsumed,
                ignoreConsumption = true,
            ) != ItemId("SitrusBerry") ||
            FieldEffect.UNNERVE in field.effects
        ) {
            return state
        }
        return health.berry(state, turn, repeat = true)
    }

    private companion object {
        private val sandTypes = setOf(PokemonType.ROCK, PokemonType.GROUND, PokemonType.STEEL)
        private val sandAbilities =
            setOf("SandVeil", "SandRush", "SandForce", "Overcoat", "MagicGuard")
                .map(::AbilityId)
                .toSet()
    }
}
