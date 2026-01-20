package com.tangodachi.yava.interactor

import com.tangodachi.yava.Configuration
import com.tangodachi.yava.authentication.RequestSignInCodeParameters
import com.tangodachi.yava.utils.GenerateCode
import com.tangodachi.yava.utils.SendEmail
import org.koin.core.annotation.Factory

@Factory
class RequestSignInCode(
    private val configuration: Configuration,
    private val generateCode: GenerateCode,
    private val sendEmail: SendEmail,
) {
    suspend operator fun invoke(parameters: RequestSignInCodeParameters) {
        sendEmail(
            recipient = parameters.email,
            sender = configuration.notification.email.address,
            title = "",
            message = generateCode()
        )
    }
}

