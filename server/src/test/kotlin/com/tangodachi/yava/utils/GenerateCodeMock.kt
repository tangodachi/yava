package com.tangodachi.yava.utils

import org.koin.core.annotation.Factory

@Factory
class GenerateCodeMock : GenerateCode {
    lateinit var code: String

    override operator fun invoke(): String = code
}