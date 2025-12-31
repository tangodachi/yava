package com.tangodachi.yava.interactor

import com.tangodachi.yava.authentication.RequestSignInCodeParameters
import com.tangodachi.yava.utils.SendEmail

class RequestSignInCode(private val sendEmail: SendEmail) {
    operator fun invoke(parameters: RequestSignInCodeParameters) {
        TODO()
    }
}

