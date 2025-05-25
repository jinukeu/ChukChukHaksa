package com.chukchukhaksa.mobile.common.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform