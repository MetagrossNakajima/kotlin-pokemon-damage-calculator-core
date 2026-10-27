package dev.pokemondamage.model

/** 入力の妥当性はコンストラクタで保証し、計算の失敗は値として返す。 */
sealed interface Calculation<out T> {
    data class Success<T>(
        val value: T,
    ) : Calculation<T>

    data class Failure(
        val kind: FailureKind,
        val path: String,
    ) : Calculation<Nothing>
}

enum class FailureKind {
    UNSUPPORTED,
    COMPLEXITY_EXCEEDED,
}
