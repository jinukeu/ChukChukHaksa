package com.chukchukhaksa.mobile.remote.timetable

import com.chukchukhaksa.mobile.data.timetable.datasource.RemoteOpenLectureDataSource
import org.koin.dsl.module

val remoteTimetableDataSourceModule = module {
  single<RemoteOpenLectureDataSource> { RemoteOpenLectureDataSourceImpl() }
}
