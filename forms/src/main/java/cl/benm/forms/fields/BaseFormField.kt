package cl.benm.forms.fields

import cl.benm.forms.ErrorState
import cl.benm.forms.FormField
import kotlinx.coroutines.flow.Flow

class BaseFormField<T>: FormField<T> {

    override val value: Flow<T>
        get() = TODO("Not yet implemented")
    override var currentValue: T?
        get() = TODO("Not yet implemented")
        set(value) {}
    override val error: Flow<ErrorState>
        get() = TODO("Not yet implemented")

    override fun validate(silent: Boolean): Boolean {
        TODO("Not yet implemented")
    }



}