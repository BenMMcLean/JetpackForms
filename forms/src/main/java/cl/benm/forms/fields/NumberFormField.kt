package cl.benm.forms.fields

import android.content.Context
import cl.benm.forms.LabeledFormField
import cl.benm.forms.Validator
import cl.benm.forms.fields.base.InputFormField

class NumberFormField<T: Number>(
    override val name: String,
    override val validators: List<Validator<T>>
): InputFormField<T>(), LabeledFormField<T> {

    override fun getLabel(value: T?, context: Context): String? {
        return value?.let { "$value" }
    }

}