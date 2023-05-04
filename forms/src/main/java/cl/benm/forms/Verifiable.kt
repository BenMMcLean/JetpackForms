package cl.benm.forms

import kotlinx.coroutines.flow.Flow

interface Verifiable {

    val valid: Flow<ValidationState>
    suspend fun validate(silent: Boolean = false)

}

sealed interface ValidationState {
    object Valid: ValidationState
    class Invalid(
        val message: String?
    ): ValidationState
}