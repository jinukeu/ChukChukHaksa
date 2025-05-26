package com.chukchukhaksa.mobile.presentation.timetable.openlecture

import androidx.lifecycle.ViewModel
import com.chukchukhaksa.mobile.common.model.OpenLecture
import com.chukchukhaksa.mobile.common.model.TimetableCellColor
import com.chukchukhaksa.mobile.common.ui.MviStore
import com.chukchukhaksa.mobile.common.ui.mviStore
import com.chukchukhaksa.mobile.presentation.timetable.openlecture.model.SchoolLevel
import kotlinx.coroutines.sync.Mutex

class OpenLectureViewModel(
//  private val updateOpenLectureIfNeedUseCase: UpdateOpenLectureIfNeedUseCase,
//  private val getOpenLectureListUseCase: GetOpenLectureListUseCase,
//  private val insertTimetableCellUseCase: InsertTimetableCellUseCase,
//  private val openLectureRepository: OpenLectureRepository,
) : ViewModel() {

    private val mutex: Mutex = Mutex()

    val mviStore: MviStore<OpenLectureState, OpenLectureSideEffect> = mviStore(
        OpenLectureState(),
    )

    private val currentState
        get() = mviStore.uiState.value

    private var searchQuery: String = ""
    private var isFirstVisit: Boolean = true

    private var selectedOpenLecture: OpenLecture? = null

    fun initData() {
//        if (isFirstVisit) {
//            reduce { state.copy(isLoading = true) }
//            updateOpenLectureIfNeedUseCase()
//            val lastUpdated = openLectureRepository.getLastUpdatedDate()
//            reduce {
//                state.copy(
//                    lastUpdatedDate = lastUpdated,
//                )
//            }
//            getOpenLectureList()
//            isFirstVisit = false
//        }
    }

    fun navigateCellEditor(openLecture: OpenLecture = OpenLecture()) {
//        postSideEffect(
//            OpenLectureSideEffect.NavigateCellEditor(openLecture.toCellEditorArgument()),
//        )
    }

    fun navigateAddCustomCell() {
//        postSideEffect(OpenLectureSideEffect.NavigateAddCustomTimetableCell)
    }

    fun insertTimetable() {
//        if (selectedOpenLecture == null) return@intent
//
//        val timetableCellList = if (selectedOpenLecture!!.originalCellList.isEmpty()) {
//            listOf(
//                TimetableCell(
//                    name = selectedOpenLecture!!.name,
//                    professor = selectedOpenLecture!!.professorName,
//                    location = "",
//                    day = TimetableDay.E_LEARNING,
//                    startPeriod = 0,
//                    endPeriod = 0,
//                    color = state.selectedTimetableCellColor,
//                ),
//            )
//        } else {
//            selectedOpenLecture!!.originalCellList.map { cell ->
//                TimetableCell(
//                    name = selectedOpenLecture!!.name,
//                    professor = selectedOpenLecture!!.professorName,
//                    location = cell.location,
//                    day = cell.day,
//                    startPeriod = cell.startPeriod,
//                    endPeriod = cell.endPeriod,
//                    color = state.selectedTimetableCellColor,
//                )
//            }
//        }
//
//        insertTimetableCellUseCase(timetableCellList)
//            .onSuccess {
//                postSideEffect(OpenLectureSideEffect.ShowSuccessAddCellToast)
//            }
//            .onFailure {
//                if (it is TimetableCellOverlapException) {
//                    postSideEffect(OpenLectureSideEffect.ShowOverlapCellToast(it.message))
//                } else {
//                    postSideEffect(OpenLectureSideEffect.HandleException(it))
//                }
//            }
    }

    fun updateSelectedCellColor(color: TimetableCellColor) {
//        reduce { state.copy(selectedTimetableCellColor = color) }
    }

    fun showSelectColorBottomSheet(openLecture: OpenLecture) {
//        reduce {
//            selectedOpenLecture = openLecture
//            state.copy(
//                selectedTimetableCellColor = TimetableCellColor.entries.shuffled().first(),
//                showSelectCellColorBottomSheet = true,
//            )
//        }
    }

    fun hideSelectColorBottomSheet() {
//        reduce { state.copy(showSelectCellColorBottomSheet = false) }
    }

    fun searchOpenLecture(search: String) {
//        searchQuery = search
//        getOpenLectureList(search = search)
    }

    fun updateSearchValue(searchValue: String) {
//        reduce { state.copy(searchValue = searchValue) }
    }

    fun updateSchoolLevelPosition(schoolLevel: SchoolLevel) {
//        reduce {
//            state.copy(
//                schoolLevel = schoolLevel,
//            )
//        }
//
//        getOpenLectureList()
    }

    fun updateSelectedOpenMajor(openMajor: String) {
//        if (openMajor == state.selectedOpenMajor) return@intent
//
//        reduce {
//            state.copy(
//                selectedOpenMajor = openMajor,
//            )
//        }
//        getOpenLectureList()
    }

    private fun getOpenLectureList(
        search: String = searchQuery,
    ) {
//        mutex.withLock {
//            val newData = getOpenLectureListUseCase(
//                GetOpenLectureListUseCase.Param(
//                    lectureOrProfessorName = search,
//                    major = if (currentState.selectedOpenMajor == "전체") null else currentState.selectedOpenMajor,
//                    grade = currentState.schoolLevel.query,
//                ),
//            ).catch {
//                postSideEffect(OpenLectureSideEffect.HandleException(it))
//            }.firstOrNull() ?: return@withLock
//
//            reduce {
//                state.copy(
//                    isLoading = false,
//                    openLectureList = newData
//                        .distinctBy { it.id }
//                        .toPersistentList(),
//                )
//            }
//            postSideEffect(OpenLectureSideEffect.ScrollToTop)
//        }
    }

    fun showGradeBottomSheet() {
//        reduce { state.copy(showSchoolLevelBottomSheet = true) }
    }

    fun hideGradeBottomSheet() {
//        reduce { state.copy(showSchoolLevelBottomSheet = false) }
    }

    fun popBackStack() {
//        postSideEffect(OpenLectureSideEffect.PopBackStack)
    }
}
