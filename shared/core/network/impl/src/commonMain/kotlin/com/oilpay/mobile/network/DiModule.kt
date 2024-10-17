package com.oilpay.mobile.network

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::networkSetup)
}