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

package com.chukchukhaksa.moblie.local.common.database.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.chukchukhaksa.moblie.local.common.database.database.TimetableDatabase
import com.chukchukhaksa.moblie.local.common.database.database.TimetableDatabaseFactory
import com.chukchukhaksa.moblie.local.common.database.migration.TIMETABLE_MIGRATION_1_2
import org.koin.dsl.module

val databaseModule =
    module {
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
