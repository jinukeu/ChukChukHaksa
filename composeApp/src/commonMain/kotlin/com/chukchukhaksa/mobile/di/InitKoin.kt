package com.chukchukhaksa.mobile.di

import com.chukchukhaksa.mobile.local.common.database.timetable.di.databaseModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            domainModule,
            dataModule,
            databaseModule,
            presentationModule
//            platformModule -> 각 플랫폼 별로 module이 다른 경우
        )
    }
}