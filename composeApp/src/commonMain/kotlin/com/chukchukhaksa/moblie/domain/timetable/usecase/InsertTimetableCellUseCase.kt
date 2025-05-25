package com.chukchukhaksa.moblie.domain.timetable.usecase

import com.chukchukhaksa.moblie.common.model.TimetableCell

class InsertTimetableCellUseCase{
    suspend operator fun invoke(cellList: List<TimetableCell>): Result<Unit> = Result.success(Unit)
}