package com.chukchukhaksa.mobile.di

import com.chukchukhaksa.mobile.local.datastore.di.dataStoreModule
import org.koin.dsl.module

val dataModule = module {
    dataStoreModule
}