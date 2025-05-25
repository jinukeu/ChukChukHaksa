package com.chukchukhaksa.moblie.domain.timetable.usecase

import com.chukchukhaksa.moblie.common.model.Timetable
import com.chukchukhaksa.moblie.common.model.TimetableCell
import com.chukchukhaksa.moblie.common.model.TimetableCellColor

class GetAllTimetableUseCase {
    suspend operator fun invoke(): Result<List<Timetable>> = Result.success(
        listOf(
            Timetable(
                createTime = 0,
                year = "2025",
                semester = "1",
                name = "왕덕팔 시간표",
                cellList = listOf(TimetableCell(color = TimetableCellColor.GRAY)),
            )
        )
    )
}