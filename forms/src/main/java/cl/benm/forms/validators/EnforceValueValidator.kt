package cl.benm.forms.validators

import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator

class EnforceValueValidator<T>(
    private val message: String,
    private val requiredValue: T
): Validator<T> {

    override fun validate(value: T?): ValidationResult {
        if (value == requiredValue) return ValidationResult.Valid
        return ValidationResult.Invalid(message)
    }

}