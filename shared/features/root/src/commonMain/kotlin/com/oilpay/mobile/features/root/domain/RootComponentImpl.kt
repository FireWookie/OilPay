package com.oilpay.mobile.features.root.domain

import androidx.compose.runtime.rememberCoroutineScope
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.oilpay.core.storage.AuthStorage
import com.oilpay.core.storage.OnBoardingStorage
import com.oilpay.features.auth_root.AuthRootScreenComponent
import com.oilpay.mobile.core.di.Injector
import com.oilpay.onboarding.OnBoardingComponent
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.context.wrapComponentContext
import libraries.decompose.common.ext.stackComponentEvents
import org.koin.core.component.KoinComponent
import org.koin.core.component.getScopeId

internal class RootComponentImpl(
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<Config>()

    private val storage by Injector.lazy<AuthStorage>()
    private val storageBoarding by Injector.lazy<OnBoardingStorage>()

    private val authRootFactory by Injector.lazy<AuthRootScreenComponent.Factory>()
    private val onBoardingFactory by Injector.lazy<OnBoardingComponent.Factory>()

    private val coroutineScope = coroutineScope()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = initialConfiguration(),
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    private fun initialConfiguration(): Config = runBlocking {
        val isAuth = storage.getAccessToken().isNotEmpty()
        val statusBoarding = storageBoarding.onBoardingStatus()

        if (!isAuth && statusBoarding) {
            Config.LoginFlow
        } else if (!isAuth && statusBoarding) {
            Config.OnBoarding
        } else {
            Config.OnBoarding
        }
    }

    init {
        checkNavigate()
        stack
            .stackComponentEvents<AuthRootScreenComponent.Event>()
            .filterIsInstance<AuthRootScreenComponent.Event>()
            .onEach {
                when (it) {
                    AuthRootScreenComponent.Event.OnBackClick -> navigation.push(Config.LoginFlow)
                }
            }
            .launchIn(coroutineScope)
        stack
            .stackComponentEvents<OnBoardingComponent.Event>()
            .filterIsInstance<OnBoardingComponent.Event>()
            .onEach {
                when(it) {
                    OnBoardingComponent.Event.NavigateToAuth -> navigation.push(Config.LoginFlow)
                }
            }
            .launchIn(coroutineScope)
    }

    override val childStack: Value<ChildStack<*, DecomposeComponent>> = stack

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ): DecomposeComponent {
        val context = wrapComponentContext(
            context = componentContext,
            parentScopeID = getKoin().getScopeId()
        )
        return when(config) {
            Config.LoginFlow -> authRootFactory.create(
                context = context
            )

            Config.OnBoarding -> onBoardingFactory.create(
                context = context
            )
        }
    }

    private fun checkNavigate() {
        runBlocking {
            val isAuth = storage.getAccessToken().isNotEmpty()
            val statusBoarding = storageBoarding.onBoardingStatus()
            if (!isAuth && statusBoarding) {
                navigation.replaceCurrent(Config.LoginFlow)
            } else if (!isAuth && statusBoarding) {
                navigation.replaceCurrent(Config.OnBoarding)
            }
        }
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object LoginFlow : Config

        @Serializable
        data object OnBoarding: Config

    }

    companion object {
        private const val KEY = "RootStack"
    }
}