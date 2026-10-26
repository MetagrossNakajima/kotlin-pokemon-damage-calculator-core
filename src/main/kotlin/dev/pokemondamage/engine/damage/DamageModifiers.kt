package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.ModifierChain
import dev.pokemondamage.math.TracedValue
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.rules.ItemRules

/** 最終補正をバトルの順序で連結し、乱数ごとのダメージに適用する。 */
internal object DamageModifiers {
    fun calculate(
        context: DamageContext,
        critical: Boolean,
        effectiveness: Double,
    ): TracedValue {
        val ability = context.attackerAbility?.value.orEmpty()
        val defenderAbility = context.defenderAbility?.value.orEmpty()
        val item = context.attackerItem?.value.orEmpty()
        val firstHit = context.request.hitIndex == 0L
        val type = context.move.type
        val screens = context.defender.sideConditions
        val screened = if (context.physical) screens.reflect else screens.lightScreen
        return ModifierChain("damage", ModifierStage.DAMAGE_MODIFIER)
            .apply {
                // リフレクター･ひかりのかべ
                add(
                    "Screen",
                    context.field.format.screenModifier,
                    !critical &&
                        ability != "Infiltrator" &&
                        context.move.original.id.value !in screenBreakers &&
                        screened,
                )
                // ブレインフォース
                add("Neuroforce", 5120, ability == "Neuroforce" && effectiveness > 1)
                // スナイパー
                add("Sniper", 6144, ability == "Sniper" && critical)
                // いろめがね
                add("TintedLens", 8192, ability == "TintedLens" && effectiveness < 1)
                // マルチスケイル･ファントムガード
                add(defenderAbility, 2048, firstHit && defenderAbility in fullHpAbilities)
                // もふもふ（接触技）
                add("FluffyContact", 2048, defenderAbility == "Fluffy" && context.contact)
                add("WaveShield", 2048, defenderAbility == "WaveShield" && context.contact)
                // パンクロック
                add(
                    "PunkRock",
                    2048,
                    defenderAbility == "PunkRock" && MoveFlag.SOUND in context.move.flags,
                )
                // こおりのりんぷん
                add("IceScales", 2048, defenderAbility == "IceScales" && !context.physical)
                // フレンドガード
                add("FriendGuard", 3072, FieldEffect.FRIEND_GUARD in context.field.effects)
                // ハードロック･フィルター･プリズムアーマー
                add(
                    defenderAbility,
                    3072,
                    defenderAbility in superEffectiveReducers && effectiveness > 1,
                )
                // もふもふ（ほのお技）
                add("FluffyFire", 8192, defenderAbility == "Fluffy" && type == TeraType.FIRE)
                // たつじんのおび
                add("ExpertBelt", 4915, item == "ExpertBelt" && effectiveness > 1)
                // いのちのたま
                add("LifeOrb", 5324, item == "LifeOrb")
                // 半減きのみ･じゅくせい
                add(
                    context.defenderItem?.value.orEmpty(),
                    if (defenderAbility == "Ripen") 1024 else 2048,
                    firstHit &&
                        ItemRules.resistType(context.defenderItem) == type &&
                        (effectiveness > 1 || type == TeraType.NORMAL) &&
                        !context.unnerve,
                )
            }.finish()
    }

    // かわらわり･レイジングブル･サイコファング
    private val screenBreakers = setOf("BrickBreak", "RagingBull", "PsychicFangs")
    private val fullHpAbilities = setOf("Multiscale", "ShadowShield")
    private val superEffectiveReducers = setOf("SolidRock", "Filter", "PrismArmor")
}
