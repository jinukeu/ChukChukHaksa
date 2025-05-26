package com.chukchukhaksa.mobile.di

import com.chukchukhaksa.mobile.domain.openmajor.usecase.GetOpenMajorListUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.DeleteTimetableCellUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.DeleteTimetableUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.GetAllTimetableUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.GetMainTimetableUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.GetOpenLectureListUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.GetTimetableCellTypeUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.InsertTimetableCellUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.InsertTimetableUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.SetMainTimetableCreateTime
import com.chukchukhaksa.mobile.domain.timetable.usecase.SetTimetableCellTypeUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.UpdateOpenLectureIfNeedUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.UpdateTimetableCellUseCase
import com.chukchukhaksa.mobile.domain.timetable.usecase.UpdateTimetableUseCase
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