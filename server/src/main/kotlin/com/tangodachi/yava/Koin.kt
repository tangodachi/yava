package com.tangodachi.yava

import io.ktor.server.application.Application
import io.ktor.server.config.ApplicationConfig
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun Application.koin() {
    startKoin {
        modules(AppModule().module)
    }
}

@Module
@ComponentScan
class AppModule {
    @Single
    fun provideConfiguration(@Provided env: ApplicationConfig): Configuration {
        return Configuration(
            notification = Configuration.Notification(
                email = Configuration.Notification.Email(
                    address = env.property("notification.email.address").getString(),
                    password = env.property("notification.email.password").getString(),
                    smtp = Configuration.Notification.Email.Smtp(
                        auth = env.property("notification.email.smtp.auth").getString(),
                        host = env.property("notification.email.smtp.host").getString(),
                        port = env.property("notification.email.smtp.port").getString().toInt(),
                        socketFactory = Configuration.Notification.Email.Smtp.SocketFactory(
                            `class` = env.property("notification.email.smtp.socketFactory.class")
                                .getString(),
                            port = env.property("notification.email.smtp.socketFactory.port")
                                .getString().toInt(),
                        ),
                    ),
                )
            ),
        )
    }
}