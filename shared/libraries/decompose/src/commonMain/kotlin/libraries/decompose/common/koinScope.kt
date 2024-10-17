package libraries.decompose.common

import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.flow.StateFlow
import libraries.decompose.common.context.ParentScopeIdOwner
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope
import org.koin.core.scope.ScopeCallback
import org.koin.core.scope.ScopeID
import org.koin.mp.KoinPlatform

context(LifecycleOwner, ParentScopeIdOwner)
fun koinScope(
    vararg modules: Module,
    scopeID: ScopeID,
    qualifier: Qualifier,
) : Scope {
    val scope = KoinPlatform.getKoin().createScope(
        scopeId = scopeID,
        qualifier = qualifier,
        source = null,
    )

    val modulesList = modules.toList()

    parentScopeID
        ?.let(scope::getScope)
        ?.let { parentScope ->
            scope.linkTo(parentScope)
        }

    KoinPlatform.getKoin().loadModules(
        modulesList,
    )

    scope.registerCallback(
        object : ScopeCallback {
            override fun onScopeClose(scope: Scope) {
                KoinPlatform.getKoin().unloadModules(
                    modulesList
                )
            }
        }
    )

    lifecycle.doOnDestroy {
        scope.close()
    }

    return scope
}