package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.TeraType

// Fixed reference expectations for DragonEnergy. See TeraPowerReferenceCases for provenance.
internal fun teraPowerReferenceDragonEnergyCases(): List<TeraPowerReferenceCase> =
    buildList {
        addAll(teraPowerReferenceDragonEnergyCasesPart1())
        addAll(teraPowerReferenceDragonEnergyCasesPart2())
        addAll(teraPowerReferenceDragonEnergyCasesPart3())
        addAll(teraPowerReferenceDragonEnergyCasesPart4())
        addAll(teraPowerReferenceDragonEnergyCasesPart5())
        addAll(teraPowerReferenceDragonEnergyCasesPart6())
        addAll(teraPowerReferenceDragonEnergyCasesPart7())
    }

private fun teraPowerReferenceDragonEnergyCasesPart1(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "961/DragonEnergy/power=1/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "962/DragonEnergy/power=1/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "963/DragonEnergy/power=1/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "964/DragonEnergy/power=1/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "965/DragonEnergy/power=1/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "966/DragonEnergy/power=1/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "967/DragonEnergy/power=1/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "968/DragonEnergy/power=1/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "969/DragonEnergy/power=1/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "970/DragonEnergy/power=1/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "971/DragonEnergy/power=1/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "972/DragonEnergy/power=1/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "973/DragonEnergy/power=1/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "974/DragonEnergy/power=1/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "975/DragonEnergy/power=1/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "976/DragonEnergy/power=1/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "977/DragonEnergy/power=1/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "978/DragonEnergy/power=1/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "979/DragonEnergy/power=1/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "980/DragonEnergy/power=1/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "981/DragonEnergy/power=1/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "982/DragonEnergy/power=1/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "983/DragonEnergy/power=1/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "984/DragonEnergy/power=1/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "985/DragonEnergy/power=1/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "986/DragonEnergy/power=1/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "987/DragonEnergy/power=1/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "988/DragonEnergy/power=1/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "989/DragonEnergy/power=1/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "990/DragonEnergy/power=1/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceDragonEnergyCasesPart2(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "991/DragonEnergy/power=1/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "992/DragonEnergy/power=1/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    1,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "993/DragonEnergy/power=39/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "994/DragonEnergy/power=39/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "995/DragonEnergy/power=39/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "996/DragonEnergy/power=39/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "997/DragonEnergy/power=39/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "998/DragonEnergy/power=39/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "999/DragonEnergy/power=39/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1000/DragonEnergy/power=39/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1001/DragonEnergy/power=39/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1002/DragonEnergy/power=39/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1003/DragonEnergy/power=39/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1004/DragonEnergy/power=39/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1005/DragonEnergy/power=39/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1006/DragonEnergy/power=39/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1007/DragonEnergy/power=39/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1008/DragonEnergy/power=39/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1009/DragonEnergy/power=39/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1010/DragonEnergy/power=39/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1011/DragonEnergy/power=39/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1012/DragonEnergy/power=39/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1013/DragonEnergy/power=39/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1014/DragonEnergy/power=39/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1015/DragonEnergy/power=39/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1016/DragonEnergy/power=39/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1017/DragonEnergy/power=39/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1018/DragonEnergy/power=39/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1019/DragonEnergy/power=39/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1020/DragonEnergy/power=39/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceDragonEnergyCasesPart3(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "1021/DragonEnergy/power=39/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1022/DragonEnergy/power=39/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1023/DragonEnergy/power=39/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1024/DragonEnergy/power=39/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    39,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1025/DragonEnergy/power=40/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1026/DragonEnergy/power=40/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1027/DragonEnergy/power=40/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1028/DragonEnergy/power=40/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1029/DragonEnergy/power=40/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1030/DragonEnergy/power=40/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1031/DragonEnergy/power=40/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1032/DragonEnergy/power=40/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1033/DragonEnergy/power=40/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1034/DragonEnergy/power=40/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1035/DragonEnergy/power=40/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1036/DragonEnergy/power=40/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1037/DragonEnergy/power=40/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1038/DragonEnergy/power=40/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1039/DragonEnergy/power=40/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1040/DragonEnergy/power=40/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1041/DragonEnergy/power=40/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1042/DragonEnergy/power=40/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1043/DragonEnergy/power=40/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1044/DragonEnergy/power=40/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1045/DragonEnergy/power=40/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1046/DragonEnergy/power=40/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1047/DragonEnergy/power=40/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1048/DragonEnergy/power=40/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1049/DragonEnergy/power=40/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1050/DragonEnergy/power=40/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceDragonEnergyCasesPart4(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "1051/DragonEnergy/power=40/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1052/DragonEnergy/power=40/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1053/DragonEnergy/power=40/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1054/DragonEnergy/power=40/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1055/DragonEnergy/power=40/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1056/DragonEnergy/power=40/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1057/DragonEnergy/power=59/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1058/DragonEnergy/power=59/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1059/DragonEnergy/power=59/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1060/DragonEnergy/power=59/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1061/DragonEnergy/power=59/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1062/DragonEnergy/power=59/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1063/DragonEnergy/power=59/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1064/DragonEnergy/power=59/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1065/DragonEnergy/power=59/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1066/DragonEnergy/power=59/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1067/DragonEnergy/power=59/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1068/DragonEnergy/power=59/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1069/DragonEnergy/power=59/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1070/DragonEnergy/power=59/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1071/DragonEnergy/power=59/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1072/DragonEnergy/power=59/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1073/DragonEnergy/power=59/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1074/DragonEnergy/power=59/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1075/DragonEnergy/power=59/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1076/DragonEnergy/power=59/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1077/DragonEnergy/power=59/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1078/DragonEnergy/power=59/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1079/DragonEnergy/power=59/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1080/DragonEnergy/power=59/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceDragonEnergyCasesPart5(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "1081/DragonEnergy/power=59/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1082/DragonEnergy/power=59/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1083/DragonEnergy/power=59/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1084/DragonEnergy/power=59/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1085/DragonEnergy/power=59/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1086/DragonEnergy/power=59/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1087/DragonEnergy/power=59/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1088/DragonEnergy/power=59/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    59,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1089/DragonEnergy/power=60/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1090/DragonEnergy/power=60/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1091/DragonEnergy/power=60/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1092/DragonEnergy/power=60/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1093/DragonEnergy/power=60/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1094/DragonEnergy/power=60/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1095/DragonEnergy/power=60/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1096/DragonEnergy/power=60/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1097/DragonEnergy/power=60/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1098/DragonEnergy/power=60/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1099/DragonEnergy/power=60/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1100/DragonEnergy/power=60/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1101/DragonEnergy/power=60/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1102/DragonEnergy/power=60/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1103/DragonEnergy/power=60/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1104/DragonEnergy/power=60/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1105/DragonEnergy/power=60/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1106/DragonEnergy/power=60/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1107/DragonEnergy/power=60/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1108/DragonEnergy/power=60/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1109/DragonEnergy/power=60/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1110/DragonEnergy/power=60/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceDragonEnergyCasesPart6(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "1111/DragonEnergy/power=60/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1112/DragonEnergy/power=60/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1113/DragonEnergy/power=60/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1114/DragonEnergy/power=60/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1115/DragonEnergy/power=60/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1116/DragonEnergy/power=60/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1117/DragonEnergy/power=60/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1118/DragonEnergy/power=60/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1119/DragonEnergy/power=60/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1120/DragonEnergy/power=60/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1121/DragonEnergy/power=61/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1122/DragonEnergy/power=61/tera=none/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1123/DragonEnergy/power=61/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1124/DragonEnergy/power=61/tera=none/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1125/DragonEnergy/power=61/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1126/DragonEnergy/power=61/tera=none/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1127/DragonEnergy/power=61/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1128/DragonEnergy/power=61/tera=none/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1129/DragonEnergy/power=61/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1130/DragonEnergy/power=61/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1131/DragonEnergy/power=61/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1132/DragonEnergy/power=61/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1133/DragonEnergy/power=61/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1134/DragonEnergy/power=61/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1135/DragonEnergy/power=61/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1136/DragonEnergy/power=61/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1137/DragonEnergy/power=61/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1138/DragonEnergy/power=61/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1139/DragonEnergy/power=61/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1140/DragonEnergy/power=61/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceDragonEnergyCasesPart7(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "1141/DragonEnergy/power=61/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1142/DragonEnergy/power=61/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1143/DragonEnergy/power=61/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1144/DragonEnergy/power=61/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1145/DragonEnergy/power=61/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1146/DragonEnergy/power=61/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1147/DragonEnergy/power=61/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1148/DragonEnergy/power=61/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1149/DragonEnergy/power=61/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1150/DragonEnergy/power=61/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "1151/DragonEnergy/power=61/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "1152/DragonEnergy/power=61/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(
                    MoveId("DragonEnergy"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    priority = 0,
                ),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )
