package com.tangodachi.yava.utils

import com.tangodachi.yava.Configuration

fun mockConfiguration(notificationEmail: String = "") = Configuration(
    notification = Configuration.Notification(
        email = Configuration.Notification.Email(
            address = notificationEmail,
            password = "",
            smtp = Configuration.Notification.Email.Smtp(
                auth = "",
                host = "",
                port = 0,
                socketFactory = Configuration.Notification.Email.Smtp.SocketFactory(
                    `class` = "",
                    port = 0,
                ),
            ),
        )
    ),
)