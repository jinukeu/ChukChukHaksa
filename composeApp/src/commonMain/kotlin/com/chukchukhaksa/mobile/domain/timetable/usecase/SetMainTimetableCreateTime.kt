package com.chukchukhaksa.mobile.domain.timetable.usecase

class SetMainTimetableCreateTime{
    suspend operator fun invoke(createTime: Long): Result<Unit> = Result.success(Unit)
}