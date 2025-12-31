package com.tangodachi.yava.utils

import com.tangodachi.yava.Configuration

class SendEmailImplementation(private val configuration: Configuration) : SendEmail {
    override suspend fun invoke(
        recipient: String,
        sender: String,
        title: String,
        message: String
    ) {
        TODO()
    }
}

