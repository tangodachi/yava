package com.tangodachi.yava.usecase

import com.tangodachi.yava.authentication.Authentication
import org.koin.core.annotation.Factory

@Factory
class ValidateSignInCode(private val authentication: Authentication) {
    suspend operator fun invoke(email: String, code: String) {
        authentication.validateSignInCode("q@q.be", "123456")
    }
}

