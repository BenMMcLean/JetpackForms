package cl.benm.forms.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import cl.benm.forms.FormField

data class TextFormFieldWidgetArgs(
    val hint: String?,
    val keyboardType: KeyboardType = KeyboardType.Text,
)

open class TextFormFieldWidget(
    override val wrapper: FormFieldWrapper<String>
): BaseFormFieldWidget<String, TextFormFieldWidgetArgs>() {

    @Composable
    override fun DoBuild(field: FormField<String>, args: TextFormFieldWidgetArgs, error: Boolean) {
        val value by field.value.collectAsState(null)
        TextField(
            value = value ?: "",
            onValueChange = { field.currentValue = it },
            placeholder = args.hint?.let { {
                Text(
                    it,
                    style = MaterialTheme.typography.labelMedium
                )
            } },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = args.keyboardType
            ),
        )
    }

}