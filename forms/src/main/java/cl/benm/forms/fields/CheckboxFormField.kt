package cl.benm.forms.fields

import cl.benm.forms.Validator
import cl.benm.forms.fields.base.InputFormField

class CheckboxFormField(
    override val name: String,
    override val validators: List<Validator<Boolean>>
): InputFormField<Boolean>()