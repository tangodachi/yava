package com.tangodachi.yava.authentication

interface Authentication {
    fun requestSignInCode(email: String)
}