package com.chukchukhaksa.mobile.local.datasource.timetable.converter

import com.chukchukhaksa.mobile.common.model.Timetable
import com.chukchukhaksa.mobile.local.common.database.entity.TimetableEntity

fun Timetable.toEntity() = TimetableEntity(
    createTime = createTime,
    year = year,
    semester = semester,
    name = name,
    cellList = cellList,
)
