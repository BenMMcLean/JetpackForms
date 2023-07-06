package cl.benm.forms.validators

import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator

class BlankValidator(
    private val message: String = "Field cannot be blank"
): Validator<String> {

    override fun validate(value: String?): ValidationResult {
        return when (value.isNullOrBlank()) {
            false -> ValidationResult.Valid
            true -> ValidationResult.Invalid(message)
        }
    }
}