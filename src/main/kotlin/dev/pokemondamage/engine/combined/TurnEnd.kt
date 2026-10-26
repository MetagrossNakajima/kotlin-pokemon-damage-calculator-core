package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.*
import dev.pokemondamage.rules.BattleEffects

/** Supported end-of-turn events in their battle order, with berry checks after each HP loss. */
internal class TurnEnd(private val defender: PokemonState, private val field: BattleField) {
    private val health = HealthEvents(defender, field)

    fun apply(state: BattleProgress, turn: Long): BattleProgress {
        var current = sand(state, turn)
        current = grass(current)
        current = leftovers(current)
        current = status(current, turn)
        return cudChew(current, turn)
    }

    private fun ability(state: BattleProgress) =
        BattleEffects.ability(defender, field, itemConsumed = state.itemConsumed)

    private fun item(state: BattleProgress) =
        BattleEffects.item(defender, field, itemConsumed = state.itemConsumed)

    private fun heal(state: BattleProgress, amount: Int) =
        state.copy(hp = minOf(defender.stats.hp, state.hp + amount))

    private fun sand(state: BattleProgress, turn: Long): BattleProgress {
        if (
            state.hp == 0 ||
                BattleEffects.weather(field, listOf(ability(state))) != Weather.SANDSTORM ||
                BattleEffects.currentTypes(defender).toList().any { it in sandTypes } ||
                ability(state) in sandAbilities ||
                item(state) == ItemId("SafetyGoggles")
        )
            return state
        return health.damage(state, maxOf(1, defender.stats.hp / 16).toBigInteger(), turn)
    }

    private fun grass(state: BattleProgress): BattleProgress {
        if (
            state.hp == 0 ||
                field.terrain != Terrain.GRASS ||
                !BattleEffects.isGrounded(defender, field, ability(state), item(state))
        )
            return state
        return heal(state, maxOf(1, defender.stats.hp / 16))
    }

    private fun leftovers(state: BattleProgress): BattleProgress {
        if (state.hp == 0 || state.hp == defender.stats.hp || item(state) != ItemId("Leftovers"))
            return state
        return heal(state, maxOf(1, defender.stats.hp / 16))
    }

    private fun status(state: BattleProgress, turn: Long): BattleProgress {
        val status = defender.status
        if (
            state.hp == 0 ||
                status !in damagingStatuses ||
                ability(state) == AbilityId("MagicGuard")
        )
            return state
        val ability = ability(state)
        val updated =
            if (status != Status.BURN && ability == AbilityId("PoisonHeal")) {
                heal(state, maxOf(1, defender.stats.hp / 8))
            } else {
                val damage =
                    when (status) {
                        Status.BURN ->
                            defender.stats.hp / if (ability == AbilityId("Heatproof")) 32 else 16
                        Status.POISON -> defender.stats.hp / 8
                        else -> defender.stats.hp * (state.toxicCounter ?: 1) / 16
                    }
                health.damage(state, maxOf(1, damage).toBigInteger(), turn)
            }
        return if (status == Status.TOXIC)
            updated.copy(toxicCounter = minOf(15, (updated.toxicCounter ?: 1) + 1))
        else updated
    }

    private fun cudChew(state: BattleProgress, turn: Long): BattleProgress {
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
        )
            return state
        return health.berry(state, turn, repeat = true)
    }

    private companion object {
        private val damagingStatuses = setOf(Status.BURN, Status.POISON, Status.TOXIC)
        private val sandTypes = setOf(PokemonType.ROCK, PokemonType.GROUND, PokemonType.STEEL)
        private val sandAbilities =
            setOf("SandVeil", "SandRush", "SandForce", "Overcoat", "MagicGuard")
                .map(::AbilityId)
                .toSet()
    }
}
