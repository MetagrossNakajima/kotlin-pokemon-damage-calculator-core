package dev.pokemondamage.model

/** Input validity is enforced by constructors; calculation failures are explicit values. */
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
