package cl.benm.forms.concrete

import cl.benm.forms.FormField

class SimpleForm(
    override val fields: List<FormField<*>>
): BaseForm() {

    init {
        afterFieldsEntered()
    }

}