package com.tangodachi.yava.authentication

import org.koin.core.annotation.Single

@Single(binds = [Authentication::class])
class AuthenticationImplementation : Authentication {
    override fun requestSignInCode(email: String) {
        TODO()
    }
}
