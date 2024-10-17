package com.oilpay.mobile.network

import com.oilpay.mobile.network.params.installAuth
import com.oilpay.mobile.network.params.installJson
import com.oilpay.mobile.network.params.installLogger
import com.oilpay.mobile.network.params.installRetryConnection
import com.oilpay.mobile.network.params.installTimeOut
import com.oilpay.mobile.network.params.ktorEngine
import io.ktor.client.HttpClient

fun networkSetup(): HttpClient {
    return HttpClient(ktorEngine) {
        installAuth()
        installJson()
        installLogger()
        installTimeOut()
        installRetryConnection()
    }
}