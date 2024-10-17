package com.oilpay.core.storage.preferences

import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey

private val ACCESS_TOKEN = stringPreferencesKey("access_token")
private val REFRESH_TOKEN = stringPreferencesKey("refresh_token")


fun MutablePreferences.accessToken(accessToken: String) {
    this[ACCESS_TOKEN] = accessToken
}

fun MutablePreferences.refreshToken(refreshToken: String) {
    this[REFRESH_TOKEN] = refreshToken
}

internal val Preferences.accessToken: String
    get() = this[ACCESS_TOKEN] ?: ""

internal val Preferences.refreshToken: String
    get() = this[ACCESS_TOKEN] ?: ""
