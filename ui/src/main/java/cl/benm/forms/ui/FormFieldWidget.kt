package cl.benm.forms.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.benm.forms.FormField

interface FormFieldWidget<T,A> {

    @Composable
    fun Build(
        field: FormField<T>,
        modifier: Modifier = Modifier,
        args: A
    )

}