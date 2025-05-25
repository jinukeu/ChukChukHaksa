package com.chukchukhaksa.moblie.domain.timetable.usecase

import com.chukchukhaksa.moblie.domain.common.runCatchingIgnoreCancelled

class UpdateOpenLectureIfNeedUseCase {
    suspend operator fun invoke(): Result<Unit> = runCatchingIgnoreCancelled {
    }
}