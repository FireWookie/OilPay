package com.oilpay.core.storage

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val storageModule = module {
    singleOf(::AuthStorageImpl) {
        bind<AuthStorage>()
        createdAtStart()
    }
}