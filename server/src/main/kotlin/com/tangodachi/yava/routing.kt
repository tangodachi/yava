package com.tangodachi.yava

import com.tangodachi.yava.authentication.AuthenticationApi
import com.tangodachi.yava.authentication.RequestSignInCodeParameters
import com.tangodachi.yava.authentication.ValidateSignInCodeParameters
import com.tangodachi.yava.interactor.RequestSignInCode
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import org.koin.ktor.ext.get

fun Application.routing() {
    val requestSignInCode = get<RequestSignInCode>()

    routing {
        post(AuthenticationApi.requestSignInCode) {
            requestSignInCode(call.receive<RequestSignInCodeParameters>())

            call.respond(HttpStatusCode.OK)
        }
        post(AuthenticationApi.validateSignInCode) {
            println("Received ${call.receive<ValidateSignInCodeParameters>()}")
            call.respond(HttpStatusCode.OK)
        }
    }
}