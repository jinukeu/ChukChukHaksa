package com.chukchukhaksa.mobile

data class MainState(
  val toastMessage: String = "",
  val toastVisible: Boolean = false,
  val showNetworkErrorDialog: Boolean = false,
  val showUpdateMandatoryDialog: Boolean = false,
)

sealed interface MainSideEffect {
  data object OpenPlayStoreSite : MainSideEffect
}
