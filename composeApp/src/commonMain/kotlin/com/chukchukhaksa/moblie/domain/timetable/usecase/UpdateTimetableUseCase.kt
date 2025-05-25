package com.chukchukhaksa.moblie.domain.timetable.usecase

class UpdateTimetableUseCase{
    suspend operator fun invoke(param: Param): Result<Unit> = Result.success(Unit)

    data class Param(
        val createTime: Long,
        val year: String,
        val semester: String,
        val name: String,
    )
}