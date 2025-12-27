package com.tangodachi.yava

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.js.Js

actual fun provideHttpClient(configuration: HttpClientConfig<*>.() -> Unit): HttpClient {
    return HttpClient(Js, configuration)
}