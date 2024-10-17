package com.oilpay.mobile.network.params

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.HttpClientEngineFactory

expect val ktorEngine: HttpClientEngineFactory<*>