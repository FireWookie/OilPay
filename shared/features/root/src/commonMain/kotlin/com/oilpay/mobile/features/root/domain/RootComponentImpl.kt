package com.oilpay.mobile.features.root.domain

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.oilpay.features.auth_root.AuthRootScreenComponent
import com.oilpay.mobile.core.di.Injector
import kotlinx.serialization.Serializable
import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.context.wrapComponentContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.getScopeId

internal class RootComponentImpl(
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<Config>()

    private val authRootFactory by Injector.lazy<AuthRootScreenComponent.Factory>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.LoginFlow,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    override val childStack: ChildStack<*, DecomposeComponent> = stack.value

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ): DecomposeComponent {
        val context = wrapComponentContext(
            context = componentContext,
            parentScopeID = getKoin().getScopeId()
        )
        return when(config) {
            is Config.LoginFlow -> authRootFactory.create(
                context = context,
                onNavigateMain = {}
            )
        }
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object LoginFlow : Config

    }

    companion object {
        private const val KEY = "RootStack"
    }
}