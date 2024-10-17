package com.oilpay.mobile.network.params

import com.oilpay.core.storage.AuthStorage
import com.oilpay.mobile.core.di.Injector
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer


fun HttpClientConfig<*>.installAuth() {
    val tokenStorage by Injector.lazy<AuthStorage>()

    install(Auth) {
        bearer {
            val accessToken = tokenStorage.getAccessToken()
            val refreshToken = tokenStorage.getAccessToken()
            if (accessToken.isNotEmpty() && refreshToken.isNotEmpty()) {
                loadTokens {
                    BearerTokens(accessToken, refreshToken)
                }
            }
        }
    }
}