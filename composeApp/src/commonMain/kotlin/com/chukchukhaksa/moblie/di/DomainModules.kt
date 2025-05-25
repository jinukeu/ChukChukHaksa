package com.chukchukhaksa.moblie.di

import com.chukchukhaksa.moblie.domain.openmajor.usecase.GetOpenMajorListUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.DeleteTimetableCellUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.DeleteTimetableUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.GetAllTimetableUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.GetMainTimetableUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.GetOpenLectureListUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.GetTimetableCellTypeUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.InsertTimetableCellUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.InsertTimetableUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.SetMainTimetableCreateTime
import com.chukchukhaksa.moblie.domain.timetable.usecase.SetTimetableCellTypeUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.UpdateOpenLectureIfNeedUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.UpdateTimetableCellUseCase
import com.chukchukhaksa.moblie.domain.timetable.usecase.UpdateTimetableUseCase
import org.koin.dsl.module

val domainModule = module {
    /*TODO("factory / single 생성 방식 검토 필요")*/
    /*TODO("UseCase(인자 추가 되면 get() 함수 추가)")*/

    // OpenMajor
    factory { GetOpenMajorListUseCase() }

    // Timetable
    factory { DeleteTimetableUseCase() }
    factory { GetAllTimetableUseCase() }
    factory { GetMainTimetableUseCase() }
    factory { InsertTimetableUseCase() }
    factory { UpdateTimetableUseCase() }
    factory { SetMainTimetableCreateTime() }

    // Timetable cell use cases
    factory { DeleteTimetableCellUseCase() }
    factory { InsertTimetableCellUseCase() }
    factory { UpdateTimetableCellUseCase() }
    factory { GetTimetableCellTypeUseCase() }
    factory { SetTimetableCellTypeUseCase() }

    // Open lecture use cases
    factory { GetOpenLectureListUseCase() }
    factory { UpdateOpenLectureIfNeedUseCase() }
}