package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Status

// Fixed expectations migrated from reference/ability-ko.tsv.
// Native reference parity; the original fixture did not record a version in its header.
// Expectations are literals, independent of the implementation under test.
internal data class AbilityKoCase(
    val ability: String,
    val enabled: Boolean,
    val damage: Int,
    val sand: Boolean,
    val status: Status?,
    val hits: Int,
    val chance: Int,
)

internal fun abilityKoCases(): List<AbilityKoCase> =
    buildList {
        addAll(abilityKoCasesPart1())
    }

private fun abilityKoCasesPart1(): List<AbilityKoCase> =
    listOf(
        AbilityKoCase(
            ability = "MagicGuard",
            enabled = false,
            damage = 30,
            sand = true,
            status = null,
            hits = 3,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "MagicGuard",
            enabled = true,
            damage = 30,
            sand = true,
            status = null,
            hits = 4,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "Overcoat",
            enabled = false,
            damage = 30,
            sand = true,
            status = null,
            hits = 3,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "Overcoat",
            enabled = true,
            damage = 30,
            sand = true,
            status = null,
            hits = 4,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "SandRush",
            enabled = false,
            damage = 30,
            sand = true,
            status = null,
            hits = 3,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "SandRush",
            enabled = true,
            damage = 30,
            sand = true,
            status = null,
            hits = 4,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "SandVeil",
            enabled = false,
            damage = 30,
            sand = true,
            status = null,
            hits = 3,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "SandVeil",
            enabled = true,
            damage = 30,
            sand = true,
            status = null,
            hits = 4,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "PoisonHeal",
            enabled = false,
            damage = 40,
            sand = false,
            status = Status.POISON,
            hits = 2,
            chance = 1,
        ),
        AbilityKoCase(
            ability = "PoisonHeal",
            enabled = true,
            damage = 40,
            sand = false,
            status = Status.POISON,
            hits = 4,
            chance = 1,
        ),
    )
