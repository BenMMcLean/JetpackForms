package cl.benm.forms.validators

import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator
import java.util.*

class DatePeriodValidator(
    private val message: String,
    private val maximum: Date? = null,
    private val minimum: Date? = null
): Validator<Date> {

    init {
        if (maximum == null && minimum == null)
            throw java.lang.IllegalArgumentException("Must provide either a minimum and/or a maximum date")
    }

    override fun validate(value: Date?): ValidationResult {
        if (value == null) return ValidationResult.Valid
        if (minimum != null && value < minimum) return ValidationResult.Invalid(message)
        if (maximum != null && value >= maximum) return ValidationResult.Invalid(message)
        return ValidationResult.Valid
    }
}