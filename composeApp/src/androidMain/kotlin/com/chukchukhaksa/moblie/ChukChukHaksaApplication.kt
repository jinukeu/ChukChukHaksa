package com.chukchukhaksa.moblie

import android.app.Application
import com.chukchukhaksa.moblie.di.initKoin
import org.koin.android.ext.koin.androidContext

class ChukChukHaksaApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@ChukChukHaksaApplication)
        }
    }
}