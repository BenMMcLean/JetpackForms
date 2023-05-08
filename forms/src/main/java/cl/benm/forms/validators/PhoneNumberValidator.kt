package cl.benm.forms.validators

import android.util.Patterns
import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator

class PhoneNumberValidator(
    private val message: String = "Phone number is invalid"
): Validator<String> {

    override fun validate(value: String?): ValidationResult {
        if (value.isNullOrBlank()) return ValidationResult.Valid
        if (!Patterns.PHONE.matcher(value).matches()) return ValidationResult.Invalid(message)
        return ValidationResult.Valid
    }

}