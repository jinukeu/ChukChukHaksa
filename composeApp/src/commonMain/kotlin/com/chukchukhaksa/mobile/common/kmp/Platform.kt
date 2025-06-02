package com.chukchukhaksa.mobile.common.kmp

enum class Platform {
    Android,
    iOS
}

expect fun getPlatform(): Platform