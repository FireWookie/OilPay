package com.oilpay.mobile.umbrella_core

import org.koin.core.context.startKoin
import org.koin.core.module.Module

object KoinInjector {
    val koinApp = startKoin {
        modules(
            listOf(

            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }
}