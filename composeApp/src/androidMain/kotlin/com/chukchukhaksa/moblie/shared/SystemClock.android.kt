package com.chukchukhaksa.moblie.shared

actual object SystemClock {
    actual fun currentTimeMillis(): Long = System.currentTimeMillis()
}