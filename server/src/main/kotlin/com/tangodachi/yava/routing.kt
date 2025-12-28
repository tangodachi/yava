package com.tangodachi.yava

import com.tangodachi.yava.authentication.AuthenticationApi
import com.tangodachi.yava.authentication.RequestSignInCodeParameters
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.routing() {
    routing {
        post(AuthenticationApi.requestSignInCode) {
            println("Received ${call.receive<RequestSignInCodeParameters>()}")

            call.respond(HttpStatusCode.OK)
        }
    }
}