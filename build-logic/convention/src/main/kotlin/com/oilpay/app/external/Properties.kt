package com.oilpay.app.external

import java.util.Properties

fun Properties.propertyInt(key: String): Int {
    val property = getProperty(key)

    if (property.isNullOrEmpty()) {
        error("property $key is null")
    }

    return try {
        property.toInt()
    } catch (exception: NumberFormatException) {
        error("Cast exception for $key")
    }
}