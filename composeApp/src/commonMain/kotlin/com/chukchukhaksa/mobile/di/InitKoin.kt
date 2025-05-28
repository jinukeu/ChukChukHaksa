package com.chukchukhaksa.mobile.di

import com.chukchukhaksa.mobile.data.timetable.di.timetableRepositoryModule
import com.chukchukhaksa.mobile.local.database.common.di.databaseModule
import com.chukchukhaksa.mobile.local.database.common.di.openLectureDatabaseModule
import com.chukchukhaksa.mobile.local.database.common.di.openMajorDatabaseModule
import com.chukchukhaksa.mobile.local.database.common.di.timetableDatabaseModule
import com.chukchukhaksa.mobile.local.datasource.timetable.di.localTimetableDataSourceModule
import com.chukchukhaksa.mobile.local.datastore.di.dataStoreModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            domainModule,
            dataStoreModule,
            timetableDatabaseModule,
            openMajorDatabaseModule,
            openLectureDatabaseModule,
            localTimetableDataSourceModule,
            timetableRepositoryModule,
            presentationModule
        )
    }
}
