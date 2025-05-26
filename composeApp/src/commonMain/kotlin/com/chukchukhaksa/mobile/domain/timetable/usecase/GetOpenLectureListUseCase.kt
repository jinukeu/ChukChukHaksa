package com.chukchukhaksa.mobile.domain.timetable.usecase

import com.chukchukhaksa.mobile.common.model.Cell
import com.chukchukhaksa.mobile.common.model.OpenLecture
import com.chukchukhaksa.mobile.common.model.TimetableDay
import kotlinx.coroutines.flow.flow

class GetOpenLectureListUseCase() {
    operator fun invoke(param: Param) =
        flow {
            emit(
                listOf(
                    OpenLecture(
                        id = -1L,
                        name = "캡스톤 디자인",
                        type = "전공",
                        major = "컴퓨터공학",
                        grade = 3,
                        professorName = "왕덕팔",
                        originalCellList = listOf(
                            Cell(
                                location = "IT401",
                                day = TimetableDay.WED,
                                startPeriod = 1,
                                endPeriod = 3,
                            )
                        )
                    )
                )
            )
        }

    data class Param(
        val lectureOrProfessorName: String?,
        val major: String?,
        val grade: Int?,
    )
}