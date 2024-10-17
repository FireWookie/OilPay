package com.oilpay.mobile.umbrella_core

import android.content.Context
import com.oilpay.mobile.libraries.datastore.dataStore
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val sharedModule: Module = module {
    single { get<Context>().dataStore() }
}