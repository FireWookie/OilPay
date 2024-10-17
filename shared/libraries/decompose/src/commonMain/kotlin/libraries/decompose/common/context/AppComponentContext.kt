package libraries.decompose.common.context

import com.arkivanov.decompose.GenericComponentContext

interface AppComponentContext : GenericComponentContext<AppComponentContext>,
    ParentScopeIdOwner