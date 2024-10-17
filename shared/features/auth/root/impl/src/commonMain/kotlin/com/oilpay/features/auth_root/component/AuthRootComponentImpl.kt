package com.oilpay.features.auth_root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.oilpay.mobile.login.api.LoginComponent
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.serialization.Serializable
import libraries.decompose.common.BaseComponent
import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.context.wrapComponentContext
import libraries.decompose.common.ext.stackComponentEvents
import libraries.decompose.common.koinScope
import org.koin.core.component.getScopeId
import org.koin.core.component.inject
import org.koin.core.qualifier.qualifier

internal class AuthRootComponentImpl(
    componentContext: AppComponentContext,
): BaseComponent(componentContext), AuthRootComponent {

    private val loginComponent: LoginComponent.Factory by inject()

    private val koinScope = koinScope(
        scopeID = getScopeId(),
        qualifier = qualifier<AuthRootComponent>(),
    )

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Login,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    init {
        stack
            .stackComponentEvents<LoginComponent.Event>()
            .take(1)
            .onEach {
                when (it) {
                    LoginComponent.Event.OnBackClick -> navigation::pop
                }
            }
    }

    override val childStack: ChildStack<*, DecomposeComponent> = stack.value

    private fun processChild(
        config: Config,
        componentContext: AppComponentContext
    ) : DecomposeComponent {
        val wrappedContext = wrapComponentContext(
            context = componentContext,
            parentScopeID = koinScope.id,
        )
        return when(config) {
            Config.Login -> loginComponent.create(wrappedContext)
        }
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Login : Config
    }

    companion object {
        private const val KEY = "AuthRootStack"
    }
}