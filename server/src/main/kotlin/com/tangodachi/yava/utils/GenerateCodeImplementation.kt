package com.tangodachi.yava.utils

import org.koin.core.annotation.Factory

@Factory(binds = [GenerateCode::class])
class GenerateCodeImplementation : GenerateCode {
    override operator fun invoke(): String {
        return (1..8)
            .map { ('A'..'Z') + ('0'..'9') }
            .map { it.random() }
            .joinToString("")
    }
}

