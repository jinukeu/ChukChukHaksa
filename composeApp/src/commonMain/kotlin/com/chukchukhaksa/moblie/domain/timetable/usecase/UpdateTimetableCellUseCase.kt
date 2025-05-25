package com.chukchukhaksa.moblie.domain.timetable.usecase

import com.chukchukhaksa.moblie.common.model.TimetableCell
import com.chukchukhaksa.moblie.domain.common.runCatchingIgnoreCancelled

class UpdateTimetableCellUseCase() {
    suspend operator fun invoke(param: Param): Result<Unit> = Result.success(Unit)

    data class Param(
        val oldCellId: String,
        val cellList: List<TimetableCell>,
    )
}