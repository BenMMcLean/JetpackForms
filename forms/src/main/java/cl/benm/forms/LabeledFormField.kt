package cl.benm.forms

import android.content.Context

interface LabeledFormField<T> {

    fun getLabel(value: T?, context: Context): String?

}