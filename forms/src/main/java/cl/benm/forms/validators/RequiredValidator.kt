package cl.benm.forms.validators

import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator

class RequiredValidator<T>(
    private val message: String = "Field must not be null"
): Validator<T> {

    override fun validate(input: T?): ValidationResult {
        return when (input) {
            null -> ValidationResult.Invalid(message)
            else -> ValidationResult.Valid
        }
    }
}