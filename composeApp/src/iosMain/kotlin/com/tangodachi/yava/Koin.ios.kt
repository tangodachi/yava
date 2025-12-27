package com.tangodachi.yava

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin

actual fun provideHttpClient(configuration: HttpClientConfig<*>.() -> Unit): HttpClient {
    return HttpClient(Darwin, configuration)
}