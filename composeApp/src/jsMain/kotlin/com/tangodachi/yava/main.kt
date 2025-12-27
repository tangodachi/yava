package com.tangodachi.yava

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.koin.compose.KoinApplication
import org.koin.ksp.generated.module

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        KoinApplication(
            application = {
                modules(AppModule().module)
            }
        ) {
            App()
        }
    }
}