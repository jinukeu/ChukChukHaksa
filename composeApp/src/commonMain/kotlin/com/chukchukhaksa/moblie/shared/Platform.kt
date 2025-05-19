package com.chukchukhaksa.moblie.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform