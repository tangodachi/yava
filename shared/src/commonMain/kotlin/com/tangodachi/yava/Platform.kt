package com.tangodachi.yava

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform