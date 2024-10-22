package com.oilpay.mobile.features.root.domain

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import libraries.decompose.common.DecomposeComponent

fun buildRootComponent(
    componentContext: ComponentContext
): RootComponent = RootComponentImpl(componentContext)

@Stable
interface RootComponent {
    val childStack: Value<ChildStack<*, DecomposeComponent>>
}