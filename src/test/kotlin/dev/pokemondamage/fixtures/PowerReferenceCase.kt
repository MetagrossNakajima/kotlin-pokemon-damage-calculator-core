package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonFlags
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather

/** Literal expectations from the original power reference fixtures; never recomputed by the SUT. */
internal data class PowerReferenceCase(
    val name: String,
    val ability: AbilityId,
    val item: ItemId?,
    val move: Move,
    val effects: EnumFlags<FieldEffect>,
    val attackerStats: Stats,
    val defenderStats: Stats,
    val expectedMultiplier: Int,
    val expectedPower: Int,
    val expectedDamage: List<Int>,
    val expectedControlDamage: List<Int>,
) {
    fun request(): DamageRequest {
        val profile =
            PokemonProfile(
                PokemonId("Mew"),
                PokemonTypes(PokemonType.PSYCHIC),
                PokemonWeight(100),
            )
        return DamageRequest(
            PokemonState(
                profile,
                attackerStats,
                ability = ability,
                item = item,
                status = if (ability == AbilityId("ToxicBoost")) Status.POISON else Status.BURN,
            ),
            PokemonState(profile, defenderStats),
            move,
            BattleField(
                weather = if (ability == AbilityId("SandForce")) Weather.SANDSTORM else null,
                effects = effects,
            ),
        )
    }
}

internal data class TeraPowerReferenceCase(
    val name: String,
    val move: Move,
    val teraType: TeraType?,
    val boostAvailable: Boolean,
    val hp: Int,
    val ability: AbilityId,
    val expectedPower: Int,
) {
    fun request(): DamageRequest {
        val profile =
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100))
        val base = PokemonState(profile, Stats(200, 100, 100, 100, 100, 100))
        return DamageRequest(
            base.copy(
                ability = ability,
                teraType = teraType,
                currentHp = hp,
                flags = PokemonFlags(mapOf(PokemonFlag.STELLAR_BOOST_AVAILABLE to boostAvailable)),
            ),
            base,
            move,
        )
    }
}
