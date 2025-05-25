package com.chukchukhaksa.mobile.domain.timetable.usecase

import com.chukchukhaksa.mobile.common.model.Timetable
import com.chukchukhaksa.mobile.common.model.TimetableCell

class DeleteTimetableCellUseCase {
    suspend operator fun invoke(cell: TimetableCell): Result<Timetable> =
        Result.success(Timetable())
}