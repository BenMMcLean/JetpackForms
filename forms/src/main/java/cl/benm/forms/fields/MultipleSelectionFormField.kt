package cl.benm.forms.fields

import android.content.Context
import cl.benm.forms.LabeledFormField
import cl.benm.forms.Validator
import cl.benm.forms.fields.base.SelectionFormField

class MultipleSelectionFormField<T>(
    override val name: String,
    override val validators: List<Validator<List<T>>>,
    private val label: (T?) -> String?
): SelectionFormField<List<T>>(), LabeledFormField<T> {

    override fun getLabel(value: T?, context: Context): String? {
        return label(value)
    }

}