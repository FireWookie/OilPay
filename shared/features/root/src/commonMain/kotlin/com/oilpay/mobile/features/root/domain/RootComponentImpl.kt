package com.oilpay.mobile.features.root.domain

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable
import libraries.decompose.common.BaseComponent

internal class RootComponentImpl(
    componentContext: ComponentContext
): RootComponent, BaseComponent(componentContext) {

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.MainFlow,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    override val childStack: ChildStack<*, RootComponent.Child> = stack.value

    private fun processChild(
        config: Config,
        componentContext: ComponentContext
    ) = when (config) {
        is Config.Onboarding -> RootComponent.Child.OnBoarding(
            Unit
        )
        is Config.MainFlow -> RootComponent.Child.Auth(
            Unit
        )
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object MainFlow : Config

        @Serializable
        data object Onboarding : Config
    }

    companion object {
        private const val KEY = "RootStack"
    }
}