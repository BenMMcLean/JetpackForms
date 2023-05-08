package cl.benm.forms.validators

import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator

class CheckedValidator(
    private val message: String = "Field must be checked",
    private val requiredState: Boolean = true
): Validator<Boolean> {

    override fun validate(value: Boolean?): ValidationResult {
        return when (value == requiredState) {
            true -> ValidationResult.Valid
            false -> ValidationResult.Invalid(message)
        }
    }

}