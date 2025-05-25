package com.chukchukhaksa.moblie.domain.timetable.usecase

import com.chukchukhaksa.moblie.common.model.Timetable


class DeleteTimetableUseCase {
    suspend operator fun invoke(timetable: Timetable): Result<Unit> = Result.success(Unit)
}