package com.oilpay.features.auth_root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import libraries.decompose.common.DecomposeComponent

internal interface AuthRootComponent {
    val childStack: Value<ChildStack<*, DecomposeComponent>>
}