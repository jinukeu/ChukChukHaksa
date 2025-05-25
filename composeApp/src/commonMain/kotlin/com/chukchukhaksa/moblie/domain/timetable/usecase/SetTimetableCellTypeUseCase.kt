package com.chukchukhaksa.moblie.domain.timetable.usecase

import com.chukchukhaksa.moblie.domain.common.runCatchingIgnoreCancelled

class SetTimetableCellTypeUseCase{
    suspend operator fun invoke(type: String) = runCatchingIgnoreCancelled {
    }
}