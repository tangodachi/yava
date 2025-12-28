package com.tangodachi.yava.authentication

import kotlinx.serialization.Serializable

@Serializable
data class RequestSignInCodeParameters(val email: String)
