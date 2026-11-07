package dev.pokemondamage.fixtures

// Fixed expectations preserved from reference/tera-power.tsv; no runtime fixture parsing.
// Original reference-calculator snapshots; expectations are independent of production code.
internal fun teraPowerReferenceCases(): List<TeraPowerReferenceCase> =
    buildList {
        addAll(teraPowerReferenceTackleCases())
        addAll(teraPowerReferenceQuickAttackCases())
        addAll(teraPowerReferenceDoubleKickCases())
        addAll(teraPowerReferenceEruptionCases())
        addAll(teraPowerReferenceWaterSpoutCases())
        addAll(teraPowerReferenceDragonEnergyCases())
    }
