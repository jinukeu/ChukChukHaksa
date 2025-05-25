package com.chukchukhaksa.mobile.domain.timetable.usecase

import com.chukchukhaksa.mobile.domain.common.runCatchingIgnoreCancelled

class SetTimetableCellTypeUseCase{
    suspend operator fun invoke(type: String) = runCatchingIgnoreCancelled {
    }
}