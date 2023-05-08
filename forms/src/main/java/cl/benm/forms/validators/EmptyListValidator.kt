package cl.benm.forms.validators

import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator

class EmptyListValidator<T>(
    private val message: String = "Field is required"
): Validator<List<T>> {

    override fun validate(value: List<T>?): ValidationResult {
        if (value?.isEmpty() != true) return ValidationResult.Valid
        return ValidationResult.Invalid(message)
    }
}