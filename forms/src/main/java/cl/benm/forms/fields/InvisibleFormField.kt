package cl.benm.forms.fields

import cl.benm.forms.ValidationState
import cl.benm.forms.Validator
import cl.benm.forms.fields.base.BaseFormField
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class InvisibleFormField<T>(
    override val name: String,
    value: T?
): BaseFormField<T>() {

    private val setValue = value

    override val validators: List<Validator<T>> = listOf()
    override var currentValue: T?
        get() = setValue
        set(_) { throw UnsupportedOperationException() }
    override val value: Flow<T?>
        get() = flowOf(setValue)

    init {
        _valid.value = ValidationState.Valid
    }

}