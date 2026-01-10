package com.tangodachi.yava.utils

import org.koin.core.annotation.Factory

@Factory(binds = [GenerateCode::class])
class GenerateCodeImplementation : GenerateCode {
    override operator fun invoke(): String {
        TODO()
    }
}

