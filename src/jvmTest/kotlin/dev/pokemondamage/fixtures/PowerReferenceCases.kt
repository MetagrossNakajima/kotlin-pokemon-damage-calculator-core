package dev.pokemondamage.fixtures

// Fixed expectations preserved from reference/power.tsv; no runtime fixture parsing.
// Original reference-calculator snapshots; expectations are independent of production code.
internal fun powerReferenceCases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferenceIlluminateCases())
        addAll(powerReferenceTechnicianCases())
        addAll(powerReferenceFlareBoost1Cases())
        addAll(powerReferenceFlareBoost2Cases())
        addAll(powerReferenceToxicBoostCases())
        addAll(powerReferenceStrongJawCases())
        addAll(powerReferenceMegaLauncher1Cases())
        addAll(powerReferenceMegaLauncher2Cases())
        addAll(powerReferenceSteelySpirit1Cases())
        addAll(powerReferenceSteelySpirit2Cases())
        addAll(powerReferenceSharpnessCases())
        addAll(powerReferenceSheerForce1Cases())
        addAll(powerReferenceSheerForce2Cases())
        addAll(powerReferenceSandForceCases())
        addAll(powerReferenceAnalyticCases())
        addAll(powerReferenceToughClaws1Cases())
        addAll(powerReferenceToughClaws2Cases())
        addAll(powerReferencePunkRockCases())
        addAll(powerReferenceIronFistCases())
        addAll(powerReferenceRecklessCases())
    }
