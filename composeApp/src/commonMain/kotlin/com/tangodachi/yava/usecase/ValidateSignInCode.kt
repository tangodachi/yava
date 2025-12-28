package com.tangodachi.yava.usecase

import com.tangodachi.yava.authentication.Authentication

class ValidateSignInCode(private val authentication: Authentication) {
    fun invoke(email: String, code: String) {
        // TODO()
    }
}

