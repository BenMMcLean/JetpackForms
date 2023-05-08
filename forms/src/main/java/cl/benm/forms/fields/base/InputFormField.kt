package cl.benm.forms.fields.base

import kotlinx.coroutines.runBlocking

abstract class InputFormField<T>: BaseFormField<T>() {

    override var currentValue: T? = null
        set(value) {
            field = value
            writableValue.value = value
            runBlocking { validate(false) }
        }

}