package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.TeraType

// Fixed reference expectations for Eruption. See TeraPowerReferenceCases for provenance.
internal fun teraPowerReferenceEruptionCases(): List<TeraPowerReferenceCase> =
    buildList {
        addAll(teraPowerReferenceEruptionCasesPart1())
        addAll(teraPowerReferenceEruptionCasesPart2())
        addAll(teraPowerReferenceEruptionCasesPart3())
        addAll(teraPowerReferenceEruptionCasesPart4())
        addAll(teraPowerReferenceEruptionCasesPart5())
        addAll(teraPowerReferenceEruptionCasesPart6())
        addAll(teraPowerReferenceEruptionCasesPart7())
    }

private fun teraPowerReferenceEruptionCasesPart1(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "577/Eruption/power=1/tera=none/available=false/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "578/Eruption/power=1/tera=none/available=false/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "579/Eruption/power=1/tera=none/available=false/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "580/Eruption/power=1/tera=none/available=false/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "581/Eruption/power=1/tera=none/available=true/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "582/Eruption/power=1/tera=none/available=true/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "583/Eruption/power=1/tera=none/available=true/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "584/Eruption/power=1/tera=none/available=true/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "585/Eruption/power=1/tera=NORMAL/available=false/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "586/Eruption/power=1/tera=NORMAL/available=false/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "587/Eruption/power=1/tera=NORMAL/available=false/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "588/Eruption/power=1/tera=NORMAL/available=false/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "589/Eruption/power=1/tera=NORMAL/available=true/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "590/Eruption/power=1/tera=NORMAL/available=true/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "591/Eruption/power=1/tera=NORMAL/available=true/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "592/Eruption/power=1/tera=NORMAL/available=true/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "593/Eruption/power=1/tera=WATER/available=false/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "594/Eruption/power=1/tera=WATER/available=false/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "595/Eruption/power=1/tera=WATER/available=false/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "596/Eruption/power=1/tera=WATER/available=false/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "597/Eruption/power=1/tera=WATER/available=true/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "598/Eruption/power=1/tera=WATER/available=true/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "599/Eruption/power=1/tera=WATER/available=true/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "600/Eruption/power=1/tera=WATER/available=true/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "601/Eruption/power=1/tera=STELLAR/available=false/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "602/Eruption/power=1/tera=STELLAR/available=false/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "603/Eruption/power=1/tera=STELLAR/available=false/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "604/Eruption/power=1/tera=STELLAR/available=false/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "605/Eruption/power=1/tera=STELLAR/available=true/hp=1/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "606/Eruption/power=1/tera=STELLAR/available=true/hp=1/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceEruptionCasesPart2(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "607/Eruption/power=1/tera=STELLAR/available=true/hp=200/Illuminate",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "608/Eruption/power=1/tera=STELLAR/available=true/hp=200/Technician",
            move = Move(MoveId("Eruption"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "609/Eruption/power=39/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "610/Eruption/power=39/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "611/Eruption/power=39/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "612/Eruption/power=39/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "613/Eruption/power=39/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "614/Eruption/power=39/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "615/Eruption/power=39/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "616/Eruption/power=39/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "617/Eruption/power=39/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "618/Eruption/power=39/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "619/Eruption/power=39/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "620/Eruption/power=39/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "621/Eruption/power=39/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "622/Eruption/power=39/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "623/Eruption/power=39/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "624/Eruption/power=39/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "625/Eruption/power=39/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "626/Eruption/power=39/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "627/Eruption/power=39/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "628/Eruption/power=39/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "629/Eruption/power=39/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "630/Eruption/power=39/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "631/Eruption/power=39/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "632/Eruption/power=39/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "633/Eruption/power=39/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "634/Eruption/power=39/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "635/Eruption/power=39/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "636/Eruption/power=39/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceEruptionCasesPart3(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "637/Eruption/power=39/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "638/Eruption/power=39/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "639/Eruption/power=39/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "640/Eruption/power=39/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "641/Eruption/power=40/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "642/Eruption/power=40/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "643/Eruption/power=40/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "644/Eruption/power=40/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "645/Eruption/power=40/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "646/Eruption/power=40/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "647/Eruption/power=40/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "648/Eruption/power=40/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "649/Eruption/power=40/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "650/Eruption/power=40/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "651/Eruption/power=40/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "652/Eruption/power=40/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "653/Eruption/power=40/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "654/Eruption/power=40/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "655/Eruption/power=40/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "656/Eruption/power=40/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "657/Eruption/power=40/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "658/Eruption/power=40/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "659/Eruption/power=40/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "660/Eruption/power=40/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "661/Eruption/power=40/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "662/Eruption/power=40/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "663/Eruption/power=40/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "664/Eruption/power=40/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "665/Eruption/power=40/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "666/Eruption/power=40/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceEruptionCasesPart4(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "667/Eruption/power=40/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "668/Eruption/power=40/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "669/Eruption/power=40/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "670/Eruption/power=40/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "671/Eruption/power=40/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "672/Eruption/power=40/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "673/Eruption/power=59/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "674/Eruption/power=59/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "675/Eruption/power=59/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "676/Eruption/power=59/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "677/Eruption/power=59/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "678/Eruption/power=59/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "679/Eruption/power=59/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "680/Eruption/power=59/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "681/Eruption/power=59/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "682/Eruption/power=59/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "683/Eruption/power=59/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "684/Eruption/power=59/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "685/Eruption/power=59/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "686/Eruption/power=59/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "687/Eruption/power=59/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "688/Eruption/power=59/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "689/Eruption/power=59/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "690/Eruption/power=59/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "691/Eruption/power=59/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "692/Eruption/power=59/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "693/Eruption/power=59/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "694/Eruption/power=59/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "695/Eruption/power=59/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "696/Eruption/power=59/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceEruptionCasesPart5(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "697/Eruption/power=59/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "698/Eruption/power=59/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "699/Eruption/power=59/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "700/Eruption/power=59/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "701/Eruption/power=59/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "702/Eruption/power=59/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "703/Eruption/power=59/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "704/Eruption/power=59/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "705/Eruption/power=60/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "706/Eruption/power=60/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "707/Eruption/power=60/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "708/Eruption/power=60/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "709/Eruption/power=60/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "710/Eruption/power=60/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "711/Eruption/power=60/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "712/Eruption/power=60/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "713/Eruption/power=60/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "714/Eruption/power=60/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "715/Eruption/power=60/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "716/Eruption/power=60/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "717/Eruption/power=60/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "718/Eruption/power=60/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "719/Eruption/power=60/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "720/Eruption/power=60/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "721/Eruption/power=60/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "722/Eruption/power=60/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "723/Eruption/power=60/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "724/Eruption/power=60/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "725/Eruption/power=60/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "726/Eruption/power=60/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceEruptionCasesPart6(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "727/Eruption/power=60/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "728/Eruption/power=60/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "729/Eruption/power=60/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "730/Eruption/power=60/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "731/Eruption/power=60/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "732/Eruption/power=60/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "733/Eruption/power=60/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "734/Eruption/power=60/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "735/Eruption/power=60/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "736/Eruption/power=60/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "737/Eruption/power=61/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "738/Eruption/power=61/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "739/Eruption/power=61/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "740/Eruption/power=61/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "741/Eruption/power=61/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "742/Eruption/power=61/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "743/Eruption/power=61/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "744/Eruption/power=61/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "745/Eruption/power=61/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "746/Eruption/power=61/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "747/Eruption/power=61/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "748/Eruption/power=61/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "749/Eruption/power=61/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "750/Eruption/power=61/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "751/Eruption/power=61/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "752/Eruption/power=61/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "753/Eruption/power=61/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "754/Eruption/power=61/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "755/Eruption/power=61/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "756/Eruption/power=61/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceEruptionCasesPart7(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "757/Eruption/power=61/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "758/Eruption/power=61/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "759/Eruption/power=61/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "760/Eruption/power=61/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "761/Eruption/power=61/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "762/Eruption/power=61/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "763/Eruption/power=61/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "764/Eruption/power=61/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "765/Eruption/power=61/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "766/Eruption/power=61/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "767/Eruption/power=61/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "768/Eruption/power=61/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("Eruption"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )
