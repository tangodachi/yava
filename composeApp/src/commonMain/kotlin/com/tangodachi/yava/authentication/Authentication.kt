package com.tangodachi.yava.authentication

interface Authentication {
    suspend fun requestSignInCode(email: String)
}