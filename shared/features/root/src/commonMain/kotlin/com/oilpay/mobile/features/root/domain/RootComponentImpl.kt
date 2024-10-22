package com.oilpay.mobile.features.root.domain

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.oilpay.features.auth_root.AuthRootScreenComponent
import com.oilpay.features.splash.SplashComponent
import com.oilpay.mobile.core.di.Injector
import com.oilpay.onboarding.OnBoardingComponent
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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

    private val authRootFactory by Injector.lazy<AuthRootScreenComponent.Factory>()
    private val onBoardingFactory by Injector.lazy<OnBoardingComponent.Factory>()
    private val splashFactory by Injector.lazy<SplashComponent.Factory>()

    private val coroutineScope = coroutineScope()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Splash,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    init {
        stack
            .stackComponentEvents<OnBoardingComponent.Event>()
            .filterIsInstance<OnBoardingComponent.Event>()
            .onEach {
                when(it) {
                    OnBoardingComponent.Event.NavigateToAuth -> navigateToAuth()
                }
            }
            .launchIn(coroutineScope)
        stack
            .stackComponentEvents<SplashComponent.Event>()
            .filterIsInstance<SplashComponent.Event>()
            .onEach {
                when(it) {
                    SplashComponent.Event.NavigateToAuth -> navigateToAuth()
                    SplashComponent.Event.NavigateToMain -> navigateToMain()
                    SplashComponent.Event.NavigateToOnBoarding -> navigateToOnBoarding()
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

            Config.Splash -> splashFactory.create(
                context = context
            )
        }
    }

    // TODO add navigation to main
    private fun navigateToMain() {

    }

    private fun navigateToAuth() {
        navigation.replaceCurrent(Config.LoginFlow)
    }

    private fun navigateToOnBoarding() {
        navigation.replaceCurrent(Config.OnBoarding)
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object LoginFlow : Config

        @Serializable
        data object OnBoarding: Config

        @Serializable
        data object Splash: Config
    }

    companion object {
        private const val KEY = "RootStack"
    }
}