package com.chukchukhaksa.moblie.domain.timetable.usecase

import com.chukchukhaksa.moblie.common.model.Timetable
import com.chukchukhaksa.moblie.common.model.TimetableCell

class DeleteTimetableCellUseCase {
    suspend operator fun invoke(cell: TimetableCell): Result<Timetable> =
        Result.success(Timetable())
}