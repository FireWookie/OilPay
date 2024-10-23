package com.oilpay.features.auth_root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.oilpay.features.auth_root.AuthRootScreenComponent
import com.oilpay.features.auth_root.ui.AuthRootScreen
import com.oilpay.features.otp_code.OtpCodeScreenComponent
import com.oilpay.mobile.login.api.LoginComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.Serializable
import libraries.decompose.common.BaseComponent
import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.content.ComponentContent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.ext.stackComponentEvents
import libraries.decompose.common.producer.EventsProducerDelegate
import libraries.decompose.common.producer.EventsProducerDelegateImpl
import org.koin.core.component.inject


internal class AuthRootComponentImpl(
    componentContext: AppComponentContext,
):
    AuthRootComponent,
    AuthRootScreenComponent,
    EventsProducerDelegate<AuthRootScreenComponent.Event> by EventsProducerDelegateImpl(),
    BaseComponent(componentContext)
{
    private val loginComponent: LoginComponent.Factory by inject()
    private val otpCodeComponent: OtpCodeScreenComponent.Factory by inject()

    private val coroutineScope = coroutineScope()

    override val content: ComponentContent = AuthRootScreen(this)

    private val navigation = StackNavigation<Config>()

    private val stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Login,
        handleBackButton = true,
        key = KEY,
        childFactory = ::processChild
    )

    init {
        stack
            .stackComponentEvents<LoginComponent.Event>()
            .onEach {
                when (it) {
                    is LoginComponent.Event.NavigateToOtp -> navigation.pushNew(
                        configuration = Config.OtpCode(it.phone)
                    )
                }
            }
            .launchIn(coroutineScope)
    }

    override val childStack: Value<ChildStack<*, DecomposeComponent>> = stack

    private fun processChild(
        config: Config,
        componentContext: AppComponentContext
    ) : DecomposeComponent {
        return when(config) {
            Config.Login -> loginComponent.create(componentContext)
            is Config.OtpCode -> otpCodeComponent.create(componentContext, config.phone)
        }
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Login : Config

        @Serializable
        data class OtpCode(val phone: String): Config
    }

    companion object {
        private const val KEY = "AuthRootStack"
    }
}