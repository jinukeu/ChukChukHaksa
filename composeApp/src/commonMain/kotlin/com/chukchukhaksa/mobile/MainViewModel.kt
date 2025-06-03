package com.chukchukhaksa.mobile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chukchukhaksa.mobile.common.kmp.exception.CrashReporter
import com.chukchukhaksa.mobile.common.model.NetworkException
import com.chukchukhaksa.mobile.common.model.UnknownException
import com.chukchukhaksa.mobile.common.ui.MviStore
import com.chukchukhaksa.mobile.common.ui.mviStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class MainViewModel : ViewModel() {
    val mviStore: MviStore<MainState, MainSideEffect> = mviStore(MainState())

    private val mutex = Mutex()
    private var isFirstVisit: Boolean = true

    fun checkUpdateMandatory(versionCode: Long) {
        if (isFirstVisit.not()) return
        // 앱 버전 확인 하는 동작 수행
        // 최신 아닌 경우 업데이트 팝업 띄우는 상태 업데이트
        isFirstVisit = true
    }

    fun openPlayStoreSite() = mviStore.postSideEffect(MainSideEffect.OpenPlayStoreSite)

    fun onShowToast(msg: String) {
        viewModelScope.launch {
            mutex.withLock {
                mviStore.setState { copy(toastMessage = msg, toastVisible = true) }
                delay(SHOW_TOAST_LENGTH)
                mviStore.setState { copy(toastVisible = false) }
            }
        }
    }

    fun handleException(throwable: Throwable) {
        when (throwable) {
            is NetworkException -> { mviStore.setState { copy(showNetworkErrorDialog = true) } }
//            is ConnectException -> { mviStore.setState { copy(showNetworkErrorDialog = true) } }
            else -> {
                onShowToast(throwable.message ?: UnknownException().message)
                CrashReporter.recordException(throwable)
            }
        }

    }

    fun hideNetworkErrorDialog() = mviStore.setState { copy(showNetworkErrorDialog = false) }

    companion object {
        private const val SHOW_TOAST_LENGTH = 3000L
    }
}