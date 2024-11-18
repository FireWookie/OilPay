package com.oilpay.feature.pin_code.domain.component

import com.oilpay.feature.pin_code.domain.models.PinCodeStep
import libraries.decompose.common.MviStore

sealed interface PinCodeAction {
    data class InputPinCode(val pinCode: String): PinCodeAction
    data object ConfirmPinCode: PinCodeAction
    data object BackPinCode: PinCodeAction
}

sealed interface PinCodeSideEffect {

}

data class PinCodeState(
    val pinCode: String = "",
    val pinCodeFirst: String = "",
    val step: PinCodeStep = PinCodeStep.First
)

class PinCodeStore: MviStore<PinCodeState, PinCodeAction, PinCodeSideEffect>(
    state = PinCodeState()
),  PinCodeInteractor by PinCodeInteractorImpl()