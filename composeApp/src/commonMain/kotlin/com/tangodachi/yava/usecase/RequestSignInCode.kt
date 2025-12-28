package com.tangodachi.yava.usecase

import com.tangodachi.yava.authentication.Authentication
import org.koin.core.annotation.Factory

@Factory
class RequestSignInCode(private val authentication: Authentication) {
    suspend operator fun invoke(email: String) {
        authentication.requestSignInCode(email)
    }
}