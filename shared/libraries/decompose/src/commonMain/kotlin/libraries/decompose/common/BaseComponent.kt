package libraries.decompose.common

import com.arkivanov.decompose.ComponentContext
import org.koin.core.Koin
import org.koin.core.component.KoinComponent

abstract class BaseComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext, KoinComponent {
}