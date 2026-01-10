package com.tangodachi.yava.utils

import org.koin.core.annotation.Factory

@Factory
class SendEmailMock : SendEmail {
    lateinit var recipient: String
        private set
    lateinit var sender: String
        private set
    lateinit var title: String
        private set
    lateinit var message: String
        private set
    var invoked: Boolean = false
        private set

    override suspend fun invoke(
        recipient: String,
        sender: String,
        title: String,
        message: String
    ) {
        this.recipient = recipient
        this.sender = sender
        this.title = title
        this.message = message
        invoked = true
    }
}