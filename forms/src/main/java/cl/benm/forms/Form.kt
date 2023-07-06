package cl.benm.forms

import cl.benm.forms.concrete.SimpleForm

interface Form: Verifiable {

    suspend fun initialize(initializer: FormInitialiser)
    suspend fun <T> extract(extractor: FormExtractor<T>)

    fun <T> getField(name: String): FormField<T>
    fun hasField(name: String): Boolean

    companion object {

        fun of(fields: List<FormField<*>>): Form {
            return SimpleForm(fields)
        }

    }

}