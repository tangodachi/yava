package com.tangodachi.yava

data class Configuration(val notification: Notification) {
    data class Notification(val email: Email) {
        data class Email(
            val address: String,
            val password: String,
            val smtp: Smtp,
        ) {
            data class Smtp(
                val auth: String,
                val host: String,
                val port: Int,
                val socketFactory: SocketFactory,
            ) {
                data class SocketFactory(
                    val `class`: String,
                    val port: Int,
                )
            }
        }
    }
}