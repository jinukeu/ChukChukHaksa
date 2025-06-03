@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.chukchukhaksa.mobile.common.kmp.exception

expect object CrashReporter {
    fun recordException(throwable: Throwable)
}