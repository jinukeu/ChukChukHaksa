package com.chukchukhaksa.mobile.domain.timetable.usecase

class InsertTimetableUseCase{
    suspend operator fun invoke(param: Param): Result<Unit> = Result.success(Unit)

    data class Param(
        val name: String,
        val year: String,
        val semester: String,
    )
}