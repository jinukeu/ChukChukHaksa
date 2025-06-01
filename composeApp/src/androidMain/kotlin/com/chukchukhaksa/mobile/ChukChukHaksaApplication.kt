package com.chukchukhaksa.mobile

import android.app.Application
import com.chukchukhaksa.mobile.di.initKoin
import com.google.firebase.Firebase
import com.google.firebase.initialize
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext

class ChukChukHaksaApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Napier.base(DebugAntilog())
        }

        initKoin {
            androidContext(this@ChukChukHaksaApplication)
        }

        Firebase.initialize(this)
    }
}