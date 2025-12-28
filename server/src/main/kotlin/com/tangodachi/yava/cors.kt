package com.tangodachi.yava

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.cors.routing.CORS

fun Application.cors() {
    install(CORS) {
        allowHost("localhost:8080")
        allowHeader(HttpHeaders.ContentType)
        allowMethod(HttpMethod.Post)
    }
}