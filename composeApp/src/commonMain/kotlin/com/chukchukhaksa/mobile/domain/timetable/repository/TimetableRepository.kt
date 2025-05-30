package com.chukchukhaksa.mobile.domain.timetable.repository

import com.chukchukhaksa.mobile.common.model.Timetable
import com.chukchukhaksa.mobile.common.model.TimetableCell

interface TimetableRepository {
    suspend fun getAllTimetable(): List<Timetable>

    suspend fun getTimetable(createTime: Long): Timetable?

    suspend fun setMainTimetableCreateTime(createTime: Long)

    suspend fun getMainTimetableCreateTime(): Long?

    suspend fun deleteTimetable(data: Timetable)

    suspend fun updateTimetable(
        createTime: Long,
        year: String,
        semester: String,
        name: String,
    )

    suspend fun insertTimetable(data: Timetable)

    suspend fun insertTimetableCell(cellList: List<TimetableCell>)

    suspend fun deleteTimetableCell(cell: TimetableCell): Timetable

    suspend fun updateTimetableCell(oldCellId: String, cellList: List<TimetableCell>)

    suspend fun getTimetableCellType(): String
    suspend fun setTimetableCellType(type: String)
}