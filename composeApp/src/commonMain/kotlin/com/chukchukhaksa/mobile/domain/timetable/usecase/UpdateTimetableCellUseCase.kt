package com.chukchukhaksa.mobile.domain.timetable.usecase

import com.chukchukhaksa.mobile.common.model.TimetableCell

class UpdateTimetableCellUseCase() {
    suspend operator fun invoke(param: Param): Result<Unit> = Result.success(Unit)

    data class Param(
        val oldCellId: String,
        val cellList: List<TimetableCell>,
    )
}