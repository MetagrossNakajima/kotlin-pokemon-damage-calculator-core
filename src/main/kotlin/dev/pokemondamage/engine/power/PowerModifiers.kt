package dev.pokemondamage.engine.power

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.TypeEffectiveness
import dev.pokemondamage.math.ModifierChain
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.FaintedAllies
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.Gender
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.Weather
import dev.pokemondamage.rules.AbilityRules
import dev.pokemondamage.rules.ItemRules

/** 威力補正を順に連結する。発動条件の成立は呼び出し側で判定する。 */
internal object PowerModifiers {
    fun calculate(
        context: DamageContext,
        unmodifiedPower: Long,
    ): ModifierChain {
        val attacker = context.attacker
        val defender = context.defender
        val ability = context.attackerAbility?.value.orEmpty()
        val defenderAbility = context.defenderAbility?.value.orEmpty()
        val item = context.attackerItem?.value.orEmpty()
        val move = context.move.original.id.value
        val type = context.move.type
        val flags = context.move.flags
        val effects = context.field.effects
        val terrain = context.field.terrain
        val physical = context.physical
        return ModifierChain("power", ModifierStage.POWER_MODIFIER).apply {
            // からげんき･しおみず
            add(
                move,
                8192,
                (move == "Facade" && attacker.status in facadeStatuses) ||
                    (move == "Brine" && defender.hp <= defender.stats.hp / 2),
            )
            // ワイドフォース
            add(
                "ExpandingForce",
                6144,
                move == "ExpandingForce" && terrain == Terrain.PSYCHIC && context.attackerGrounded,
            )
            // はたきおとす
            add(
                "KnockOff",
                6144,
                move == "KnockOff" &&
                    defender.item != null &&
                    !defender.itemConsumed &&
                    defender.flags[PokemonFlag.ITEM_REMOVABLE] != false,
            )
            // Gのちから
            add("GravApple", 6144, move == "GravApple" && context.field.gravity)
            // ソーラービーム･ソーラーブレード
            add(
                "Solar",
                2048,
                move in solarMoves &&
                    context.weather != null &&
                    context.weather != Weather.SUNLIGHT,
            )
            // アクセルブレイク･イナズマドライブ
            add(move, 5461, move in collisionMoves && TypeEffectiveness.typeMultiplier(context) > 1)
            // てだすけ
            add("HelpingHand", 6144, FieldEffect.HELPING_HAND in effects)
            // フィールドのタイプ強化
            add("Terrain", 5325, context.attackerGrounded && terrain?.boostedType == type)
            // ミストフィールド
            add(
                "MistyTerrain",
                2048,
                terrain == Terrain.MISTY && type == TeraType.DRAGON && context.defenderGrounded,
            )
            // グラスフィールド
            add(
                "GrassyTerrain",
                2048,
                terrain == Terrain.GRASS && move in grassyMoves && context.defenderGrounded,
            )
            // テクニシャン
            add("Technician", 6144, ability == "Technician" && unmodifiedPower <= 60)
            // ねつぼうそう
            add("FlareBoost", 6144, ability == "FlareBoost" && !physical)
            // どくぼうそう
            add("ToxicBoost", 6144, ability == "ToxicBoost" && physical)
            // がんじょうあご
            add("StrongJaw", 6144, ability == "StrongJaw" && MoveFlag.BITE in flags)
            // メガランチャー
            add("MegaLauncher", 6144, ability == "MegaLauncher" && MoveFlag.PULSE in flags)
            // はがねのせいしん
            add("SteelySpirit", 6144, ability == "SteelySpirit" && type == TeraType.STEEL)
            // きれあじ
            add("Sharpness", 6144, ability == "Sharpness" && MoveFlag.SHARPNESS in flags)
            // じゅうでん
            add(
                "Charge",
                8192,
                type == TeraType.ELECTRIC && attacker.flags[PokemonFlag.CHARGE] == true,
            )
            addAura(this, context)
            // ちからずく
            add("SheerForce", 5325, ability == "SheerForce" && MoveFlag.SHEER_FORCE in flags)
            // すなのちから
            add("SandForce", 5325, ability == "SandForce" && type in sandTypes)
            // アナライズ
            add("Analytic", 5325, ability == "Analytic")
            // かたいツメ
            add("ToughClaws", 5325, ability == "ToughClaws" && context.contact)
            // パンクロック
            add("PunkRock", 5325, ability == "PunkRock" && MoveFlag.SOUND in flags)
            // バッテリー
            add("Battery", 5325, FieldEffect.BATTERY in effects && !physical)
            // パワースポット
            add("PowerSpot", 5325, FieldEffect.POWER_SPOT in effects)
            // とうそうしん
            add(
                "Rivalry",
                if (attacker.profile.gender == defender.profile.gender) 5120 else 3072,
                ability == "Rivalry" &&
                    attacker.profile.gender != Gender.GENDERLESS &&
                    defender.profile.gender != Gender.GENDERLESS,
            )
            addSkin(this, context)
            // てつのこぶし
            add("IronFist", 4915, ability == "IronFist" && MoveFlag.PUNCH in flags)
            // すてみ
            add("Reckless", 4915, ability == "Reckless" && MoveFlag.RECOIL in flags)
            // かんそうはだ
            add("DrySkin", 5120, defenderAbility == "DrySkin" && type == TeraType.FIRE)
            // そうだいしょう
            add(
                "SupremeOverlord",
                attacker.faintedAllies.supremeOverlordModifier,
                ability == "SupremeOverlord" && attacker.faintedAllies != FaintedAllies.NONE,
            )
            // ノーマルジュエル
            add("NormalGem", 5325, item == "NormalGem" && type == TeraType.NORMAL)
            // ちからのハチマキ
            add("MuscleBand", 4505, item == "MuscleBand" && physical)
            // ものしりメガネ
            add("WiseGlasses", 4505, item == "WiseGlasses" && !physical)
            // パンチグローブ
            add("PunchingGlove", 4506, item == "PunchingGlove" && MoveFlag.PUNCH in flags)
            // タイプ強化アイテム
            add(item, 4915, ItemRules.boostType(context.attackerItem) == type)
            addSpeciesItem(this, context)
            // サイコブレイド
            add("Psyblade", 6144, move == "Psyblade" && terrain == Terrain.ELECTRIC)
            // ライジングボルト
            add(
                "RisingVoltage",
                8192,
                move == "RisingVoltage" && terrain == Terrain.ELECTRIC && context.defenderGrounded,
            )
            // どろあそび
            add("MudSport", 1352, FieldEffect.MUD_SPORT in effects && type == TeraType.ELECTRIC)
            // みずあそび
            add("WaterSport", 1352, FieldEffect.WATER_SPORT in effects && type == TeraType.FIRE)
        }
    }

    private fun addAura(
        chain: ModifierChain,
        context: DamageContext,
    ) {
        val aura =
            when (context.move.type) {
                // フェアリーオーラ
                TeraType.FAIRY -> AbilityId("FairyAura")

                // ダークオーラ
                TeraType.DARK -> AbilityId("DarkAura")

                else -> return
            }
        val effect =
            if (context.move.type == TeraType.FAIRY) {
                FieldEffect.FAIRY_AURA
            } else {
                FieldEffect.DARK_AURA
            }
        val active =
            context.attackerAbility == aura ||
                context.activeDefenderAbility == aura ||
                effect in context.field.effects
        // オーラブレイク
        val broken =
            context.attackerAbility == AbilityId("AuraBreak") ||
                context.defenderAbility == AbilityId("AuraBreak") ||
                FieldEffect.AURA_BREAK in context.field.effects
        chain.add(if (broken) "AuraBreak" else aura.value, if (broken) 3072 else 5448, active)
    }

    private fun addSkin(
        chain: ModifierChain,
        context: DamageContext,
    ) {
        val move = context.move.original
        // 独自のタイプ決定処理を持つ技は、発動条件に応じて対象外にする
        val convertible =
            move.id != MoveId("Judgment") &&
                move.id != MoveId("WeatherBall") &&
                move.id != MoveId("TerrainPulse") &&
                !(move.id == MoveId("TeraBlast") && context.attacker.teraType != null)
        // スキン系特性･ノーマルスキン
        val skinType = AbilityRules.skinType(context.attackerAbility)
        val converted =
            context.attackerAbility == AbilityId("Normalize") ||
                (
                    skinType != null &&
                        move.type == PokemonType.NORMAL &&
                        context.move.type == skinType
                )
        chain.add(context.attackerAbility?.value.orEmpty(), 4915, convertible && converted)
    }

    // ポケモン専用の持ち物補正
    private fun addSpeciesItem(
        chain: ModifierChain,
        context: DamageContext,
    ) {
        val item = context.attackerItem ?: return
        val rule = speciesItems[item] ?: return
        chain.add(
            item.value,
            4915,
            context.attacker.profile.id in rule.species && context.move.type in rule.types,
        )
    }

    private val facadeStatuses = setOf(Status.BURN, Status.POISON, Status.TOXIC, Status.PARALYSIS)
    private val solarMoves = setOf("SolarBeam", "SolarBlade")
    private val collisionMoves = setOf("CollisionCourse", "ElectroDrift")
    private val grassyMoves = setOf("Earthquake", "Bulldoze")
    private val sandTypes = setOf(TeraType.GROUND, TeraType.ROCK, TeraType.STEEL)

    private data class SpeciesItemBoost(
        val species: Set<PokemonId>,
        val types: Set<TeraType>,
    )

    private val speciesItems =
        buildMap {
            val dialga =
                SpeciesItemBoost(
                    setOf(PokemonId("Dialga"), PokemonId("Dialga-Origin")),
                    setOf(TeraType.STEEL, TeraType.DRAGON),
                )
            val palkia =
                SpeciesItemBoost(
                    setOf(PokemonId("Palkia"), PokemonId("Palkia-Origin")),
                    setOf(TeraType.WATER, TeraType.DRAGON),
                )
            val giratina =
                SpeciesItemBoost(
                    setOf(PokemonId("Giratina"), PokemonId("Giratina-Origin")),
                    setOf(TeraType.GHOST, TeraType.DRAGON),
                )
            // こんごうだま
            put(ItemId("AdamantOrb"), dialga)
            // だいこんごうだま
            put(ItemId("AdamantCrystal"), dialga)
            // しらたま
            put(ItemId("LustrousOrb"), palkia)
            // だいしらたま
            put(ItemId("LustrousGlobe"), palkia)
            // はっきんだま
            put(ItemId("GriseousOrb"), giratina)
            // だいはっきんだま
            put(ItemId("GriseousCore"), giratina)
            put(
                // こころのしずく
                ItemId("SoulDew"),
                SpeciesItemBoost(
                    setOf(PokemonId("Latias"), PokemonId("Latios")),
                    setOf(TeraType.PSYCHIC, TeraType.DRAGON),
                ),
            )
        }
}
