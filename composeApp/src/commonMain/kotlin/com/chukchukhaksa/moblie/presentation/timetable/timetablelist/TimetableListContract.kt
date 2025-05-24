package com.chukchukhaksa.moblie.presentation.timetable.timetablelist

import com.chukchukhaksa.moblie.common.model.Timetable
import com.chukchukhaksa.moblie.presentation.timetable.navigation.argument.TimetableEditorArgument
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class TimetableListState(
    val timetableList: PersistentList<Timetable> = persistentListOf(),
    val showDeleteDialog: Boolean = false,
)

sealed interface TimetableListSideEffect {
    data class HandleException(val throwable: Throwable) : TimetableListSideEffect
    data class NavigateTimetableEditor(val argument: TimetableEditorArgument) :
        TimetableListSideEffect

    data object PopBackStack : TimetableListSideEffect
}
