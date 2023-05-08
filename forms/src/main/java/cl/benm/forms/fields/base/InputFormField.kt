package cl.benm.forms.fields.base

import kotlinx.coroutines.runBlocking

abstract class InputFormField<T>: BaseFormField<T>() {

    override var currentValue: T? = null
        set(value) {
            field = value
            _value.value = value
            runBlocking { validate(false) }
        }

}