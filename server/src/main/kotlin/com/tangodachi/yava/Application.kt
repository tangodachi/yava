package com.tangodachi.yava

import com.tangodachi.yava.authentication.AuthenticationApi
import com.tangodachi.yava.authentication.RequestSignInCodeParameters
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    contentNegotiation()
    cors()

    routing {
        post(AuthenticationApi.requestSignInCode) {
            println("Received ${call.receive<RequestSignInCodeParameters>()}")

            call.respond(HttpStatusCode.OK)
        }
    }
}