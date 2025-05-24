package com.chukchukhaksa.moblie.presentation.timetable.timetablelist

import androidx.lifecycle.ViewModel
import com.chukchukhaksa.moblie.common.model.Timetable
import com.chukchukhaksa.moblie.common.ui.MviStore
import com.chukchukhaksa.moblie.common.ui.mviStore

class TimetableListViewModel(
//  private val getAllTimetableUseCase: GetAllTimetableUseCase,
//  private val deleteTimetableUseCase: DeleteTimetableUseCase,
//  private val setMainTimetableCreateTime: SetMainTimetableCreateTime,
) : ViewModel() {
    val mviStore: MviStore<TimetableListState, TimetableListSideEffect> =
        mviStore(TimetableListState())
    private var toDeleteTimetable: Timetable? = null

    fun initData() {
//    getAllTimetableUseCase()
//      .onSuccess {
//        reduce { state.copy(timetableList = it.toPersistentList()) }
//      }
//      .onFailure {
//        postSideEffect(TimetableListSideEffect.HandleException(it))
//      }
    }

    fun deleteTimetable() {
//        if (toDeleteTimetable == null) return@intent
//
//        deleteTimetableUseCase(timetable = toDeleteTimetable!!)
//            .onSuccess {
//                reduce { state.copy(timetableList = state.timetableList.minus(toDeleteTimetable!!)) }
//            }
//            .onFailure {
//                postSideEffect(TimetableListSideEffect.HandleException(it))
//            }
//        hideDeleteDialog()
    }

    fun popBackStack() {
        mviStore.postSideEffect(TimetableListSideEffect.PopBackStack)
    }

    fun navigateTimetableEditor(timetable: Timetable) {
//        postSideEffect(TimetableListSideEffect.NavigateTimetableEditor(timetable.toTimetableEditorArgument()))
    }

    fun showDeleteDialog(timetable: Timetable) {
//        toDeleteTimetable = timetable
//        reduce { state.copy(showDeleteDialog = true) }
    }

    fun hideDeleteDialog() {
//        toDeleteTimetable = null
//        reduce { state.copy(showDeleteDialog = false) }
    }

    fun setMainTimetable(createTime: Long) {
//        setMainTimetableCreateTime(createTime)
//            .onSuccess { popBackStack() }
//            .onFailure { postSideEffect(TimetableListSideEffect.HandleException(it)) }
    }
}
