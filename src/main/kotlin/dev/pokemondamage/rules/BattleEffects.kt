package dev.pokemondamage.rules

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.Weather

/** Resolves persistent battle conditions, independently of a particular damage formula. */
internal object BattleEffects {
    private val abilityShield = ItemId("AbilityShield")
    private val neutralizingGas = AbilityId("NeutralizingGas")
    private val klutz = AbilityId("Klutz")
    private val ironBall = ItemId("IronBall")
    private val airBalloon = ItemId("AirBalloon")
    private val levitation = setOf(AbilityId("Levitate"), AbilityId("Eelevate"))
    private val weatherSuppressors = setOf(AbilityId("CloudNine"), AbilityId("AirLock"))

    fun ability(
        pokemon: PokemonState,
        field: BattleField,
        opponent: PokemonState? = null,
        itemConsumed: Boolean = pokemon.itemConsumed,
    ): AbilityId? {
        // The shield protects even an explicitly suppressed ability. Klutz does not disable this
        // protection.
        val shielded =
            pokemon.item == abilityShield &&
                !itemConsumed &&
                pokemon.flags[PokemonFlag.ITEM_SUPPRESSED] != true &&
                FieldEffect.MAGIC_ROOM !in field.effects
        if (shielded) {
            return pokemon.ability
        }
        if (pokemon.flags[PokemonFlag.ABILITY_SUPPRESSED] == true) {
            return null
        }
        if (
            pokemon.ability != neutralizingGas &&
            (
                FieldEffect.NEUTRALIZING_GAS in field.effects ||
                    (
                        opponent?.ability == neutralizingGas &&
                            opponent.flags[PokemonFlag.ABILITY_SUPPRESSED] != true
                    )
            )
        ) {
            return null
        }
        return pokemon.ability
    }

    fun item(
        pokemon: PokemonState,
        field: BattleField,
        opponent: PokemonState? = null,
        itemConsumed: Boolean = pokemon.itemConsumed,
        ignoreConsumption: Boolean = false,
    ): ItemId? {
        if (
            (!ignoreConsumption && itemConsumed) ||
            pokemon.flags[PokemonFlag.ITEM_SUPPRESSED] == true ||
            FieldEffect.MAGIC_ROOM in field.effects ||
            ability(pokemon, field, opponent, itemConsumed) == klutz
        ) {
            return null
        }
        return pokemon.item
    }

    fun currentTypes(pokemon: PokemonState): PokemonTypes =
        pokemon.teraType?.pokemonType?.let(::PokemonTypes) ?: pokemon.profile.types

    fun isGrounded(
        pokemon: PokemonState,
        field: BattleField,
        ability: AbilityId?,
        item: ItemId?,
    ): Boolean {
        if (field.gravity || item == ironBall) {
            return true
        }
        pokemon.flags[PokemonFlag.GROUNDED]?.let {
            return it
        }
        return PokemonType.FLYING !in currentTypes(pokemon) &&
            ability !in levitation &&
            item != airBalloon
    }

    fun weatherSuppressed(abilities: Iterable<AbilityId?>): Boolean =
        abilities.any {
            it in weatherSuppressors
        }

    fun weather(
        field: BattleField,
        abilities: Iterable<AbilityId?>,
    ): Weather? = if (weatherSuppressed(abilities)) null else field.weather

    /** Every halving floors independently, with a minimum weight of 0.1 kg. */
    fun weightHectograms(
        pokemon: PokemonState,
        ability: AbilityId?,
        item: ItemId?,
    ): Int {
        val originalWeight = pokemon.profile.weight.hectograms
        val abilityWeight =
            when (ability) {
                AbilityId("HeavyMetal") -> originalWeight * 2
                AbilityId("LightMetal") -> maxOf(1, originalWeight / 2)
                else -> originalWeight
            }
        return if (item == ItemId("FloatStone")) maxOf(1, abilityWeight / 2) else abilityWeight
    }
}
