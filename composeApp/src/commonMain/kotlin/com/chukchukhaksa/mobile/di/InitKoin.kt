package com.chukchukhaksa.mobile.di

import com.chukchukhaksa.mobile.local.database.common.di.databaseModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            domainModule,
            dataModule,
            presentationModule
        )
    }
}
