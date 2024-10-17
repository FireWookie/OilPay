package com.oilpay.mobile.network.params

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.HttpClientEngineBase
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpEngine


actual val ktorEngine: HttpClientEngineFactory<*> = OkHttp