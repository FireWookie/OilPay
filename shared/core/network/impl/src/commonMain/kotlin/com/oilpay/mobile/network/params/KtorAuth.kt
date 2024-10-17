package com.oilpay.mobile.network.params

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer


fun HttpClientConfig<*>.installAuth() {
    install(Auth) {
        bearer {
            loadTokens {
                BearerTokens("", "")
            }
        }
    }
}