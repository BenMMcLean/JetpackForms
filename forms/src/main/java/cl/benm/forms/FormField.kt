package cl.benm.forms

import kotlinx.coroutines.flow.Flow

interface FormField<T> {

    val value: Flow<T>
    var currentValue: T?

    val valid: Flow<ErrorState>

    fun validate(silent: Boolean = false): Boolean

}