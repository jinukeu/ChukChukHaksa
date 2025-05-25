package com.chukchukhaksa.moblie.local.common.database.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual class TimetableDatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<TimetableDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(DatabaseName.TIMETABLE)

        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}