package cl.benm.forms

import kotlinx.coroutines.flow.Flow

interface FormField<T>: Verifiable {

    val value: Flow<T?>
    var currentValue: T?


}