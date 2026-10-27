package dev.pokemondamage.model

/** 単一の入力値に対する制約を検証する。 */
internal fun requireInput(
    condition: Boolean,
    path: String,
    code: ValidationCode,
) {
    if (!condition) {
        throw InputValidationException(Validation.Invalid(listOf(ValidationError(path, code))))
    }
}

/** 独立した項目の制約違反を集めてから、生成を拒否する。 */
internal class InputChecks {
    private val errors = mutableListOf<ValidationError>()

    fun require(
        condition: Boolean,
        path: String,
        code: ValidationCode,
    ) {
        if (!condition) {
            errors += ValidationError(path, code)
        }
    }

    fun finish() {
        if (errors.isNotEmpty()) {
            throw InputValidationException(Validation.Invalid(errors))
        }
    }
}
