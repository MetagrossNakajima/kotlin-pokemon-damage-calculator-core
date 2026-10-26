package dev.pokemondamage.rules

import dev.pokemondamage.model.MoveId

/** Move classifications shared by validation and the damage pipeline. */
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
        setOf(
            MoveId("SuperFang"),
            MoveId("NaturesMadness"),
            MoveId("Ruination"),
            MoveId("GuardianofAlola"),
            MoveId("FinalGambit"),
            MoveId("Endeavor"),
            MoveId("SonicBoom"),
            MoveId("DragonRage"),
            MoveId("SeismicToss"),
            MoveId("NightShade"),
            MoveId("Fissure"),
            MoveId("SheerCold"),
            MoveId("HornDrill"),
            MoveId("Guillotine"),
        )

    fun isGuaranteedCritical(id: MoveId): Boolean = id in guaranteedCritical

    fun isNaturalMultiHit(id: MoveId): Boolean = id in naturalMultiHit

    fun isWeightBased(id: MoveId): Boolean = id in weightBased

    fun isUnsupported(id: MoveId): Boolean = id in unsupported

    fun isFixedDamage(id: MoveId): Boolean = id in fixedDamage
}
