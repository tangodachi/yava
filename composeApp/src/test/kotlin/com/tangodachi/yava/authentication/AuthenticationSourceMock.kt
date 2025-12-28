package com.tangodachi.yava.authentication

class AuthenticationSourceMock : AuthenticationSource {
    var code: String? = null
        private set
    var email: String? = null
        private set
    var requestSignInCode = false
        private set
    var validateSignInCode = false
        private set

    override suspend fun requestSignInCode(email: String) {
        this.email = email
        this.requestSignInCode = true
    }

    override suspend fun validateSignInCode(email: String, code: String) {
        this.code = code
        this.email = email
        this.validateSignInCode = true
    }
}