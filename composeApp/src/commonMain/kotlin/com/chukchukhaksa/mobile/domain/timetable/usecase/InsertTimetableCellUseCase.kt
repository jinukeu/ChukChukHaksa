package com.chukchukhaksa.mobile.domain.timetable.usecase

import com.chukchukhaksa.mobile.common.model.TimetableCell

class InsertTimetableCellUseCase{
    suspend operator fun invoke(cellList: List<TimetableCell>): Result<Unit> = Result.success(Unit)
}