package dev.pokemondamage.math

import dev.pokemondamage.model.StatStage

/** バトル用の整数計算。端数処理の順序も計算仕様に含む。 */
internal object BattleMath {
    const val UNIT = 4096

    // 補正の適用は五捨五超入（端数0.5は切り捨て）
    fun modify(
        value: Int,
        numerator: Int,
        denominator: Int = UNIT,
    ): Int = ((value.toLong() * numerator * 2 + denominator - 1) / (denominator * 2L)).toInt()

    // 補正同士の連結は四捨五入（端数0.5は切り上げ）
    fun chain(
        current: Int,
        next: Int,
    ): Int = ((current.toLong() * next + UNIT / 2) / UNIT).toInt()

    fun unsigned16(value: Int): Int = value and 0xffff

    fun unsigned32(value: Long): Long = value and 0xffffffffL

    fun rankedStat(
        value: Int,
        stage: StatStage,
    ): Int =
        if (stage == StatStage.NEUTRAL) {
            value
        } else {
            unsigned16(value * stage.numerator) / stage.denominator
        }

    // レベル50固定の基礎ダメージ
    fun baseDamage(
        power: Int,
        attack: Int,
        defense: Int,
    ): Int = (unsigned32(unsigned32(22L * power) * attack) / defense / 50 + 2).toInt()

    // 積を32ビットに収めてから丸める
    fun modifyDamage(
        damage: Int,
        numerator: Int,
    ): Int = ((unsigned32(damage.toLong() * numerator) * 2 + UNIT - 1) / (UNIT * 2)).toInt()
}
