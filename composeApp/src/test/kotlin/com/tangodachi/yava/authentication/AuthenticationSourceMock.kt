package com.tangodachi.yava.authentication

class AuthenticationSourceMock : AuthenticationSource {
    var requestSignInCodeCalled = false
        private set
    var email: String? = null
        private set

    override fun requestSignInCode(email: String) {
        this.email = email
        requestSignInCodeCalled = true
    }
}