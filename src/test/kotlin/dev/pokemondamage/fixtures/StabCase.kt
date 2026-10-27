package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.TeraType

// Values preserved from the existing STAB reference fixture; its original header did not
// record a generator/version.
internal data class StabCase(
    val species: PokemonId,
    val originalTypes: PokemonTypes,
    val moveType: TeraType,
    val teraType: TeraType?,
    val ability: AbilityId,
    val stellarAvailable: Boolean,
    val expectedModifier: Int,
)

internal fun stabCases(): List<StabCase> =
    buildList {
        addAll(stabMewPart1())
        addAll(stabMewPart2())
        addAll(stabMewPart3())
        addAll(stabMewPart4())
        addAll(stabMewPart5())
        addAll(stabMewPart6())
        addAll(stabMewPart7())
        addAll(stabMewPart8())
        addAll(stabTerapagosStellarPart1())
        addAll(stabTerapagosStellarPart2())
        addAll(stabTerapagosStellarPart3())
        addAll(stabTerapagosStellarPart4())
        addAll(stabTerapagosStellarPart5())
        addAll(stabTerapagosStellarPart6())
        addAll(stabTerapagosStellarPart7())
        addAll(stabTerapagosStellarPart8())
        addAll(stabTerapagosStellarPart9())
        addAll(stabTerapagosStellarPart10())
    }
