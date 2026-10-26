package dev.pokemondamage.model

/** Single-constraint counterpart for scalar inputs. */
internal fun requireInput(condition: Boolean, path: String, code: ValidationCode) {
    if (!condition)
        throw InputValidationException(Validation.Invalid(listOf(ValidationError(path, code))))
}

/** Collects independent field constraints before rejecting construction. */
internal class InputChecks {
    private val errors = mutableListOf<ValidationError>()

    fun require(condition: Boolean, path: String, code: ValidationCode) {
        if (!condition) errors += ValidationError(path, code)
    }

    fun finish() {
        if (errors.isNotEmpty()) throw InputValidationException(Validation.Invalid(errors))
    }
}
