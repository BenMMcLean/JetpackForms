package cl.benm.forms.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cl.benm.forms.FormField

typealias FormFieldLockup = @Composable (
    title: String?,
    modifier: Modifier,
    description: String?,
    optional: Boolean,
    content: @Composable () -> Unit
) -> Unit

typealias FormFieldWrapper<T> = @Composable (
    field: FormField<T>,
    modifier: Modifier,
    delegate: @Composable (error: Boolean) -> Unit
) -> Unit

interface FormFieldUIConfiguration {

    fun lockup(): FormFieldLockup
    fun <T> wrapper(): FormFieldWrapper<T>



}

