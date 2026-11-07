package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonFlags
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status

/** Reference calculator 0.12.0, generation 9; explicit active ability conditions. */
internal data class StatReferenceCase(
    val name: String,
    val attacker: StatReferencePokemon,
    val defender: StatReferencePokemon,
    val move: Move,
    val field: BattleField,
    val critical: Boolean,
    val expectedAttack: Int,
    val expectedDefense: Int,
    val expectedDamage: List<Int>,
    val controlRole: StatControlRole?,
    val expectedControlDamage: List<Int>?,
) {
    fun request(): DamageRequest =
        DamageRequest(
            attacker.state(),
            defender.state(),
            move,
            field,
            critical = critical,
        )

    val controlAbility: AbilityId?
        get() =
            when (controlRole) {
                StatControlRole.ATTACKER -> attacker.ability
                StatControlRole.DEFENDER -> defender.ability
                null -> null
            }
}

internal enum class StatControlRole { ATTACKER, DEFENDER }

internal data class StatReferencePokemon(
    val id: PokemonId,
    val types: PokemonTypes,
    val stats: Stats,
    val stages: StatStages,
    val ability: AbilityId,
    val item: ItemId?,
    val boostedStat: Stat?,
    val canEvolve: Boolean,
) {
    fun state(): PokemonState =
        PokemonState(
            PokemonProfile(id, types, PokemonWeight(40)),
            stats,
            stages,
            ability = ability,
            item = item,
            status = Status.BURN,
            currentHp = 40,
            boostedStat = boostedStat,
            flags = PokemonFlags(mapOf(PokemonFlag.CAN_EVOLVE to canEvolve)),
        )
}
