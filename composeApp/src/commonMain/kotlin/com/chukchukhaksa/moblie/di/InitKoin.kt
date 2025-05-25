package com.chukchukhaksa.moblie.di

import com.chukchukhaksa.moblie.local.common.database.di.databaseModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
//            공통으로 사용되는 module
            domainModule,
//            dataModule,
            databaseModule,
            presentationModule
//            platformModule -> 각 플랫폼 별로 module이 다른 경우
        )
    }
}