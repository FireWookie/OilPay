package libraries.decompose.common

import com.arkivanov.decompose.ComponentContext
import libraries.decompose.common.context.AppComponentContext
import org.koin.core.Koin
import org.koin.core.component.KoinComponent

abstract class BaseComponent(
    componentContext: AppComponentContext
): AppComponentContext by componentContext, KoinComponent {
}