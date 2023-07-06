package cl.benm.forms.validators.multi

import cl.benm.forms.Form
import cl.benm.forms.ValidationResult
import cl.benm.forms.Validator
import java.lang.ref.WeakReference

interface FormInjectable {

    fun injectForm(form: WeakReference<Form>)

}

abstract class MultiFieldValidator<in T>: Validator<T>, FormInjectable {

    protected open val fallbackResult: ValidationResult = ValidationResult.Valid
    private var form: WeakReference<Form>? = null

    override fun injectForm(form: WeakReference<Form>) {
        this.form = form
    }

    override fun validate(input: T?): ValidationResult {
        return doValidation(input, form?.get() ?: return fallbackResult)
    }

    protected abstract fun doValidation(input: T?, form: Form): ValidationResult

}