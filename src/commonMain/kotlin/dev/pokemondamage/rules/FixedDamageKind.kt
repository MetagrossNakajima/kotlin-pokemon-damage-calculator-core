package dev.pokemondamage.rules

/** 入力検証・ダメージ計算・一撃必殺の無効判定で使う共通分類。 */
internal enum class FixedDamageKind {
    HALF_CURRENT_HP,
    THREE_QUARTERS_CURRENT_HP,
    ATTACKER_HP,
    HP_DIFFERENCE,
    TWENTY,
    FORTY,
    LEVEL,
    ONE_HIT_KO,
}
