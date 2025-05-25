package com.chukchukhaksa.mobile.local.common.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chukchukhaksa.mobile.local.common.database.converter.TimetableCellListConverter
import com.chukchukhaksa.mobile.local.common.database.dao.TimeTableDao
import com.chukchukhaksa.mobile.local.common.database.entity.TimetableEntity

@Database(
    entities = [TimetableEntity::class],
    version = 2,
)
@TypeConverters(
    value = [TimetableCellListConverter::class],
)
abstract class TimetableDatabase : RoomDatabase() {
    abstract fun timetableDao(): TimeTableDao
}
