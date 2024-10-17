package com.oilpay.features.auth_root.component

import com.arkivanov.decompose.router.stack.ChildStack
import libraries.decompose.common.DecomposeComponent

internal interface AuthRootComponent {
    val childStack: ChildStack<*, DecomposeComponent>

}