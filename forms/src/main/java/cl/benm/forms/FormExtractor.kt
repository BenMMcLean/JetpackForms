package cl.benm.forms

interface FormExtractor<T> {

    suspend fun extract(fields: List<FormField<*>>): T

}