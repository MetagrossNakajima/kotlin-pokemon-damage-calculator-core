package dev.pokemondamage.model

enum class AccuracyMode {
    /** 攻撃全体で1回だけ命中判定する。 */
    ONCE_PER_ATTACK,

    /** 1発ごとに命中判定し、最初に外れた時点で攻撃を終了する。 */
    UNTIL_FIRST_MISS,
}
