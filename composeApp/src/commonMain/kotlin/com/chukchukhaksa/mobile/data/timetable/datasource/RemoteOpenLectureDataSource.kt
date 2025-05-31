package com.chukchukhaksa.mobile.data.timetable.datasource

import com.chukchukhaksa.mobile.data.timetable.model.OpenLectureRaw

interface RemoteOpenLectureDataSource {
    suspend fun getOpenLectureListVersion(): Long
    suspend fun getOpenLectureList(): List<OpenLectureRaw>
}
