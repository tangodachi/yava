package com.tangodachi.yava

import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    koin()
    contentNegotiation()
    cors()
    routing()
}