package com.chukchukhaksa.mobile.domain.timetable.usecase

import com.chukchukhaksa.mobile.domain.common.runCatchingIgnoreCancelled

class UpdateOpenLectureIfNeedUseCase {
    suspend operator fun invoke(): Result<Unit> = runCatchingIgnoreCancelled {
    }
}