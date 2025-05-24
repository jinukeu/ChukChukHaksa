package com.chukchukhaksa.moblie.presentation.timetable.celleditor

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.chukchukhaksa.moblie.common.model.TimetableCellColor
import com.chukchukhaksa.moblie.common.model.TimetableDay
import com.chukchukhaksa.moblie.common.ui.MviStore
import com.chukchukhaksa.moblie.common.ui.decodeFromUri
import com.chukchukhaksa.moblie.common.ui.mviStore
import com.chukchukhaksa.moblie.presentation.timetable.navigation.TimetableRoute
import com.chukchukhaksa.moblie.presentation.timetable.navigation.argument.CellEditorArgument
import kotlinx.serialization.json.Json

class CellEditorViewModel(
//  private val insertTimetableCellUseCase: InsertTimetableCellUseCase,
//  private val updateTimetableCellUseCase: UpdateTimetableCellUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val argument = savedStateHandle.get<String>(TimetableRoute.CELL_EDITOR_ARGUMENT)!!
    private val cellEditorArgument = Json.decodeFromUri<CellEditorArgument>(argument)
    private val isEditMode = cellEditorArgument.isEditMode

    val mviStore: MviStore<CellEditorState, CellEditorSideEffect> = mviStore(
        cellEditorArgument.toState(),
    )

    fun updateCellColor(color: TimetableCellColor) {
//        reduce { state.copy(selectedTimetableCellColor = color) }
    }

    fun addCell() {
//        reduce {
//            state.copy(
//                cellStateList = state.cellStateList.add(CellState()),
//            )
//        }
    }

    fun deleteCell(index: Int) {
//        reduce {
//            state.copy(
//                cellStateList = state.cellStateList.removeAt(index),
//            )
//        }
    }

    fun updateCellLocation(index: Int, location: String) {
//        val toUpdateCell = state.cellStateList[index].copy(location = location)
//        reduceCell(index, toUpdateCell)
    }

    fun updateCellEndPeriod(index: Int, endPeriod: String) {
//        val toUpdateCell = state.cellStateList[index].copy(endPeriod = endPeriod.toPeriod())
//        reduceCell(index, toUpdateCell)
    }

    fun updateCellStartPeriod(index: Int, startPeriod: String) {
//        val toUpdateCell = state.cellStateList[index].copy(startPeriod = startPeriod.toPeriod())
//        reduceCell(index, toUpdateCell)
    }

    private fun String.toPeriod(): String {
        return toIntOrNull()?.let {
            when {
                it < 1 -> "1"
                it > 15 -> "15"
                else -> this
            }
        } ?: ""
    }

    fun updateCellDay(index: Int, day: TimetableDay) {
//        val toUpdateCell = state.cellStateList[index].copy(day = day)
//        reduceCell(index, toUpdateCell)
    }

    private suspend fun reduceCell(
        index: Int,
        toUpdateCell: CellState,
    ) {
//        val cellList = state.cellStateList.removeAt(index)
//        reduce {
//            state.copy(
//                cellStateList = cellList.add(index, toUpdateCell),
//            )
//        }
    }

    fun updateLectureName(lectureName: String) {
//        reduce {
//            state.copy(lectureName = lectureName)
//        }
    }

    fun updateProfessorName(professorName: String) {
//        reduce {
//            state.copy(professorName = professorName)
//        }
    }

    fun upsertTimetable() {
//        val sideEffect = when {
//            state.lectureName.isEmpty() -> CellEditorSideEffect.ShowNeedLectureNameToast
//            state.professorName.isEmpty() -> CellEditorSideEffect.ShowNeedProfessorNameToast
//            state.cellStateList.any { it.location.isEmpty() } -> CellEditorSideEffect.ShowNeedLocationToast
//            else -> null
//        }
//
//        sideEffect?.run {
//            postSideEffect(this)
//            return@intent
//        }
//
//        val timetableCellList = if (state.cellStateList.isEmpty()) {
//            listOf(
//                TimetableCell(
//                    name = state.lectureName,
//                    professor = state.professorName,
//                    location = "",
//                    day = TimetableDay.E_LEARNING,
//                    startPeriod = 0,
//                    endPeriod = 0,
//                    color = state.selectedTimetableCellColor,
//                ),
//            )
//        } else {
//            state.cellStateList.map { cell ->
//                TimetableCell(
//                    name = state.lectureName,
//                    professor = state.professorName,
//                    location = cell.location,
//                    day = cell.day,
//                    startPeriod = cell.startPeriod.toIntOrNull() ?: 0,
//                    endPeriod = cell.endPeriod.toIntOrNull() ?: 0,
//                    color = state.selectedTimetableCellColor,
//                )
//            }
//        }
//
//        val useCase = if (isEditMode) {
//            updateTimetableCellUseCase(
//                UpdateTimetableCellUseCase.Param(
//                    cellEditorArgument.oldCellId,
//                    timetableCellList,
//                ),
//            )
//        } else {
//            insertTimetableCellUseCase(timetableCellList)
//        }
//
//        useCase
//            .onSuccess {
//                if (isEditMode) {
//                    postSideEffect(CellEditorSideEffect.ShowEditSuccessCellToast)
//                } else {
//                    postSideEffect(CellEditorSideEffect.ShowAddSuccessCellToast)
//                }
//
//                popBackStack()
//            }
//            .onFailure { throwable ->
//                when (throwable) {
//                    is TimetableCellOverlapException -> postSideEffect(
//                        CellEditorSideEffect.ShowToast(
//                            throwable.message
//                        )
//                    )
//
//                    is TimetableCellPeriodInvalidException -> postSideEffect(
//                        CellEditorSideEffect.ShowToast(
//                            throwable.message
//                        )
//                    )
//
//                    else -> postSideEffect(CellEditorSideEffect.HandleException(throwable))
//                }
//            }
    }

    fun popBackStack() {
//        postSideEffect(CellEditorSideEffect.PopBackStack)
    }
}
