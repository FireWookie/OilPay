package com.oilpay.mobile.features.root.domain

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack

fun buildRootComponent(
    componentContext: ComponentContext
): RootComponent = RootComponentImpl(componentContext)

@Stable
interface RootComponent {
    val childStack: ChildStack<*, Child>

    sealed class Child {
        data class OnBoarding(val component: Unit): Child()
        data class Auth(val component: Unit): Child()
    }
}