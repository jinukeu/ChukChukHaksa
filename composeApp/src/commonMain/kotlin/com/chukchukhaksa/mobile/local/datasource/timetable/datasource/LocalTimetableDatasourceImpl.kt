package com.chukchukhaksa.mobile.local.datasource.timetable.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.chukchukhaksa.mobile.common.model.Timetable
import com.chukchukhaksa.mobile.data.timetable.datasource.LocalTimetableDataSource
import com.chukchukhaksa.mobile.local.database.timetable.database.TimetableDatabase
import com.chukchukhaksa.mobile.local.datasource.timetable.converter.toEntity
import com.chukchukhaksa.mobile.local.datasource.timetable.converter.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class LocalTimetableDatasourceImpl(
    private val dataStore: DataStore<Preferences>,
    private val timetableDatabase: TimetableDatabase,
) : LocalTimetableDataSource {
    private val ioDispatcher = Dispatchers.IO

    companion object {
        private val MAIN_TIMETABLE_CREATE_TIME =
            longPreferencesKey("[KEY] is main timetable create time")
        private val TIMETABLE_CELL_TYPE = stringPreferencesKey("[KEY] is main timetable cell type")
    }

    private val data: Flow<Preferences>
        get() = dataStore.data

    override suspend fun getAllTimetable(): List<Timetable> = withContext(ioDispatcher) {
        timetableDatabase.timetableDao().getAll().map { it.toModel() }
    }

    override suspend fun getTimetable(createTime: Long): Timetable? = withContext(ioDispatcher) {
        timetableDatabase.timetableDao().get(createTime)?.toModel()
    }

    override suspend fun deleteAllTimetable() = withContext(ioDispatcher) {
        timetableDatabase.timetableDao().deleteAll()
    }

    override suspend fun deleteTimetable(data: Timetable) = withContext(ioDispatcher) {
        timetableDatabase.timetableDao().delete(data.toEntity())
    }

    override suspend fun updateTimetable(data: Timetable) = withContext(ioDispatcher) {
        timetableDatabase.timetableDao().update(data.toEntity())
    }

    override suspend fun insertTimetable(data: Timetable) {
        timetableDatabase.timetableDao().insert(data.toEntity())
    }

    override suspend fun setMainTimetableCreateTime(createTime: Long) {
        dataStore.edit { it[MAIN_TIMETABLE_CREATE_TIME] = createTime }
    }

    override suspend fun getMainTimetableCreateTime(): Flow<Long?> {
        return data.map { it[MAIN_TIMETABLE_CREATE_TIME] }
    }

    override suspend fun getTimetableCellType(): Flow<String> {
        return data.map { it[TIMETABLE_CELL_TYPE] ?: "" }
    }

    override suspend fun setTimetableCellType(type: String) {
        dataStore.edit { it[TIMETABLE_CELL_TYPE] = type }
    }
}
