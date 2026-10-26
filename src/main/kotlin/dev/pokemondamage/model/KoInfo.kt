package dev.pokemondamage.model

enum class KoStatus {
    RESOLVED,
    LIMIT_REACHED,
    NOT_APPLICABLE,
}

enum class KoCategory {
    ALREADY_KNOCKED_OUT,
    ONE_HIT,
    TWO_HITS,
    THREE_HITS,
    FOUR_HITS,
    FIVE_OR_MORE,
    UNDETERMINED,
    NOT_APPLICABLE,
}

/** 命中数ではなく攻撃の使用回数を数える。指定された攻撃で必ず相手を倒せるとは限らない。 */
data class KoInfo(
    val status: KoStatus,
    val evaluatedAttacks: Int,
    val possibleHits: Int? = null,
    val guaranteedHits: Int? = null,
) {
    val category: KoCategory
        get() =
            when {
                status == KoStatus.NOT_APPLICABLE -> {
                    KoCategory.NOT_APPLICABLE
                }

                guaranteedHits == null -> {
                    if (evaluatedAttacks >= 4) KoCategory.FIVE_OR_MORE else KoCategory.UNDETERMINED
                }

                else -> {
                    when (guaranteedHits) {
                        0 -> KoCategory.ALREADY_KNOCKED_OUT
                        1 -> KoCategory.ONE_HIT
                        2 -> KoCategory.TWO_HITS
                        3 -> KoCategory.THREE_HITS
                        4 -> KoCategory.FOUR_HITS
                        else -> KoCategory.FIVE_OR_MORE
                    }
                }
            }
}
