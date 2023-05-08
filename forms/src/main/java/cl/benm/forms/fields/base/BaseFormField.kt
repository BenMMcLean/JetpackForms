package cl.benm.forms.fields.base

import cl.benm.forms.FormField
import cl.benm.forms.ValidationResult
import cl.benm.forms.ValidationState
import cl.benm.forms.Validator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseFormField<T>: FormField<T> {

    protected val _value = MutableStateFlow<T?>(null)
    override val value: Flow<T?>
        get() = _value

    protected val _valid = MutableStateFlow<ValidationState>(ValidationState.Valid)
    override val valid: Flow<ValidationState>
        get() = _valid
    abstract val validators: List<Validator<T>>

    override suspend fun validate(silent: Boolean): Boolean {
        val failed = validators.map { it.validate(currentValue) }.filterIsInstance<ValidationResult.Invalid>()
        return if (failed.isEmpty()) {
            _valid.value = ValidationState.Valid
            true
        } else {
            if (!silent || _valid.value is ValidationState.Invalid) {
                _valid.value = ValidationState.Invalid(
                    failed.first().message
                )
            }
            false
        }
    }

}