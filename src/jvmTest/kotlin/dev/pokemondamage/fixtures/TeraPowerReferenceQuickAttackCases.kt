package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.TeraType

// Fixed reference expectations for QuickAttack. See TeraPowerReferenceCases for provenance.
internal fun teraPowerReferenceQuickAttackCases(): List<TeraPowerReferenceCase> =
    buildList {
        addAll(teraPowerReferenceQuickAttackCasesPart1())
        addAll(teraPowerReferenceQuickAttackCasesPart2())
        addAll(teraPowerReferenceQuickAttackCasesPart3())
        addAll(teraPowerReferenceQuickAttackCasesPart4())
        addAll(teraPowerReferenceQuickAttackCasesPart5())
        addAll(teraPowerReferenceQuickAttackCasesPart6())
        addAll(teraPowerReferenceQuickAttackCasesPart7())
    }

private fun teraPowerReferenceQuickAttackCasesPart1(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "193/QuickAttack/power=1/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "194/QuickAttack/power=1/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "195/QuickAttack/power=1/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "196/QuickAttack/power=1/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "197/QuickAttack/power=1/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "198/QuickAttack/power=1/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "199/QuickAttack/power=1/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "200/QuickAttack/power=1/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "201/QuickAttack/power=1/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "202/QuickAttack/power=1/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "203/QuickAttack/power=1/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "204/QuickAttack/power=1/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "205/QuickAttack/power=1/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "206/QuickAttack/power=1/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "207/QuickAttack/power=1/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "208/QuickAttack/power=1/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "209/QuickAttack/power=1/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "210/QuickAttack/power=1/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "211/QuickAttack/power=1/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "212/QuickAttack/power=1/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "213/QuickAttack/power=1/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "214/QuickAttack/power=1/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "215/QuickAttack/power=1/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "216/QuickAttack/power=1/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "217/QuickAttack/power=1/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "218/QuickAttack/power=1/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "219/QuickAttack/power=1/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "220/QuickAttack/power=1/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "221/QuickAttack/power=1/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "222/QuickAttack/power=1/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceQuickAttackCasesPart2(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "223/QuickAttack/power=1/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "224/QuickAttack/power=1/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("QuickAttack"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 1),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "225/QuickAttack/power=39/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "226/QuickAttack/power=39/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "227/QuickAttack/power=39/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "228/QuickAttack/power=39/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "229/QuickAttack/power=39/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "230/QuickAttack/power=39/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "231/QuickAttack/power=39/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "232/QuickAttack/power=39/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "233/QuickAttack/power=39/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "234/QuickAttack/power=39/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "235/QuickAttack/power=39/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "236/QuickAttack/power=39/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "237/QuickAttack/power=39/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "238/QuickAttack/power=39/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "239/QuickAttack/power=39/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "240/QuickAttack/power=39/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "241/QuickAttack/power=39/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "242/QuickAttack/power=39/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "243/QuickAttack/power=39/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "244/QuickAttack/power=39/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "245/QuickAttack/power=39/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "246/QuickAttack/power=39/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "247/QuickAttack/power=39/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "248/QuickAttack/power=39/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "249/QuickAttack/power=39/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "250/QuickAttack/power=39/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "251/QuickAttack/power=39/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "252/QuickAttack/power=39/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
    )

private fun teraPowerReferenceQuickAttackCasesPart3(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "253/QuickAttack/power=39/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "254/QuickAttack/power=39/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "255/QuickAttack/power=39/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "256/QuickAttack/power=39/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "257/QuickAttack/power=40/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "258/QuickAttack/power=40/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "259/QuickAttack/power=40/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "260/QuickAttack/power=40/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "261/QuickAttack/power=40/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "262/QuickAttack/power=40/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "263/QuickAttack/power=40/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "264/QuickAttack/power=40/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "265/QuickAttack/power=40/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "266/QuickAttack/power=40/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "267/QuickAttack/power=40/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "268/QuickAttack/power=40/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "269/QuickAttack/power=40/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "270/QuickAttack/power=40/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "271/QuickAttack/power=40/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "272/QuickAttack/power=40/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "273/QuickAttack/power=40/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "274/QuickAttack/power=40/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "275/QuickAttack/power=40/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "276/QuickAttack/power=40/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "277/QuickAttack/power=40/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "278/QuickAttack/power=40/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "279/QuickAttack/power=40/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "280/QuickAttack/power=40/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "281/QuickAttack/power=40/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "282/QuickAttack/power=40/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
    )

private fun teraPowerReferenceQuickAttackCasesPart4(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "283/QuickAttack/power=40/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "284/QuickAttack/power=40/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "285/QuickAttack/power=40/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "286/QuickAttack/power=40/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "287/QuickAttack/power=40/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "288/QuickAttack/power=40/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "289/QuickAttack/power=59/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "290/QuickAttack/power=59/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "291/QuickAttack/power=59/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "292/QuickAttack/power=59/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "293/QuickAttack/power=59/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "294/QuickAttack/power=59/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "295/QuickAttack/power=59/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "296/QuickAttack/power=59/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "297/QuickAttack/power=59/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "298/QuickAttack/power=59/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "299/QuickAttack/power=59/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "300/QuickAttack/power=59/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "301/QuickAttack/power=59/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "302/QuickAttack/power=59/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "303/QuickAttack/power=59/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "304/QuickAttack/power=59/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "305/QuickAttack/power=59/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "306/QuickAttack/power=59/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "307/QuickAttack/power=59/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "308/QuickAttack/power=59/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "309/QuickAttack/power=59/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "310/QuickAttack/power=59/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "311/QuickAttack/power=59/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "312/QuickAttack/power=59/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
    )

private fun teraPowerReferenceQuickAttackCasesPart5(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "313/QuickAttack/power=59/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "314/QuickAttack/power=59/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "315/QuickAttack/power=59/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "316/QuickAttack/power=59/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "317/QuickAttack/power=59/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "318/QuickAttack/power=59/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "319/QuickAttack/power=59/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "320/QuickAttack/power=59/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "321/QuickAttack/power=60/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "322/QuickAttack/power=60/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "323/QuickAttack/power=60/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "324/QuickAttack/power=60/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "325/QuickAttack/power=60/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "326/QuickAttack/power=60/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "327/QuickAttack/power=60/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "328/QuickAttack/power=60/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "329/QuickAttack/power=60/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "330/QuickAttack/power=60/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "331/QuickAttack/power=60/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "332/QuickAttack/power=60/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "333/QuickAttack/power=60/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "334/QuickAttack/power=60/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "335/QuickAttack/power=60/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "336/QuickAttack/power=60/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "337/QuickAttack/power=60/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "338/QuickAttack/power=60/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "339/QuickAttack/power=60/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "340/QuickAttack/power=60/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "341/QuickAttack/power=60/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "342/QuickAttack/power=60/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
    )

private fun teraPowerReferenceQuickAttackCasesPart6(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "343/QuickAttack/power=60/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "344/QuickAttack/power=60/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "345/QuickAttack/power=60/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "346/QuickAttack/power=60/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "347/QuickAttack/power=60/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "348/QuickAttack/power=60/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "349/QuickAttack/power=60/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "350/QuickAttack/power=60/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "351/QuickAttack/power=60/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "352/QuickAttack/power=60/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "353/QuickAttack/power=61/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "354/QuickAttack/power=61/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "355/QuickAttack/power=61/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "356/QuickAttack/power=61/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "357/QuickAttack/power=61/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "358/QuickAttack/power=61/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "359/QuickAttack/power=61/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "360/QuickAttack/power=61/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "361/QuickAttack/power=61/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "362/QuickAttack/power=61/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "363/QuickAttack/power=61/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "364/QuickAttack/power=61/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "365/QuickAttack/power=61/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "366/QuickAttack/power=61/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "367/QuickAttack/power=61/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "368/QuickAttack/power=61/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "369/QuickAttack/power=61/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "370/QuickAttack/power=61/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "371/QuickAttack/power=61/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "372/QuickAttack/power=61/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
    )

private fun teraPowerReferenceQuickAttackCasesPart7(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "373/QuickAttack/power=61/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "374/QuickAttack/power=61/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "375/QuickAttack/power=61/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "376/QuickAttack/power=61/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "377/QuickAttack/power=61/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "378/QuickAttack/power=61/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "379/QuickAttack/power=61/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "380/QuickAttack/power=61/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "381/QuickAttack/power=61/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "382/QuickAttack/power=61/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "383/QuickAttack/power=61/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "384/QuickAttack/power=61/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("QuickAttack"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 1,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
    )
