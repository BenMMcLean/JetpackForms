package cl.benm.forms

interface Validator<in T> {

    fun validate(input: T): ValidationResult

}

sealed interface ValidationResult {

    object Valid: ValidationResult
    class Invalid(
        val message: String?
    ): ValidationResult

}