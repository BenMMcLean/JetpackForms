package cl.benm.forms.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


interface FormFieldUIConfiguration {

    @Composable
    fun lockup(
        title: String?,
        modifier: Modifier,
        description: String? = null,
        optional: Boolean = false,
        content: @Composable () -> Unit
    )

    @Composable
    fun <T> wrapper(
        field: FormField<T>,
        modifier: Modifier = Modifier,
        bottomLabel: @Composable () -> Unit = {},
        delegate: @Composable (error: Boolean) -> Unit
    )

}