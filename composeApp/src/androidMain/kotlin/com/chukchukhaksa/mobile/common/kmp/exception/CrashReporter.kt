@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.chukchukhaksa.mobile.common.kmp.exception

import com.google.firebase.ktx.Firebase
import com.google.firebase.crashlytics.ktx.crashlytics
import io.github.aakira.napier.Napier

actual object CrashReporter {
    actual fun recordException(throwable: Throwable) {
        Napier.d("exception: $throwable", tag = "CrashReporter")
        Firebase.crashlytics.recordException(throwable)
    }
}