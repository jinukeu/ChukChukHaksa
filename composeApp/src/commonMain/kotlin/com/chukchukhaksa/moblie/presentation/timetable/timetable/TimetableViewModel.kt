package com.chukchukhaksa.moblie.presentation.timetable.timetable

import androidx.lifecycle.ViewModel
import com.chukchukhaksa.moblie.common.model.TimetableCell
import com.chukchukhaksa.moblie.common.ui.mviStore

class TimetableViewModel(
) : ViewModel() {
    val mviStore = mviStore<TimetableState, TimetableSideEffect>(TimetableState())

    fun getMainTimetable() {
//    val cellType = TimetableCellType.getType(getTimetableCellTypeUseCase().getOrNull())
//
//    getMainTimetableUseCase()
//      .onSuccess { timetable ->
//        reduce {
//          state.copy(
//            timetable = timetable,
//            cellType = cellType,
//            showTimetableEmptyColumn = timetable == null,
//          )
//        }
//      }
//      .onFailure {
//        postSideEffect(TimetableSideEffect.HandleException(it))
//      }
    }

    fun deleteCell(cell: TimetableCell) {
//    deleteTimetableCellUseCase(cell)
//      .onSuccess {
//        reduce {
//          state.copy(
//            showEditCellBottomSheet = false,
//            timetable = it,
//          )
//        }
//      }
//      .onFailure { postSideEffect(TimetableSideEffect.HandleException(it)) }
    }

    fun showEditCellBottomSheet(cell: TimetableCell) {
//    reduce {
//      state.copy(
//        showEditCellBottomSheet = true,
//        selectedCell = cell,
//      )
//    }
    }

    fun updateCellType(position: Int) {
//    val cellType = TimetableCellType.entries[position]
//    setTimetableCellTypeUseCase(cellType.name)
//      .onSuccess { reduce { state.copy(cellType = cellType) } }
    }

    fun showSelectCellTypeBottomSheet() {
//        reduce { state.copy(showSelectCellTypeBottomSheet = true) }
    }

    fun hideSelectCellTypeBottomSheet() {
//        reduce { state.copy(showSelectCellTypeBottomSheet = false) }
    }

    fun navigateCellEdit(cell: TimetableCell) {
//        postSideEffect(TimetableSideEffect.NavigateCellEditor(cell.toCellEditorArgument()))
    }

    fun hideEditCellBottomSheet() {
//        reduce { state.copy(showEditCellBottomSheet = false) }
    }

    fun navigateTimetableEditor() {
//        postSideEffect(TimetableSideEffect.NavigateTimetableEditor)
    }

    fun navigateTimetableList() {
//        postSideEffect(TimetableSideEffect.NavigateTimetableList)
    }

    fun navigateAddTimetableCell() {
//        if (state.timetable == null) {
//            postSideEffect(TimetableSideEffect.ShowNeedCreateTimetableToast)
//        } else {
//            postSideEffect(TimetableSideEffect.NavigateAddTimetableCell)
//        }
    }
}
