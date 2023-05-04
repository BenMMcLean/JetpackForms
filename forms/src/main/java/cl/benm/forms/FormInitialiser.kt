package cl.benm.forms

interface FormInitialiser {

    suspend fun <T> init(field: FormField<T>)

}