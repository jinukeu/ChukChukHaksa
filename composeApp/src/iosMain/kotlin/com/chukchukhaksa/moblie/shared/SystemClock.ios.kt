package com.chukchukhaksa.moblie.shared

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual object SystemClock {
    actual fun currentTimeMillis(): Long {
        return (NSDate().timeIntervalSince1970 * 1000).toLong()
    }
}