package com.chukchukhaksa.mobile.presentation.openmajor

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.chukchukhaksa.mobile.common.ui.MviStore
import com.chukchukhaksa.mobile.common.ui.mviStore
import com.chukchukhaksa.mobile.presentation.openmajor.navigation.OpenMajorRoute

class OpenMajorViewModel(
//    private val getOpenMajorListUseCase: GetOpenMajorListUseCase,
//    private val openLectureRepository: OpenLectureRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val mviStore: MviStore<OpenMajorState, OpenMajorSideEffect> =
        mviStore(OpenMajorState())

    private var selectedOpenMajor = savedStateHandle[OpenMajorRoute.ARGUMENT_NAME] ?: "전체"
    private val allOpenMajorList = mutableListOf<String>()

    fun updateSearchValue(searchValue: String) {
//        reduce { state.copy(searchValue = searchValue) }
//        reduceOpenMajorList(searchValue)
    }

    fun syncPagerState(currentPage: Int) {
//        reduce { state.copy(currentPage = currentPage) }
    }

    fun updateSelectedOpenMajor(openMajor: String) {
//        selectedOpenMajor = openMajor
//        reduceOpenMajorList()
    }

    fun popBackStack() {
//        postSideEffect(OpenMajorSideEffect.PopBackStack)
    }

    fun popBackStackWithArgument() {
//        postSideEffect(OpenMajorSideEffect.PopBackStackWithArgument(selectedOpenMajor))
    }

    fun changeBottomShadowVisible(show: Boolean) {
//        reduce { state.copy(showBottomShadow = show) }
    }

    fun initData() {
//        reduce { state.copy(isLoading = true) }
//        joinAll(getOpenMajor())
//        reduce { state.copy(isLoading = false) }
    }

    private fun getOpenMajor() {
//        getOpenMajorListUseCase().onEach {
//            allOpenMajorList.clear()
//            val firebaseOpenMajor = openLectureRepository.getOpenMajor()
//            allOpenMajorList.addAll((it + firebaseOpenMajor).distinct())
//            reduceOpenMajorList()
//        }.catch {
//        }.launchIn(viewModelScope)
    }

    private fun reduceOpenMajorList(searchValue: String) {
//            reduce {
//                state.copy(
//                    filteredAllOpenMajorList = allOpenMajorList.toOpenMajorList(
//                        searchValue = searchValue,
//                        selectedOpenMajor = selectedOpenMajor,
//                    ),
//                )
//            }
        }
}
