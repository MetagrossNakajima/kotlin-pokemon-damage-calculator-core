package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.TeraType

/** テラスタル後も元のタイプによるタイプ一致補正を残す。 */
internal object Stab {
    fun calculate(context: DamageContext): Int {
        val attacker = context.attacker
        val type = context.move.type
        val tera = attacker.teraType
        // 元のタイプによるタイプ一致補正
        val original = type.pokemonType?.let { it in attacker.profile.types } == true
        val baseModifier = if (original) 6144 else 4096
        // へんげんじざい･リベロ
        val changesType = !original && tera == null && context.attackerAbility in changingAbilities
        val typeModifier = if (changesType) baseModifier + 2048 else baseModifier
        // テラスタイプ一致による追加補正
        val teraModifier =
            if (tera == type && tera != TeraType.STELLAR) {
                typeModifier + 2048
            } else {
                typeModifier
            }
        val currentType = if (tera == null || tera == TeraType.STELLAR) original else tera == type
        // てきおうりょく
        val adaptabilityModifier =
            if (context.attackerAbility == AbilityId("Adaptability") && currentType) {
                val originalTera = tera?.pokemonType?.let { it in attacker.profile.types } == true
                val bonus = if (originalTera) 1024 else 2048
                teraModifier + bonus
            } else {
                teraModifier
            }
        // ステラのタイプ強化（テラパゴスは使用回数を問わない）
        val stellarBoost =
            tera == TeraType.STELLAR &&
                (
                    attacker.flags[PokemonFlag.STELLAR_BOOST_AVAILABLE] != false ||
                        attacker.profile.id == PokemonId("Terapagos-Stellar")
                )
        return if (stellarBoost) {
            if (original) adaptabilityModifier + 2048 else 4915
        } else {
            adaptabilityModifier
        }
    }

    private val changingAbilities = setOf(AbilityId("Protean"), AbilityId("Libero"))
}
