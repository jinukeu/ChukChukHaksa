package com.chukchukhaksa.moblie

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.compose.NavHost
import com.chukchukhaksa.moblie.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.moblie.presentation.openmajor.navigation.OpenMajorRoute
import com.chukchukhaksa.moblie.presentation.openmajor.navigation.openMajorNavGraph
import com.chukchukhaksa.moblie.presentation.timetable.navigation.timetableNavGraph
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel(),
    navigator: MainNavigator = rememberMainNavigator(),
) {
    SuwikiTheme {
        KoinContext {
            //        val uiState = viewModel.collectAsState().value
            val uriHandler = LocalUriHandler.current
//        viewModel.collectSideEffect { sideEffect ->
//            when (sideEffect) {
//                MainSideEffect.OpenPlayStoreSite -> uriHandler.openUri(PLAY_STORE_SITE)
//            }
//        }

            LaunchedEffect(key1 = Unit) {
//            viewModel.checkUpdateMandatory(context.versionCode)
            }

            Scaffold(
                modifier = modifier,
                content = { innerPadding ->
                    NavHost(
                        navController = navigator.navController,
                        startDestination = navigator.startDestination,
                    ) {
                        openMajorNavGraph(
                            popBackStack = navigator::popBackStackIfNotHome,
                            popBackStackWithArgument = { openMajor ->
                                navigator.navController.previousBackStackEntry?.savedStateHandle?.set(
                                    OpenMajorRoute.ARGUMENT_NAME,
                                    openMajor,
                                )
                                navigator.popBackStackIfNotHome()
                            },
                            handleException = {},
                            onShowToast = {},
                        )

                        timetableNavGraph(
                            padding = innerPadding,
                            argumentName = "TODO OpenMajorRoute.ARGUMENT_NAME", // TODO
                            popBackStack = navigator::popBackStackIfNotHome,
                            navigateTimetableEditor = navigator::navigateTimetableEditor,
                            navigateTimetableList = navigator::navigateTimetableList,
                            navigateOpenLecture = navigator::navigateOpenLecture,
                            handleException = {},
                            onShowToast = {},
                            navigateOpenMajor = navigator::navigateOpenMajor,
                            navigateCellEditor = navigator::navigateCellEditor,
                        )
                    }

//                if (uiState.showNetworkErrorDialog) {
//                    SuwikiDialog(
//                        headerText = stringResource(R.string.dialog_network_header),
//                        bodyText = stringResource(R.string.dialog_network_body),
//                        confirmButtonText = stringResource(id = com.suwiki.presentation.common.ui.R.string.word_confirm),
//                        onDismissRequest = viewModel::hideNetworkErrorDialog,
//                        onClickConfirm = viewModel::hideNetworkErrorDialog,
//                    )
//                }
//
//                if (uiState.showUpdateMandatoryDialog) {
//                    SuwikiDialog(
//                        headerText = stringResource(R.string.dialog_update_mandatory_header),
//                        bodyText = stringResource(R.string.dialog_update_mandatory_body),
//                        confirmButtonText = stringResource(id = com.suwiki.presentation.common.ui.R.string.word_confirm),
//                        onDismissRequest = {},
//                        onClickConfirm = viewModel::openPlayStoreSite,
//                    )
//                }
//
//                SuwikiToast(
//                    visible = uiState.toastVisible,
//                    message = uiState.toastMessage,
//                )
                },
            )
        }
    }
}