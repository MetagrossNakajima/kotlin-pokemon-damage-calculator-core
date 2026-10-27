package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Category
import dev.pokemondamage.model.PokemonType

// Fixed expectations migrated from reference/target-hp.tsv.
// Native reference parity; the original fixture did not record a version in its header.
// Expectations are literals, independent of the implementation under test.
internal data class TargetHpCase(
    val move: String,
    val type: PokemonType,
    val category: Category,
    val hp: Int,
    val power: Int,
    val damage: List<Int>,
)

internal fun targetHpCases(): List<TargetHpCase> =
    buildList {
        addAll(targetHpCasesPart1())
        addAll(targetHpCasesPart2())
    }

private fun targetHpCasesPart1(): List<TargetHpCase> =
    listOf(
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 1,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 2,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 3,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 7,
            power = 4,
            damage = listOf(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 99,
            power = 59,
            damage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 100,
            power = 60,
            damage = listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 101,
            power = 60,
            damage = listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 199,
            power = 119,
            damage = listOf(67, 69, 69, 70, 72, 72, 73, 73, 75, 75, 76, 76, 78, 78, 79, 81),
        ),
        TargetHpCase(
            move = "CrushGrip",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            hp = 200,
            power = 120,
            damage = listOf(67, 69, 69, 70, 72, 72, 73, 73, 75, 75, 76, 76, 78, 78, 79, 81),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 1,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 2,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 3,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 7,
            power = 4,
            damage = listOf(3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 99,
            power = 59,
            damage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 100,
            power = 60,
            damage = listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 101,
            power = 60,
            damage = listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 199,
            power = 119,
            damage = listOf(67, 69, 69, 70, 72, 72, 73, 73, 75, 75, 76, 76, 78, 78, 79, 81),
        ),
        TargetHpCase(
            move = "WringOut",
            type = PokemonType.NORMAL,
            category = Category.SPECIAL,
            hp = 200,
            power = 120,
            damage = listOf(67, 69, 69, 70, 72, 72, 73, 73, 75, 75, 76, 76, 78, 78, 79, 81),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 1,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 2,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2),
        ),
    )

private fun targetHpCasesPart2(): List<TargetHpCase> =
    listOf(
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 3,
            power = 1,
            damage = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 7,
            power = 3,
            damage = listOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 99,
            power = 49,
            damage = listOf(19, 19, 20, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 100,
            power = 50,
            damage = listOf(20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23, 23, 23, 23, 24),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 101,
            power = 50,
            damage = listOf(20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23, 23, 23, 23, 24),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 199,
            power = 99,
            damage = listOf(38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45),
        ),
        TargetHpCase(
            move = "HardPress",
            type = PokemonType.STEEL,
            category = Category.PHYSICAL,
            hp = 200,
            power = 100,
            damage = listOf(39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46),
        ),
    )
