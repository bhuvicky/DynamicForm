package com.example.dynamicform.utils

import android.text.InputType

object ViewUtil {

    fun getInputType(inputName: String) =
        when(inputName) {
            "text" -> InputType.TYPE_CLASS_TEXT
            "phone" -> InputType.TYPE_CLASS_PHONE
            "number" -> InputType.TYPE_CLASS_NUMBER
            "email" -> InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            "password" -> InputType.TYPE_TEXT_VARIATION_PASSWORD
            "postalAddress" -> InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS
            else -> -1
        }
}