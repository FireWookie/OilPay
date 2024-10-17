package com.oilpay.core.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.oilpay.core.storage.preferences.accessToken
import com.oilpay.core.storage.preferences.refreshToken
import com.oilpay.mobile.core.di.Injector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

internal class AuthStorageImpl(
    private val scope: CoroutineScope
): AuthStorage {
    private val dataStore: DataStore<Preferences> by Injector.lazy()

    override val isAuth: Boolean = runBlocking { true }

    override fun setAccessToken(token: String) {
        scope.launch {
            dataStore.edit {
                setAccessToken(token)
            }
        }
    }

    override fun setRefreshToken(token: String) {
        scope.launch {
            dataStore.edit {
                setRefreshToken(token)
            }
        }
    }

    override fun getAccessToken(): String = runBlocking {
        dataStore.data.first().accessToken
    }

    override fun getRefreshToken(): String = runBlocking {
        dataStore.data.first().refreshToken
    }
}