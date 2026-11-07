package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.TeraType

// Fixed reference expectations for DoubleKick. See TeraPowerReferenceCases for provenance.
internal fun teraPowerReferenceDoubleKickCases(): List<TeraPowerReferenceCase> =
    buildList {
        addAll(teraPowerReferenceDoubleKickCasesPart1())
        addAll(teraPowerReferenceDoubleKickCasesPart2())
        addAll(teraPowerReferenceDoubleKickCasesPart3())
        addAll(teraPowerReferenceDoubleKickCasesPart4())
        addAll(teraPowerReferenceDoubleKickCasesPart5())
        addAll(teraPowerReferenceDoubleKickCasesPart6())
        addAll(teraPowerReferenceDoubleKickCasesPart7())
    }

private fun teraPowerReferenceDoubleKickCasesPart1(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "385/DoubleKick/power=1/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "386/DoubleKick/power=1/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "387/DoubleKick/power=1/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "388/DoubleKick/power=1/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "389/DoubleKick/power=1/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "390/DoubleKick/power=1/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "391/DoubleKick/power=1/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "392/DoubleKick/power=1/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "393/DoubleKick/power=1/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "394/DoubleKick/power=1/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "395/DoubleKick/power=1/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "396/DoubleKick/power=1/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "397/DoubleKick/power=1/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "398/DoubleKick/power=1/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "399/DoubleKick/power=1/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "400/DoubleKick/power=1/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "401/DoubleKick/power=1/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "402/DoubleKick/power=1/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "403/DoubleKick/power=1/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "404/DoubleKick/power=1/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "405/DoubleKick/power=1/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "406/DoubleKick/power=1/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "407/DoubleKick/power=1/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "408/DoubleKick/power=1/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "409/DoubleKick/power=1/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "410/DoubleKick/power=1/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "411/DoubleKick/power=1/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "412/DoubleKick/power=1/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "413/DoubleKick/power=1/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "414/DoubleKick/power=1/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
    )

private fun teraPowerReferenceDoubleKickCasesPart2(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "415/DoubleKick/power=1/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "416/DoubleKick/power=1/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 1, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 1,
        ),
        TeraPowerReferenceCase(
            name = "417/DoubleKick/power=39/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "418/DoubleKick/power=39/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "419/DoubleKick/power=39/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "420/DoubleKick/power=39/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "421/DoubleKick/power=39/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "422/DoubleKick/power=39/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "423/DoubleKick/power=39/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "424/DoubleKick/power=39/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "425/DoubleKick/power=39/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "426/DoubleKick/power=39/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "427/DoubleKick/power=39/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "428/DoubleKick/power=39/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "429/DoubleKick/power=39/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "430/DoubleKick/power=39/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "431/DoubleKick/power=39/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "432/DoubleKick/power=39/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "433/DoubleKick/power=39/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "434/DoubleKick/power=39/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "435/DoubleKick/power=39/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "436/DoubleKick/power=39/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "437/DoubleKick/power=39/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "438/DoubleKick/power=39/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "439/DoubleKick/power=39/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "440/DoubleKick/power=39/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "441/DoubleKick/power=39/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "442/DoubleKick/power=39/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "443/DoubleKick/power=39/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "444/DoubleKick/power=39/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
    )

private fun teraPowerReferenceDoubleKickCasesPart3(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "445/DoubleKick/power=39/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "446/DoubleKick/power=39/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "447/DoubleKick/power=39/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 39,
        ),
        TeraPowerReferenceCase(
            name = "448/DoubleKick/power=39/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 39, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 58,
        ),
        TeraPowerReferenceCase(
            name = "449/DoubleKick/power=40/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "450/DoubleKick/power=40/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "451/DoubleKick/power=40/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "452/DoubleKick/power=40/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "453/DoubleKick/power=40/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "454/DoubleKick/power=40/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "455/DoubleKick/power=40/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "456/DoubleKick/power=40/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "457/DoubleKick/power=40/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "458/DoubleKick/power=40/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "459/DoubleKick/power=40/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "460/DoubleKick/power=40/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "461/DoubleKick/power=40/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "462/DoubleKick/power=40/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "463/DoubleKick/power=40/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "464/DoubleKick/power=40/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "465/DoubleKick/power=40/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "466/DoubleKick/power=40/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "467/DoubleKick/power=40/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "468/DoubleKick/power=40/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "469/DoubleKick/power=40/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "470/DoubleKick/power=40/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "471/DoubleKick/power=40/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "472/DoubleKick/power=40/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "473/DoubleKick/power=40/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "474/DoubleKick/power=40/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
    )

private fun teraPowerReferenceDoubleKickCasesPart4(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "475/DoubleKick/power=40/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "476/DoubleKick/power=40/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "477/DoubleKick/power=40/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "478/DoubleKick/power=40/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "479/DoubleKick/power=40/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 40,
        ),
        TeraPowerReferenceCase(
            name = "480/DoubleKick/power=40/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 40, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "481/DoubleKick/power=59/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "482/DoubleKick/power=59/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "483/DoubleKick/power=59/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "484/DoubleKick/power=59/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "485/DoubleKick/power=59/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "486/DoubleKick/power=59/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "487/DoubleKick/power=59/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "488/DoubleKick/power=59/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "489/DoubleKick/power=59/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "490/DoubleKick/power=59/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "491/DoubleKick/power=59/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "492/DoubleKick/power=59/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "493/DoubleKick/power=59/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "494/DoubleKick/power=59/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "495/DoubleKick/power=59/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "496/DoubleKick/power=59/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "497/DoubleKick/power=59/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "498/DoubleKick/power=59/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "499/DoubleKick/power=59/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "500/DoubleKick/power=59/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "501/DoubleKick/power=59/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "502/DoubleKick/power=59/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "503/DoubleKick/power=59/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "504/DoubleKick/power=59/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
    )

private fun teraPowerReferenceDoubleKickCasesPart5(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "505/DoubleKick/power=59/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "506/DoubleKick/power=59/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "507/DoubleKick/power=59/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "508/DoubleKick/power=59/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "509/DoubleKick/power=59/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "510/DoubleKick/power=59/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "511/DoubleKick/power=59/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 59,
        ),
        TeraPowerReferenceCase(
            name = "512/DoubleKick/power=59/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 59, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 88,
        ),
        TeraPowerReferenceCase(
            name = "513/DoubleKick/power=60/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "514/DoubleKick/power=60/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "515/DoubleKick/power=60/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "516/DoubleKick/power=60/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "517/DoubleKick/power=60/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "518/DoubleKick/power=60/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "519/DoubleKick/power=60/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "520/DoubleKick/power=60/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "521/DoubleKick/power=60/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "522/DoubleKick/power=60/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "523/DoubleKick/power=60/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "524/DoubleKick/power=60/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "525/DoubleKick/power=60/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "526/DoubleKick/power=60/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "527/DoubleKick/power=60/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "528/DoubleKick/power=60/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "529/DoubleKick/power=60/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "530/DoubleKick/power=60/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "531/DoubleKick/power=60/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "532/DoubleKick/power=60/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "533/DoubleKick/power=60/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "534/DoubleKick/power=60/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
    )

private fun teraPowerReferenceDoubleKickCasesPart6(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "535/DoubleKick/power=60/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "536/DoubleKick/power=60/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "537/DoubleKick/power=60/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "538/DoubleKick/power=60/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "539/DoubleKick/power=60/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "540/DoubleKick/power=60/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "541/DoubleKick/power=60/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "542/DoubleKick/power=60/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "543/DoubleKick/power=60/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 60,
        ),
        TeraPowerReferenceCase(
            name = "544/DoubleKick/power=60/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 60, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 90,
        ),
        TeraPowerReferenceCase(
            name = "545/DoubleKick/power=61/tera=none/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "546/DoubleKick/power=61/tera=none/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "547/DoubleKick/power=61/tera=none/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "548/DoubleKick/power=61/tera=none/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "549/DoubleKick/power=61/tera=none/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "550/DoubleKick/power=61/tera=none/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "551/DoubleKick/power=61/tera=none/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "552/DoubleKick/power=61/tera=none/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = null,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "553/DoubleKick/power=61/tera=NORMAL/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "554/DoubleKick/power=61/tera=NORMAL/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "555/DoubleKick/power=61/tera=NORMAL/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "556/DoubleKick/power=61/tera=NORMAL/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "557/DoubleKick/power=61/tera=NORMAL/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "558/DoubleKick/power=61/tera=NORMAL/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "559/DoubleKick/power=61/tera=NORMAL/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "560/DoubleKick/power=61/tera=NORMAL/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.NORMAL,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "561/DoubleKick/power=61/tera=WATER/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "562/DoubleKick/power=61/tera=WATER/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "563/DoubleKick/power=61/tera=WATER/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "564/DoubleKick/power=61/tera=WATER/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
    )

private fun teraPowerReferenceDoubleKickCasesPart7(): List<TeraPowerReferenceCase> =
    listOf(
        TeraPowerReferenceCase(
            name = "565/DoubleKick/power=61/tera=WATER/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "566/DoubleKick/power=61/tera=WATER/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "567/DoubleKick/power=61/tera=WATER/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "568/DoubleKick/power=61/tera=WATER/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.WATER,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "569/DoubleKick/power=61/tera=STELLAR/available=false/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "570/DoubleKick/power=61/tera=STELLAR/available=false/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "571/DoubleKick/power=61/tera=STELLAR/available=false/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "572/DoubleKick/power=61/tera=STELLAR/available=false/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = false,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "573/DoubleKick/power=61/tera=STELLAR/available=true/hp=1/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "574/DoubleKick/power=61/tera=STELLAR/available=true/hp=1/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 1,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "575/DoubleKick/power=61/tera=STELLAR/available=true/hp=200/Illuminate",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Illuminate"),
            expectedPower = 61,
        ),
        TeraPowerReferenceCase(
            name = "576/DoubleKick/power=61/tera=STELLAR/available=true/hp=200/Technician",
            move =
                Move(MoveId("DoubleKick"), PokemonType.NORMAL, 61, Category.PHYSICAL, priority = 0),
            teraType = TeraType.STELLAR,
            boostAvailable = true,
            hp = 200,
            ability = AbilityId("Technician"),
            expectedPower = 61,
        ),
    )
