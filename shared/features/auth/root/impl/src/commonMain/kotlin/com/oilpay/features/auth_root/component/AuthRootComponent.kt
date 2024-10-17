package com.oilpay.features.auth_root

import com.arkivanov.decompose.router.stack.ChildStack
import libraries.decompose.common.DecomposeComponent

interface AuthRootComponent {
    val childStack: ChildStack<*, DecomposeComponent>

}