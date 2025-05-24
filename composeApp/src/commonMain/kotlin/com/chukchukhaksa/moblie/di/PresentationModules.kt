package com.chukchukhaksa.moblie.di

import com.chukchukhaksa.moblie.MainViewModel
import com.chukchukhaksa.moblie.presentation.timetable.celleditor.CellEditorViewModel
import com.chukchukhaksa.moblie.presentation.timetable.openlecture.OpenLectureViewModel
import com.chukchukhaksa.moblie.presentation.timetable.timetable.TimetableViewModel
import com.chukchukhaksa.moblie.presentation.timetable.timetablelist.TimetableListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::TimetableViewModel)
    viewModelOf(::TimetableListViewModel)
    viewModelOf(::MainViewModel)
    viewModelOf(::CellEditorViewModel)
    viewModelOf(::OpenLectureViewModel)
}