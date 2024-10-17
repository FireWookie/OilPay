package libraries.decompose.common.context

import org.koin.core.scope.ScopeID

interface ParentScopeIdOwner {

    val parentScopeID: ScopeID?
}