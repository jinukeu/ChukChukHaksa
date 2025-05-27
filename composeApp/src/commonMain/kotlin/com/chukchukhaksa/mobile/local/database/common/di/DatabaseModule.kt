/*
 * Copyright 2025 easyhooon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chukchukhaksa.mobile.local.common.database.timetable.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.chukchukhaksa.mobile.local.database.timetable.database.TimetableDatabase
import com.chukchukhaksa.mobile.local.database.timetable.database.TimetableDatabaseFactory
import com.chukchukhaksa.mobile.local.common.database.timetable.migration.TIMETABLE_MIGRATION_1_2
import com.chukchukhaksa.mobile.local.database.openlecture.database.OpenLectureDatabase
import com.chukchukhaksa.mobile.local.database.openlecture.database.OpenLectureDatabaseFactory
import com.chukchukhaksa.mobile.local.database.openmajor.database.OpenMajorDatabase
import com.chukchukhaksa.mobile.local.database.openmajor.database.OpenMajorDatabaseFactory
import org.koin.dsl.module

val databaseModule =
    module {
        timetableDatabaseModule
        openMajorDatabaseModule
        openLectureDatabaseModule
    }

val timetableDatabaseModule = module {
    single {
        get<TimetableDatabaseFactory>()
            .create()
            .addMigrations(TIMETABLE_MIGRATION_1_2)
            .fallbackToDestructiveMigration(true)
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<TimetableDatabase>().timetableDao() }
}

val openMajorDatabaseModule = module {
    single {
        get<OpenMajorDatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<OpenMajorDatabase>().openMajorDao() }
}

val openLectureDatabaseModule = module {
    single {
        get<OpenLectureDatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<OpenLectureDatabase>().openLectureDao() }
}
