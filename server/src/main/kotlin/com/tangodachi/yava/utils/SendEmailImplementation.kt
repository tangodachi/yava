package com.tangodachi.yava.utils

import com.tangodachi.yava.Configuration
import org.koin.core.annotation.Factory

@Factory(binds = [SendEmail::class])
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

