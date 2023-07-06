package cl.benm.forms.fields

import cl.benm.forms.Validator
import cl.benm.forms.fields.base.InputFormField
import cl.benm.forms.validators.ABNValidator
import cl.benm.forms.validators.BlankValidator
import cl.benm.forms.validators.EmailValidator
import cl.benm.forms.validators.PhoneNumberValidator
import cl.benm.forms.validators.URLValidator
import cl.benm.forms.validatorss.RequiredValidator

class TextFormField(
    override val name: String,
    override val validators: List<Validator<String>>,
    val formFactor: TextFormFactor
): InputFormField<String>() {

    companion object {

        fun phone(name: String, required: Boolean): TextFormField {
            return createField(name, required, listOf(PhoneNumberValidator()), TextFormFactor.PHONE)
        }

        fun email(name: String, required: Boolean): TextFormField {
            return createField(name, required, listOf(EmailValidator()), TextFormFactor.EMAIL)
        }

        fun website(name: String, required: Boolean): TextFormField {
            return createField(name, required, listOf(URLValidator()), TextFormFactor.URL)
        }

        fun abn(name: String, required: Boolean): TextFormField {
            return createField(name, required, listOf(ABNValidator()), TextFormFactor.NUMBER)
        }

        fun basic(name: String, required: Boolean): TextFormField {
            return createField(name, required, emptyList(), TextFormFactor.TEXT)
        }

        private fun createField(
            name: String,
            required: Boolean,
            validators: List<Validator<String>>,
            formFactor: TextFormFactor
        ): TextFormField {
            return TextFormField(
                name,
                validators + if (required) listOf(RequiredValidator(), BlankValidator()) else listOf(),
                formFactor
            )
        }

    }

}

enum class TextFormFactor {
    TEXT, NUMBER, NUMBER_DECIMAL, PHONE, EMAIL, URL
}