package com.tangodachi.yava.utils

interface SendEmail {
    suspend operator fun invoke(
        recipient: String,
        sender: String,
        title: String,
        message: String
    )
}
