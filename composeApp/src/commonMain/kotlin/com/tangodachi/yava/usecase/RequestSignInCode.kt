package com.tangodachi.yava.usecase

import org.koin.core.annotation.Factory

@Factory
class RequestSignInCode {
    operator fun invoke(email: String) {
        println("Requesting sign-in code for email: $email")
    }
}

