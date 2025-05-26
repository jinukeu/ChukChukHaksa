package com.chukchukhaksa.mobile.domain.timetable.usecase

import com.chukchukhaksa.mobile.common.model.Timetable


class DeleteTimetableUseCase {
    suspend operator fun invoke(timetable: Timetable): Result<Unit> = Result.success(Unit)
}