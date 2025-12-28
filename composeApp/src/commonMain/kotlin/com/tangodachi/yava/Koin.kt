package com.tangodachi.yava

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class AppModule {
    @Single
    fun provideHttpClient(): HttpClient {
        return provideHttpClient {
            defaultRequest {
                host = "localhost"
                port = SERVER_PORT
            }

            install(ContentNegotiation) {
                json()
            }
        }
    }
}

expect fun provideHttpClient(configuration: HttpClientConfig<*>.() -> Unit): HttpClient