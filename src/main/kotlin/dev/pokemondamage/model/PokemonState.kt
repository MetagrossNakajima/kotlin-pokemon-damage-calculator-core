package dev.pokemondamage.model

data class PokemonState(
    val profile: PokemonProfile,
    val stats: Stats,
    val stages: StatStages = StatStages(),
    /** Already activated; weather/HP/status activation conditions are not inferred. */
    val ability: AbilityId? = null,
    val item: ItemId? = null,
    val status: Status? = null,
    val sideConditions: SideConditions = SideConditions(),
    val currentHp: Int? = null,
    val toxicCounter: Int? = null,
    val itemConsumed: Boolean = false,
    val cudChewTurn: Long? = null,
    val teraType: TeraType? = null,
    val boostedStat: Stat? = null,
    val faintedAllies: Int = 0,
    val timesHit: Int = 0,
    val flags: PokemonFlags = PokemonFlags(),
) {
    init {
        val checks = InputChecks()
        if (currentHp != null) {
            checks.require(currentHp in 1..999, "currentHp", ValidationCode.OUT_OF_RANGE)
            if (currentHp in 1..999) {
                checks.require(currentHp <= stats.hp, "currentHp", ValidationCode.INCONSISTENT)
            }
        }
        checks.require(
            toxicCounter == null || toxicCounter in 1..15,
            "toxicCounter",
            ValidationCode.OUT_OF_RANGE,
        )
        checks.require(
            (status == Status.TOXIC) == (toxicCounter != null),
            "toxicCounter",
            ValidationCode.INCONSISTENT,
        )
        checks.require(boostedStat != Stat.HP, "boostedStat", ValidationCode.INCONSISTENT)
        checks.require(faintedAllies in 0..100, "faintedAllies", ValidationCode.OUT_OF_RANGE)
        checks.require(timesHit in 0..100, "timesHit", ValidationCode.OUT_OF_RANGE)
        checks.finish()
    }

    val hp: Int
        get() = currentHp ?: stats.hp
}
