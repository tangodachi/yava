package com.tangodachi.yava.authentication

import kotlinx.serialization.Serializable

@Serializable
data class ValidateSignInCodeParameters(
    val email: String,
    val code: String
)