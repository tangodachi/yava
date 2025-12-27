package com.tangodachi.yava.authentication

class AuthenticationMock : Authentication {
    var requestSignInCode = false
        private set
    var email: String? = null
        private set

    override fun requestSignInCode(email: String) {
        this.email = email
        requestSignInCode = true
    }
}