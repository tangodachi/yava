package com.tangodachi.yava.authentication

import org.koin.core.annotation.Single

@Single(binds = [Authentication::class])
class AuthenticationImplementation(private val source: AuthenticationSource) : Authentication {
    override suspend fun requestSignInCode(email: String) {
        source.requestSignInCode(email)
    }
}
