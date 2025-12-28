package com.tangodachi.yava.authentication

interface AuthenticationSource {
    suspend fun requestSignInCode(email: String)
}


