package com.tangodachi.yava

import io.ktor.server.application.Application
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

fun Application.koin() {
    startKoin {
        modules(AppModule().module)
    }
}

@Module
@ComponentScan
class AppModule