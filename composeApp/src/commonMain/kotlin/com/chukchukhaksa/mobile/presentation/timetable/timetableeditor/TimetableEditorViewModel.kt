package com.chukchukhaksa.mobile.presentation.timetable.timetableeditor

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.chukchukhaksa.mobile.common.ui.MviStore
import com.chukchukhaksa.mobile.common.ui.decodeFromUri
import com.chukchukhaksa.mobile.common.ui.mviStore
import com.chukchukhaksa.mobile.presentation.timetable.navigation.TimetableRoute
import com.chukchukhaksa.mobile.presentation.timetable.navigation.argument.TimetableEditorArgument
import kotlinx.serialization.json.Json

class TimetableEditorViewModel(
//  private val insertTimetableUseCase: InsertTimetableUseCase,
//  private val updateTimetableUseCase: UpdateTimetableUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val argument = savedStateHandle.get<String>(TimetableRoute.TIMETABLE_EDITOR_ARGUMENT)!!
    private val timetableEditorArgument = Json.decodeFromUri<TimetableEditorArgument>(argument)
    private val isEditMode = timetableEditorArgument.isEditMode
    val mviStore: MviStore<TimetableEditorState, TimetableEditorSideEffect> = mviStore(
        timetableEditorArgument.toState(),
    )

    fun showSemesterBottomSheet() {
//        reduce { state.copy(isSheetOpenSemester = true) }
    }

    fun hideSemesterBottomSheet() {
//        reduce { state.copy(isSheetOpenSemester = false) }
    }

    fun updateSemesterPosition(position: Int) {
//        reduce { state.copy(selectedSemesterPosition = position) }
    }

    fun updateName(name: String) {
//        reduce { state.copy(name = name) }
    }

    fun upsertTimetable() {
//        if (state.semester == null) {
//            postSideEffect(TimetableEditorSideEffect.NeedSelectSemesterToast)
//            return@intent
//        }
//
//        val useCase = if (isEditMode) {
//            updateTimetableUseCase(
//                param = UpdateTimetableUseCase.Param(
//                    createTime = timetableEditorArgument.createTime,
//                    name = state.name,
//                    year = state.semester!!.year,
//                    semester = state.semester!!.semester,
//                ),
//            )
//        } else {
//            insertTimetableUseCase(
//                param = InsertTimetableUseCase.Param(
//                    name = state.name,
//                    year = state.semester!!.year,
//                    semester = state.semester!!.semester,
//                ),
//            )
//        }
//
//        useCase
//            .onSuccess {
//                postSideEffect(TimetableEditorSideEffect.PopBackStack)
//            }.onFailure {
//                postSideEffect(TimetableEditorSideEffect.HandleException(it))
//            }
    }

    fun popBackStack() {
//        postSideEffect(TimetableEditorSideEffect.PopBackStack)
    }
}
