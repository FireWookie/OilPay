package com.oilpay.mobile.umbrella_core

import com.oilpay.core.storage.storageModule
import com.oilpay.features.auth_root.authRootDI
import com.oilpay.login.loginModuleDI
import com.oilpay.mobile.network.networkModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object KoinInjector {
    val koinApp = startKoin {
        modules(
            listOf(
                sharedModule,
//                storageModule,
//                coroutineModule,
                networkModule,
                loginModuleDI,
                authRootDI
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }

    private val coroutineModule = module {
        single { CoroutineScope(SupervisorJob() + Dispatchers.Main) }
    }
}