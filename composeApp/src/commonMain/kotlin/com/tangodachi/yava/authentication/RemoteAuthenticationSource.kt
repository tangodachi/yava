package com.tangodachi.yava.authentication

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.koin.core.annotation.Single

@Single(binds = [AuthenticationSource::class])
class RemoteAuthenticationSource(private val httpClient: HttpClient) : AuthenticationSource {
    override suspend fun requestSignInCode(email: String) {
        val parameters = RequestSignInCodeParameters(email = email)

        httpClient.post(AuthenticationApi.requestSignInCode) {
            contentType(ContentType.Application.Json)
            setBody(parameters)
        }
    }
}