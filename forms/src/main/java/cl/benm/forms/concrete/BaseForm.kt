package cl.benm.forms.concrete

import cl.benm.forms.Form
import cl.benm.forms.FormExtractor
import cl.benm.forms.FormField
import cl.benm.forms.FormInitialiser
import cl.benm.forms.ValidationState
import cl.benm.forms.validators.multi.FormInjectable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import java.lang.ref.WeakReference

abstract class BaseForm: Form {

    protected abstract val fields: List<FormField<*>>

    protected fun afterFieldsEntered() {
        fields.forEach {
            if (it is FormInjectable) {
                it.injectForm(WeakReference(this))
            }
        }
    }

    override suspend fun initialize(initializer: FormInitialiser) {
        fields.forEach {
            initializer.init(it)
        }
    }

    override suspend fun <T> extract(extractor: FormExtractor<T>) {
        extractor.extract(fields)
    }

    override fun <T> getField(name: String): FormField<T> {
        return fields.first { it.name == name } as FormField<T>
    }

    override fun hasField(name: String): Boolean {
        return fields.any { it.name == name }
    }

    override val valid: Flow<ValidationState>
        get() = combine(fields.map { it.valid }) {
            it.fold<ValidationState, ValidationState>(ValidationState.Valid) { acc, v ->
                when {
                    acc is ValidationState.Invalid -> acc
                    v is ValidationState.Invalid -> v
                    else -> ValidationState.Valid
                }
            }
        }

    override suspend fun validate(silent: Boolean): Boolean {
        return fields.map { it.validate(silent) }.all { it }
    }
}