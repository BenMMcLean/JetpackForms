package cl.benm.forms.validators

import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator

class ABNValidator(
    private val message: String = "Invalid ABN"
): Validator<String> {

    companion object {
        val digitWeighting = arrayOf(10, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19)
    }

    override fun validate(value: String?): ValidationResult {
        if (value.isNullOrBlank()) return ValidationResult.Valid
        val test = value.filterNot { it.isWhitespace() }
        if (test.length != 11) return ValidationResult.Invalid(message)
        if (test.any { !it.isDigit() }) return ValidationResult.Invalid(message)

        val digits = test.toCharArray().map { it.digitToInt() }.toMutableList()
        digits[0]--
        val valid = List(digits.size) { index ->
            digits[index] * digitWeighting[index]
        }.sum() % 89 == 0

        return when (valid) {
            true -> ValidationResult.Valid
            false -> ValidationResult.Invalid(message)
        }
    }
}