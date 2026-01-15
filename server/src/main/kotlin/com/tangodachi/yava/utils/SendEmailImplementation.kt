package com.tangodachi.yava.utils

import com.tangodachi.yava.Configuration
import org.koin.core.annotation.Factory
import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Factory(binds = [SendEmail::class])
class SendEmailImplementation(private val configuration: Configuration) : SendEmail {
    private val properties: Properties = System.getProperties().let {
        it["mail.smtp.host"] = configuration.notification.email.smtp.host
        it["mail.smtp.port"] = configuration.notification.email.smtp.port.toString()
        it["mail.smtp.auth"] = configuration.notification.email.smtp.auth
        it["mail.smtp.socketFactory.port"] =
            configuration.notification.email.smtp.socketFactory.port.toString()
        it["mail.smtp.socketFactory.class"] =
            configuration.notification.email.smtp.socketFactory.`class`

        return@let it
    }

    override suspend fun invoke(
        recipient: String,
        sender: String,
        title: String,
        message: String
    ) {
        val session = Session.getInstance(
            /* props = */ properties,
            /* authenticator = */ object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication(
                        /* userName = */ configuration.notification.email.address,
                        /* password = */ configuration.notification.email.password,
                    )
                }
            }
        )
        val message = MimeMessage(session).apply {
            this.setFrom(InternetAddress(sender))
            this.addRecipient(Message.RecipientType.TO, InternetAddress(recipient))
            this.subject = title
            this.setText(message)
        }

        Transport.send(message)
    }
}

