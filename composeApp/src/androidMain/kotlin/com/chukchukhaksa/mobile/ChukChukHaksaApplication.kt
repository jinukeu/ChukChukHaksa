package com.chukchukhaksa.mobile

import android.app.Application
import com.chukchukhaksa.mobile.di.initKoin
import org.koin.android.ext.koin.androidContext

class ChukChukHaksaApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@ChukChukHaksaApplication)
        }
    }
}