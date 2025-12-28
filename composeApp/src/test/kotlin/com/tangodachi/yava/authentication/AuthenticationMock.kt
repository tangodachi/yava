package com.tangodachi.yava.authentication

class AuthenticationMock : Authentication {
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
        this.email = email
        this.code = code
        this.validateSignInCode = true
    }
}