package dev.pokemondamage.rules

import dev.pokemondamage.model.MoveId

/** 入力検証とダメージ計算で共有する技の分類。 */
internal object MoveRules {
    private val guaranteedCritical =
        setOf(
            MoveId("WickedBlow"),
            MoveId("FlowerTrick"),
            MoveId("FrostBreath"),
            MoveId("StormThrow"),
            MoveId("SurgingStrikes"),
        )

    private val naturalMultiHit =
        setOf(
            MoveId("DoubleKick"),
            MoveId("SurgingStrikes"),
            MoveId("DoubleHit"),
            MoveId("Bonemerang"),
            MoveId("DoubleIronBash"),
            MoveId("DragonDarts"),
            MoveId("DualChop"),
            MoveId("DualWingbeat"),
            MoveId("GearGrind"),
            MoveId("Twineedle"),
            MoveId("TwinBeam"),
            MoveId("TripleDive"),
            MoveId("BulletSeed"),
            MoveId("RockBlast"),
            MoveId("IcicleSpear"),
            MoveId("PinMissile"),
            MoveId("TailSlap"),
            MoveId("ArmThrust"),
            MoveId("Barrage"),
            MoveId("BoneRush"),
            MoveId("CometPunch"),
            MoveId("DoubleSlap"),
            MoveId("FuryAttack"),
            MoveId("FurySwipes"),
            MoveId("SpikeCannon"),
            MoveId("WaterShuriken"),
            MoveId("ScaleShot"),
            MoveId("TripleAxel"),
            MoveId("TripleKick"),
            MoveId("PopulationBomb"),
        )

    private val weightBased =
        setOf(
            MoveId("LowKick"),
            MoveId("GrassKnot"),
            MoveId("HeavySlam"),
            MoveId("HeatCrash"),
        )

    private val unsupported =
        setOf(
            MoveId("Counter"),
            MoveId("Bide"),
            MoveId("Comeuppance"),
            MoveId("MirrorCoat"),
            MoveId("MetalBurst"),
            MoveId("Psywave"),
        )

    private val fixedDamage =
        mapOf(
            MoveId("SuperFang") to FixedDamageKind.HALF_CURRENT_HP,
            MoveId("NaturesMadness") to FixedDamageKind.HALF_CURRENT_HP,
            MoveId("Ruination") to FixedDamageKind.HALF_CURRENT_HP,
            MoveId("GuardianofAlola") to FixedDamageKind.THREE_QUARTERS_CURRENT_HP,
            MoveId("FinalGambit") to FixedDamageKind.ATTACKER_HP,
            MoveId("Endeavor") to FixedDamageKind.HP_DIFFERENCE,
            MoveId("SonicBoom") to FixedDamageKind.TWENTY,
            MoveId("DragonRage") to FixedDamageKind.FORTY,
            MoveId("SeismicToss") to FixedDamageKind.LEVEL,
            MoveId("NightShade") to FixedDamageKind.LEVEL,
            MoveId("Fissure") to FixedDamageKind.ONE_HIT_KO,
            MoveId("SheerCold") to FixedDamageKind.ONE_HIT_KO,
            MoveId("HornDrill") to FixedDamageKind.ONE_HIT_KO,
            MoveId("Guillotine") to FixedDamageKind.ONE_HIT_KO,
        )

    fun isGuaranteedCritical(id: MoveId): Boolean = id in guaranteedCritical

    fun isNaturalMultiHit(id: MoveId): Boolean = id in naturalMultiHit

    fun isWeightBased(id: MoveId): Boolean = id in weightBased

    fun isUnsupported(id: MoveId): Boolean = id in unsupported

    fun fixedDamageKind(id: MoveId): FixedDamageKind? = fixedDamage[id]

    fun isFixedDamage(id: MoveId): Boolean = fixedDamageKind(id) != null
}
