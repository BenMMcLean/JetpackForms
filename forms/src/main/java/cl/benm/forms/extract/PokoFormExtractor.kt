package cl.benm.forms.extract

import cl.benm.forms.FormExtractor
import cl.benm.forms.FormField
import kotlin.reflect.KClass
import kotlin.reflect.KParameter

class PokoFormExtractor<T: Any>(
    val target: KClass<T>
): FormExtractor<T> {

    override suspend fun extract(fields: List<FormField<*>>): T {
        val map = fields.associate { it.name.lowercase() to it.currentValue }
        val constructor = target.constructors.last()
        val args: Map<KParameter, Any?> = constructor.parameters.associateWith { map[it.name?.lowercase()] }
        return constructor.callBy(args)
    }

}