package com.chukchukhaksa.mobile.data.timetable.di

import com.chukchukhaksa.mobile.data.timetable.repository.TimetableRepositoryImpl
import com.chukchukhaksa.mobile.domain.timetable.repository.TimetableRepository
import org.koin.dsl.module

val timetableRepositoryModule = module {
//    single<OpenLectureRepository> { OpenLectureRepositoryImpl(get(), get()) }
    single<TimetableRepository> { TimetableRepositoryImpl(get()) }
}
