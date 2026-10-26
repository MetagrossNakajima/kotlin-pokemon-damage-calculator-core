package dev.pokemondamage.model

/** Input diagnostics are separate from failures of an otherwise valid calculation. */
enum class ValidationCode {
    REQUIRED,
    OUT_OF_RANGE,
    UNKNOWN_VALUE,
    DUPLICATE,
    INCONSISTENT,
}

data class ValidationError(val path: String, val code: ValidationCode)

/** Parses Kotlin enum names without throwing for unknown input. Names are case-sensitive. */
fun <E : Enum<E>> validateEnum(value: String, entries: kotlin.enums.EnumEntries<E>): Validation<E> {
    for (entry in entries) {
        if (entry.name == value) return Validation.Valid(entry)
    }
    return Validation.Invalid(listOf(ValidationError("value", ValidationCode.UNKNOWN_VALUE)))
}

sealed interface Validation<out T> {
    data class Valid<T>(val value: T) : Validation<T>

    class Invalid(errors: List<ValidationError>) : Validation<Nothing> {
        val errors: List<ValidationError> = java.util.List.copyOf(errors)

        init {
            require(this.errors.isNotEmpty()) { "validation errors must not be empty" }
        }
    }
}

/**
 * Direct construction still rejects invalid input; callers may use [validate] to inspect errors.
 */
class InputValidationException internal constructor(val failure: Validation.Invalid) :
    IllegalArgumentException(failure.errors.joinToString { "${it.path}: ${it.code}" })

/** Captures model validation only. Programming errors and unrelated exceptions propagate. */
fun <T> validate(path: String = "", build: () -> T): Validation<T> =
    try {
        Validation.Valid(build())
    } catch (error: InputValidationException) {
        if (path.isEmpty()) error.failure
        else
            Validation.Invalid(
                error.failure.errors.map {
                    it.copy(path = "$path.${it.path}")
                },
            )
    }

/** Combines independently validated inputs, retaining errors from both in input order. */
fun <A, B, R> Validation<A>.zip(other: Validation<B>, build: (A, B) -> R): Validation<R> =
    when (this) {
        is Validation.Valid ->
            when (other) {
                is Validation.Valid -> validate { build(value, other.value) }
                is Validation.Invalid -> other
            }
        is Validation.Invalid ->
            when (other) {
                is Validation.Valid -> this
                is Validation.Invalid -> Validation.Invalid(errors + other.errors)
            }
    }
