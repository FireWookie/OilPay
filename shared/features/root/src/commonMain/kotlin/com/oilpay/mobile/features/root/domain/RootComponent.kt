package com.oilpay.mobile.features.root.domain

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import libraries.decompose.common.DecomposeComponent

fun buildRootComponent(
    componentContext: ComponentContext
): RootComponent = RootComponentImpl(componentContext)

@Stable
interface RootComponent {
    val childStack: ChildStack<*, DecomposeComponent>
}