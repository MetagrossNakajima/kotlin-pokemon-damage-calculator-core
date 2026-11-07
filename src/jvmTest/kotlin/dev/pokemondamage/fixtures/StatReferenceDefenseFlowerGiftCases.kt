package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Weather

// Fixed reference expectations for DefenseFlowerGift. See StatReferenceCases for provenance.
internal fun statReferenceDefenseFlowerGiftCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceDefenseFlowerGiftCasesPart1())
    }

private fun statReferenceDefenseFlowerGiftCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/101/",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = Weather.SUNLIGHT, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/101/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 76,
            expectedDamage = listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/101/DEFENDER_FLOWER_GIFT",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name =
                "defense/Flower Gift/Normal/Physical/101/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 76,
            expectedDamage = listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/333/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = Weather.SUNLIGHT, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 333,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/333/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 250,
            expectedDamage = listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/333/DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 333,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name =
                "defense/Flower Gift/Normal/Physical/333/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 250,
            expectedDamage = listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/999/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = Weather.SUNLIGHT, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 999,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/999/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 749,
            expectedDamage = listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Physical/999/DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 999,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name =
                "defense/Flower Gift/Normal/Physical/999/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 749,
            expectedDamage = listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 18),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/101/",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = Weather.SUNLIGHT, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 151,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/101/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 114,
            expectedDamage = listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(31, 31, 31, 33, 33, 33, 33, 34, 34, 34, 34, 36, 36, 36, 36, 37),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/101/DEFENDER_FLOWER_GIFT",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 151,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
        ),
        StatReferenceCase(
            name =
                "defense/Flower Gift/Normal/Special/101/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 114,
            expectedDamage = listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/333/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = Weather.SUNLIGHT, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 499,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/333/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 375,
            expectedDamage = listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(31, 31, 31, 33, 33, 33, 33, 34, 34, 34, 34, 36, 36, 36, 36, 37),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/333/DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 499,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
        ),
        StatReferenceCase(
            name =
                "defense/Flower Gift/Normal/Special/333/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 375,
            expectedDamage = listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/999/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = Weather.SUNLIGHT, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1498,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/999/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1124,
            expectedDamage = listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(31, 31, 31, 33, 33, 33, 33, 34, 34, 34, 34, 36, 36, 36, 36, 37),
        ),
        StatReferenceCase(
            name = "defense/Flower Gift/Normal/Special/999/DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1498,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
        ),
        StatReferenceCase(
            name =
                "defense/Flower Gift/Normal/Special/999/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Cherrim"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("FlowerGift"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1124,
            expectedDamage = listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
        ),
    )
