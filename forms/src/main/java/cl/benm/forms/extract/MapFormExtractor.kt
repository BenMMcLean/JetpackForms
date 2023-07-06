package cl.benm.forms.extract

import cl.benm.forms.FormExtractor
import cl.benm.forms.FormField

class MapFormExtractor: FormExtractor<Map<String, Any?>> {

    override suspend fun extract(fields: List<FormField<*>>): Map<String, Any?> {
        return fields.associate {
            val name = it.name
            name to it.currentValue
        }
    }
}