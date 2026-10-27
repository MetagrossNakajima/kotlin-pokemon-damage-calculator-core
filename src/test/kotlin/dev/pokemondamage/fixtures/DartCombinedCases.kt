package dev.pokemondamage.fixtures

import dev.pokemondamage.model.KoStatus
import dev.pokemondamage.model.Status
import java.math.BigInteger

// Fixed expectations migrated from dart/combined.tsv.
// Dart implementation parity; the original fixture did not record a revision.
// Expectations are literals, independent of the implementation under test.
internal data class DartCombinedCase(
    val accuracy: Int,
    val ability: String?,
    val item: String?,
    val status: Status?,
    val hazards: Boolean,
    val hp: Map<BigInteger, BigInteger>,
    val damage: Map<BigInteger, BigInteger>,
    val koStatus: KoStatus,
    val possible: Int?,
    val guaranteed: Int?,
    val states: List<ExpectedCombinedState>,
)

internal data class ExpectedCombinedState(
    val hp: Int,
    val itemConsumed: Boolean,
    val toxicCounter: Int?,
    val cudChewTurn: Long?,
    val weight: BigInteger,
)

internal fun dartCombinedCases(): List<DartCombinedCase> =
    buildList {
        addAll(dartCombinedNoAbilityAccuracy0Cases())
        addAll(dartCombinedCudChewAccuracy0Cases())
        addAll(dartCombinedPoisonHealAccuracy0Cases())
        addAll(dartCombinedMagicGuardAccuracy0Cases())
        addAll(dartCombinedCheekPouchAccuracy0Cases())
        addAll(dartCombinedRipenAccuracy0Cases())
        addAll(dartCombinedOvercoatAccuracy0Cases())
        addAll(dartCombinedSandRushAccuracy0Cases())
        addAll(dartCombinedSandVeilAccuracy0Cases())
        addAll(dartCombinedNoAbilityAccuracy50Cases())
        addAll(dartCombinedCudChewAccuracy50Cases())
        addAll(dartCombinedPoisonHealAccuracy50Cases())
        addAll(dartCombinedMagicGuardAccuracy50Cases())
        addAll(dartCombinedCheekPouchAccuracy50Cases())
        addAll(dartCombinedRipenAccuracy50Cases())
        addAll(dartCombinedOvercoatAccuracy50Cases())
        addAll(dartCombinedSandRushAccuracy50Cases())
        addAll(dartCombinedSandVeilAccuracy50Cases())
        addAll(dartCombinedNoAbilityAccuracy100Cases())
        addAll(dartCombinedCudChewAccuracy100Cases())
        addAll(dartCombinedPoisonHealAccuracy100Cases())
        addAll(dartCombinedMagicGuardAccuracy100Cases())
        addAll(dartCombinedCheekPouchAccuracy100Cases())
        addAll(dartCombinedRipenAccuracy100Cases())
        addAll(dartCombinedOvercoatAccuracy100Cases())
        addAll(dartCombinedSandRushAccuracy100Cases())
        addAll(dartCombinedSandVeilAccuracy100Cases())
    }
