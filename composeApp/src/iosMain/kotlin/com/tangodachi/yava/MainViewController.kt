package com.tangodachi.yava

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.compose.KoinApplication
import org.koin.ksp.generated.module

fun MainViewController() = ComposeUIViewController {
    KoinApplication(
        application = {
            modules(AppModule().module)
        }
    ) {
        App()
    }
}