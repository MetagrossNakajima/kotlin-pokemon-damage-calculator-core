package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats

// Fixed reference expectations for RanksBodyPress. See StatReferenceCases for provenance.
internal fun statReferenceRanksBodyPressCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceRanksBodyPressCasesPart1())
    }

private fun statReferenceRanksBodyPressCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "ranks/Body Press/-6/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 25,
            expectedDefense = 25,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/-6/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 404,
            expectedDefense = 25,
            expectedDamage =
                listOf(
                    363,
                    367,
                    371,
                    375,
                    380,
                    384,
                    388,
                    393,
                    397,
                    401,
                    405,
                    410,
                    414,
                    418,
                    423,
                    427,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/-6/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 25,
            expectedDamage =
                listOf(
                    137,
                    138,
                    140,
                    142,
                    144,
                    145,
                    147,
                    148,
                    150,
                    152,
                    153,
                    155,
                    156,
                    158,
                    159,
                    162,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/-6/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 404,
            expectedDefense = 25,
            expectedDamage =
                listOf(
                    544,
                    551,
                    557,
                    564,
                    570,
                    576,
                    583,
                    589,
                    596,
                    602,
                    609,
                    615,
                    621,
                    627,
                    634,
                    641,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/-1/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 67,
            expectedDefense = 67,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/-1/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 151,
            expectedDefense = 67,
            expectedDamage = listOf(51, 51, 52, 53, 54, 54, 54, 55, 56, 57, 57, 57, 58, 59, 60, 60),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/-1/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 67,
            expectedDamage = listOf(51, 52, 53, 54, 54, 54, 55, 56, 57, 57, 57, 58, 59, 60, 60, 61),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/-1/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 151,
            expectedDefense = 67,
            expectedDamage = listOf(76, 78, 78, 79, 80, 81, 82, 83, 84, 84, 85, 87, 87, 88, 89, 90),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/0/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/0/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/0/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 39, 39, 39, 39, 40, 41),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/0/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 39, 39, 39, 39, 40, 41),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/1/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 151,
            expectedDefense = 151,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/1/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 67,
            expectedDefense = 151,
            expectedDamage = listOf(10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/1/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 151,
            expectedDefense = 101,
            expectedDamage = listOf(51, 51, 52, 53, 54, 54, 54, 55, 56, 57, 57, 57, 58, 59, 60, 60),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/1/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 39, 39, 39, 39, 40, 41),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/6/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 404,
            expectedDefense = 404,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/6/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 25,
            expectedDefense = 404,
            expectedDamage = listOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/6/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 404,
            expectedDefense = 101,
            expectedDamage =
                listOf(
                    135,
                    137,
                    138,
                    140,
                    141,
                    143,
                    144,
                    146,
                    148,
                    150,
                    151,
                    153,
                    154,
                    156,
                    157,
                    159,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Body Press/6/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("BodyPress"),
                    PokemonType.NORMAL,
                    80,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 39, 39, 39, 39, 40, 41),
            controlRole = null,
            expectedControlDamage = null,
        ),
    )
