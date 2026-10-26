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
    val toxicCounter: ToxicCounter? = null,
    val itemConsumed: Boolean = false,
    val cudChewTurn: Long? = null,
    val teraType: TeraType? = null,
    val boostedStat: Stat? = null,
    val faintedAllies: FaintedAllies = FaintedAllies.NONE,
    val timesHit: TimesHit = TimesHit.NONE,
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
            (status == Status.TOXIC) == (toxicCounter != null),
            "toxicCounter",
            ValidationCode.INCONSISTENT,
        )
        checks.require(boostedStat != Stat.HP, "boostedStat", ValidationCode.INCONSISTENT)
        checks.finish()
    }

    val hp: Int
        get() = currentHp ?: stats.hp
}
