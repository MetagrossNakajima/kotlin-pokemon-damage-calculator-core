package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.TeraType

// Fixed reference expectations for WaterSpout. See TeraPowerReferenceCases for provenance.
internal fun teraPowerReferenceWaterSpoutCases(): List<TeraPowerReferenceCase> =
    buildList {
        addAll(teraPowerReferenceWaterSpoutCasesPart1())
        addAll(teraPowerReferenceWaterSpoutCasesPart2())
        addAll(teraPowerReferenceWaterSpoutCasesPart3())
        addAll(teraPowerReferenceWaterSpoutCasesPart4())
        addAll(teraPowerReferenceWaterSpoutCasesPart5())
        addAll(teraPowerReferenceWaterSpoutCasesPart6())
        addAll(teraPowerReferenceWaterSpoutCasesPart7())
    }

private fun teraPowerReferenceWaterSpoutCasesPart1(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "769/WaterSpout/power=1/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "770/WaterSpout/power=1/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "771/WaterSpout/power=1/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "772/WaterSpout/power=1/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "773/WaterSpout/power=1/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "774/WaterSpout/power=1/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "775/WaterSpout/power=1/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "776/WaterSpout/power=1/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "777/WaterSpout/power=1/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "778/WaterSpout/power=1/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "779/WaterSpout/power=1/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "780/WaterSpout/power=1/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "781/WaterSpout/power=1/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "782/WaterSpout/power=1/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "783/WaterSpout/power=1/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "784/WaterSpout/power=1/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "785/WaterSpout/power=1/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "786/WaterSpout/power=1/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "787/WaterSpout/power=1/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "788/WaterSpout/power=1/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "789/WaterSpout/power=1/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "790/WaterSpout/power=1/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "791/WaterSpout/power=1/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "792/WaterSpout/power=1/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "793/WaterSpout/power=1/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "794/WaterSpout/power=1/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "795/WaterSpout/power=1/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "796/WaterSpout/power=1/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "797/WaterSpout/power=1/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "798/WaterSpout/power=1/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceWaterSpoutCasesPart2(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "799/WaterSpout/power=1/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "800/WaterSpout/power=1/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "801/WaterSpout/power=39/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "802/WaterSpout/power=39/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "803/WaterSpout/power=39/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "804/WaterSpout/power=39/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "805/WaterSpout/power=39/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "806/WaterSpout/power=39/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "807/WaterSpout/power=39/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "808/WaterSpout/power=39/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "809/WaterSpout/power=39/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "810/WaterSpout/power=39/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "811/WaterSpout/power=39/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "812/WaterSpout/power=39/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "813/WaterSpout/power=39/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "814/WaterSpout/power=39/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "815/WaterSpout/power=39/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "816/WaterSpout/power=39/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "817/WaterSpout/power=39/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "818/WaterSpout/power=39/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "819/WaterSpout/power=39/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "820/WaterSpout/power=39/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "821/WaterSpout/power=39/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "822/WaterSpout/power=39/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "823/WaterSpout/power=39/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "824/WaterSpout/power=39/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "825/WaterSpout/power=39/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "826/WaterSpout/power=39/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "827/WaterSpout/power=39/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "828/WaterSpout/power=39/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceWaterSpoutCasesPart3(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "829/WaterSpout/power=39/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "830/WaterSpout/power=39/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "831/WaterSpout/power=39/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "832/WaterSpout/power=39/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "833/WaterSpout/power=40/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "834/WaterSpout/power=40/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "835/WaterSpout/power=40/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "836/WaterSpout/power=40/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "837/WaterSpout/power=40/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "838/WaterSpout/power=40/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "839/WaterSpout/power=40/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "840/WaterSpout/power=40/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "841/WaterSpout/power=40/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "842/WaterSpout/power=40/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "843/WaterSpout/power=40/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "844/WaterSpout/power=40/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "845/WaterSpout/power=40/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "846/WaterSpout/power=40/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "847/WaterSpout/power=40/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "848/WaterSpout/power=40/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "849/WaterSpout/power=40/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "850/WaterSpout/power=40/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "851/WaterSpout/power=40/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "852/WaterSpout/power=40/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "853/WaterSpout/power=40/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "854/WaterSpout/power=40/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "855/WaterSpout/power=40/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "856/WaterSpout/power=40/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "857/WaterSpout/power=40/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "858/WaterSpout/power=40/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceWaterSpoutCasesPart4(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "859/WaterSpout/power=40/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "860/WaterSpout/power=40/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "861/WaterSpout/power=40/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "862/WaterSpout/power=40/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "863/WaterSpout/power=40/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "864/WaterSpout/power=40/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "865/WaterSpout/power=59/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "866/WaterSpout/power=59/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "867/WaterSpout/power=59/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "868/WaterSpout/power=59/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "869/WaterSpout/power=59/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "870/WaterSpout/power=59/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "871/WaterSpout/power=59/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "872/WaterSpout/power=59/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "873/WaterSpout/power=59/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "874/WaterSpout/power=59/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "875/WaterSpout/power=59/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "876/WaterSpout/power=59/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "877/WaterSpout/power=59/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "878/WaterSpout/power=59/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "879/WaterSpout/power=59/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "880/WaterSpout/power=59/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "881/WaterSpout/power=59/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "882/WaterSpout/power=59/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "883/WaterSpout/power=59/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "884/WaterSpout/power=59/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "885/WaterSpout/power=59/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "886/WaterSpout/power=59/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "887/WaterSpout/power=59/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "888/WaterSpout/power=59/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceWaterSpoutCasesPart5(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "889/WaterSpout/power=59/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "890/WaterSpout/power=59/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "891/WaterSpout/power=59/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "892/WaterSpout/power=59/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "893/WaterSpout/power=59/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "894/WaterSpout/power=59/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "895/WaterSpout/power=59/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "896/WaterSpout/power=59/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "897/WaterSpout/power=60/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "898/WaterSpout/power=60/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "899/WaterSpout/power=60/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "900/WaterSpout/power=60/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "901/WaterSpout/power=60/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "902/WaterSpout/power=60/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "903/WaterSpout/power=60/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "904/WaterSpout/power=60/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "905/WaterSpout/power=60/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "906/WaterSpout/power=60/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "907/WaterSpout/power=60/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "908/WaterSpout/power=60/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "909/WaterSpout/power=60/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "910/WaterSpout/power=60/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "911/WaterSpout/power=60/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "912/WaterSpout/power=60/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "913/WaterSpout/power=60/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "914/WaterSpout/power=60/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "915/WaterSpout/power=60/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "916/WaterSpout/power=60/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "917/WaterSpout/power=60/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "918/WaterSpout/power=60/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceWaterSpoutCasesPart6(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "919/WaterSpout/power=60/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "920/WaterSpout/power=60/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "921/WaterSpout/power=60/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "922/WaterSpout/power=60/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "923/WaterSpout/power=60/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "924/WaterSpout/power=60/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "925/WaterSpout/power=60/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "926/WaterSpout/power=60/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "927/WaterSpout/power=60/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "928/WaterSpout/power=60/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "929/WaterSpout/power=61/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "930/WaterSpout/power=61/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "931/WaterSpout/power=61/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "932/WaterSpout/power=61/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "933/WaterSpout/power=61/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "934/WaterSpout/power=61/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "935/WaterSpout/power=61/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "936/WaterSpout/power=61/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "937/WaterSpout/power=61/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "938/WaterSpout/power=61/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "939/WaterSpout/power=61/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "940/WaterSpout/power=61/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "941/WaterSpout/power=61/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "942/WaterSpout/power=61/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "943/WaterSpout/power=61/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "944/WaterSpout/power=61/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "945/WaterSpout/power=61/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "946/WaterSpout/power=61/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "947/WaterSpout/power=61/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "948/WaterSpout/power=61/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )

private fun teraPowerReferenceWaterSpoutCasesPart7(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "949/WaterSpout/power=61/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "950/WaterSpout/power=61/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "951/WaterSpout/power=61/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "952/WaterSpout/power=61/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "953/WaterSpout/power=61/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "954/WaterSpout/power=61/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "955/WaterSpout/power=61/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "956/WaterSpout/power=61/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "957/WaterSpout/power=61/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "958/WaterSpout/power=61/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "959/WaterSpout/power=61/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 150,
        ),
        TeraPowerReferenceCase(
            name = "960/WaterSpout/power=61/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("WaterSpout"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 150,
        ),
    )
