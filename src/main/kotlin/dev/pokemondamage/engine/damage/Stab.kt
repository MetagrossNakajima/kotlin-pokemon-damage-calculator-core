package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.*

/** Same-type attack bonus retains original types after Terastallization. */
internal object Stab {
    fun calculate(context: DamageContext): Int {
        val attacker = context.attacker
        val type = context.move.type
        val tera = attacker.teraType
        val original = type.pokemonType?.let { it in attacker.profile.types } == true
        var modifier = if (original) 6144 else 4096
        if (!original && tera == null && context.attackerAbility in changingAbilities)
            modifier += 2048
        if (tera == type && tera != TeraType.STELLAR) modifier += 2048
        val currentType = if (tera == null || tera == TeraType.STELLAR) original else tera == type
        if (context.attackerAbility == AbilityId("Adaptability") && currentType) {
            modifier +=
                if (tera?.pokemonType?.let { it in attacker.profile.types } == true) 1024 else 2048
        }
        if (
            tera == TeraType.STELLAR &&
                (attacker.flags[PokemonFlag.STELLAR_BOOST_AVAILABLE] != false ||
                    attacker.profile.id == PokemonId("Terapagos-Stellar"))
        ) {
            modifier = if (original) modifier + 2048 else 4915
        }
        return modifier
    }

    private val changingAbilities = setOf(AbilityId("Protean"), AbilityId("Libero"))
}
