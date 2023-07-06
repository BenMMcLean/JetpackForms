package cl.benm.forms.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.benm.forms.FormField

abstract class BaseFormFieldWidget<T,A>: FormFieldWidget<T,A> {

    abstract val wrapper: FormFieldWrapper<T>

    @Composable
    override fun Build(
        field: FormField<T>,
        modifier: Modifier,
        args: A
    ) {
        wrapper(
            field,
            modifier,
        ) { error ->
            DoBuild(field, args, error)
        }
    }

    @Composable
    protected abstract fun DoBuild(
        field: FormField<T>,
        args: A,
        error: Boolean
    )

}