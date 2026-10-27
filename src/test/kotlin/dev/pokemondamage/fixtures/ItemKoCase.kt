package dev.pokemondamage.fixtures

// Fixed expectations migrated from reference/item-ko.tsv.
// Native reference parity; the original fixture did not record a version in its header.
// Expectations are literals, independent of the implementation under test.
internal data class ItemKoCase(
    val item: String,
    val enabled: Boolean,
    val damage: Int,
    val hazards: Boolean,
    val sand: Boolean,
    val hits: Int,
    val chance: Int,
)

internal fun itemKoCases(): List<ItemKoCase> =
    buildList {
        addAll(itemKoCasesPart1())
    }

private fun itemKoCasesPart1(): List<ItemKoCase> =
    listOf(
        ItemKoCase(
            item = "Heavy-DutyBoots",
            enabled = false,
            damage = 30,
            hazards = true,
            sand = false,
            hits = 3,
            chance = 1,
        ),
        ItemKoCase(
            item = "Heavy-DutyBoots",
            enabled = true,
            damage = 30,
            hazards = true,
            sand = false,
            hits = 4,
            chance = 1,
        ),
        ItemKoCase(
            item = "Leftovers",
            enabled = false,
            damage = 35,
            hazards = false,
            sand = false,
            hits = 3,
            chance = 1,
        ),
        ItemKoCase(
            item = "Leftovers",
            enabled = true,
            damage = 35,
            hazards = false,
            sand = false,
            hits = 4,
            chance = 1,
        ),
        ItemKoCase(
            item = "SafetyGoggles",
            enabled = false,
            damage = 30,
            hazards = false,
            sand = true,
            hits = 3,
            chance = 1,
        ),
        ItemKoCase(
            item = "SafetyGoggles",
            enabled = true,
            damage = 30,
            hazards = false,
            sand = true,
            hits = 4,
            chance = 1,
        ),
    )
