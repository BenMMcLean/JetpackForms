package cl.benm.forms.fields

import android.content.Context
import cl.benm.forms.LabeledFormField
import cl.benm.forms.Validator
import cl.benm.forms.fields.base.InputFormField
import java.text.DateFormat
import java.util.*

class DateFormField(
    override val name: String,
    override val validators: List<Validator<Date>>,
    private val dateFormat: DateFormat
): InputFormField<Date>(), LabeledFormField<Date> {

    override fun getLabel(value: Date?, context: Context): String? {
        return value?.let { dateFormat.format(it) }
    }

}