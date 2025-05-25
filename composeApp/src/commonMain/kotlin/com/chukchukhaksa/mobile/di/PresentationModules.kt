package com.chukchukhaksa.mobile.di

import com.chukchukhaksa.mobile.MainViewModel
import com.chukchukhaksa.mobile.presentation.openmajor.OpenMajorViewModel
import com.chukchukhaksa.mobile.presentation.timetable.celleditor.CellEditorViewModel
import com.chukchukhaksa.mobile.presentation.timetable.openlecture.OpenLectureViewModel
import com.chukchukhaksa.mobile.presentation.timetable.timetable.TimetableViewModel
import com.chukchukhaksa.mobile.presentation.timetable.timetablelist.TimetableListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::TimetableViewModel)
    viewModelOf(::TimetableListViewModel)
    viewModelOf(::MainViewModel)
    viewModelOf(::CellEditorViewModel)
    viewModelOf(::OpenLectureViewModel)
    viewModelOf(::OpenMajorViewModel)
}