package com.oilpay.login.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.login.ui.LoginScreen
import com.oilpay.mobile.login.api.LoginComponent
import libraries.decompose.common.MviComponent

import libraries.decompose.common.content.ComponentContent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducerDelegate
import libraries.decompose.common.producer.EventsProducerDelegateImpl

internal class LoginComponentImpl(
    context: AppComponentContext
): MviComponent<LoginState, LoginAction, LoginSideEffect, LoginStore>,
    LoginComponent,
    EventsProducerDelegate<LoginComponent.Event> by EventsProducerDelegateImpl(),
    AppComponentContext by context {

    override val content: ComponentContent = LoginScreen(this)

    override val store: LoginStore = instanceKeeper.getOrCreate { LoginStore() }

    override fun dispatchAction(action: LoginAction) {
        when(action) {
            LoginAction.ClickLogin -> clickLogin()
            is LoginAction.InputPhone -> blockingIntent {
                reduce { state.copy(phone = action.phone) }
            }

            is LoginAction.ClickCheckbox -> blockingIntent {
                reduce { state.copy(checked = action.checked) }
            }
        }
    }

    private fun clickLogin() {

    }
}