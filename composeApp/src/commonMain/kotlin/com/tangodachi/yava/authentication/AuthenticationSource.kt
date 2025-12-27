package com.tangodachi.yava.authentication

interface AuthenticationSource {
    fun requestSignInCode(email: String)
}


