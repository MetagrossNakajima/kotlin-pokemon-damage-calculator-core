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

// Fixed reference expectations for AttackRockyPayload. See StatReferenceCases for provenance.
internal fun statReferenceAttackRockyPayloadCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceAttackRockyPayloadCasesPart1())
    }

private fun statReferenceAttackRockyPayloadCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/101/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 227,
            expectedDefense = 101,
            expectedDamage = listOf(17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 170,
            expectedDefense = 101,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/101/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 341,
            expectedDefense = 101,
            expectedDamage = listOf(25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20),
        ),
        StatReferenceCase(
            name =
                "attack/Rocky Payload/Physical/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
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
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 256,
            expectedDefense = 101,
            expectedDamage = listOf(19, 19, 20, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/333/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 749,
            expectedDefense = 333,
            expectedDamage = listOf(17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 562,
            expectedDefense = 333,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/333/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 1124,
            expectedDefense = 333,
            expectedDamage = listOf(25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20),
        ),
        StatReferenceCase(
            name =
                "attack/Rocky Payload/Physical/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
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
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 843,
            expectedDefense = 333,
            expectedDamage = listOf(19, 19, 20, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/999/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 2248,
            expectedDefense = 999,
            expectedDamage = listOf(17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 1686,
            expectedDefense = 999,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Physical/999/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 3372,
            expectedDefense = 999,
            expectedDamage = listOf(25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20),
        ),
        StatReferenceCase(
            name =
                "attack/Rocky Payload/Physical/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
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
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 2529,
            expectedDefense = 999,
            expectedDamage = listOf(19, 19, 20, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/101/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 227,
            expectedDefense = 101,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 170,
            expectedDefense = 101,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/101/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 227,
            expectedDefense = 101,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name =
                "attack/Rocky Payload/Special/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
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
                    MoveId("Tackle"),
                    PokemonType.ROCK,
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
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 170,
            expectedDefense = 101,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/333/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 749,
            expectedDefense = 333,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 562,
            expectedDefense = 333,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/333/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 749,
            expectedDefense = 333,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name =
                "attack/Rocky Payload/Special/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
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
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 562,
            expectedDefense = 333,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/999/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 2248,
            expectedDefense = 999,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 1686,
            expectedDefense = 999,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Rocky Payload/Special/999/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 2248,
            expectedDefense = 999,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        StatReferenceCase(
            name =
                "attack/Rocky Payload/Special/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("RockyPayload"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
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
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.ROCK,
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
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 1686,
            expectedDefense = 999,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20, 20, 21),
        ),
    )
