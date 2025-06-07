package com.chukchukhaksa.mobile

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import chukchukhaksa.composeapp.generated.resources.Res
import chukchukhaksa.composeapp.generated.resources.dialog_network_body
import chukchukhaksa.composeapp.generated.resources.dialog_network_header
import chukchukhaksa.composeapp.generated.resources.dialog_update_mandatory_body
import chukchukhaksa.composeapp.generated.resources.dialog_update_mandatory_header
import chukchukhaksa.composeapp.generated.resources.word_confirm
import com.chukchukhaksa.mobile.common.designsystem.component.bottomnavigation.SuwikiBottomNavigationBar
import com.chukchukhaksa.mobile.common.designsystem.component.bottomnavigation.getBottomNavigationItems
import com.chukchukhaksa.mobile.common.designsystem.component.dialog.SuwikiDialog
import com.chukchukhaksa.mobile.common.designsystem.component.toast.SuwikiToast
import com.chukchukhaksa.mobile.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.mobile.common.kmp.rememberNativeWebView
import com.chukchukhaksa.mobile.common.ui.collectWithLifecycle
import com.chukchukhaksa.mobile.presentation.openmajor.navigation.OpenMajorRoute
import com.chukchukhaksa.mobile.presentation.openmajor.navigation.openMajorNavGraph
import com.chukchukhaksa.mobile.presentation.timetable.navigation.timetableNavGraph
import com.chukchukhaksa.mobile.presentation.web.navigation.webNavGraph
import org.jetbrains.compose.resources.stringResource
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
            val uiState = viewModel.mviStore.uiState.collectAsState().value
            val uriHandler = LocalUriHandler.current
            val navBackStackEntry by navigator.navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: ""
            val nativeWebView = rememberNativeWebView()

            viewModel.mviStore.sideEffects.collectWithLifecycle { sideEffect ->
                when (sideEffect) {
                    is MainSideEffect.OpenUrl -> uriHandler.openUri(sideEffect.url)
                }
            }

            LaunchedEffect(key1 = Unit) {
                viewModel.checkNeedForceUpdate()
            }

            Scaffold(
                modifier = modifier,
                bottomBar = {
                    val bottomNavigationItems = getBottomNavigationItems()
                    SuwikiBottomNavigationBar(
                        items = bottomNavigationItems,
                        selectedRoute = when {
                            currentRoute.startsWith("timetable") -> "timetable"
                            currentRoute.startsWith("web") -> "web"
                            else -> "timetable"
                        },
                        onItemClick = { route ->
                            navigator.navigateToTab(route)
                        }
                    )
                },
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
                            argumentName = OpenMajorRoute.ARGUMENT_NAME,
                            popBackStack = navigator::popBackStackIfNotHome,
                            navigateTimetableEditor = navigator::navigateTimetableEditor,
                            navigateTimetableList = navigator::navigateTimetableList,
                            navigateOpenLecture = navigator::navigateOpenLecture,
                            handleException = {},
                            onShowToast = {},
                            navigateOpenMajor = navigator::navigateOpenMajor,
                            navigateCellEditor = navigator::navigateCellEditor,
                        )

                        webNavGraph(
                            nativeWebView = nativeWebView,
                        )
                    }

                    if (uiState.showNetworkErrorDialog) {
                        SuwikiDialog(
                            headerText = stringResource(Res.string.dialog_network_header),
                            bodyText = stringResource(Res.string.dialog_network_body),
                            confirmButtonText = stringResource(Res.string.word_confirm),
                            onDismissRequest = viewModel::hideNetworkErrorDialog,
                            onClickConfirm = viewModel::hideNetworkErrorDialog,
                        )
                    }

                    if (uiState.showForceUpdateDialog) {
                        SuwikiDialog(
                            headerText = stringResource(Res.string.dialog_update_mandatory_header),
                            bodyText = stringResource(Res.string.dialog_update_mandatory_body),
                            confirmButtonText = stringResource(Res.string.word_confirm),
                            onDismissRequest = {},
                            onClickConfirm = viewModel::openAppStore,
                        )
                    }

                    SuwikiToast(
                        visible = uiState.toastVisible,
                        message = uiState.toastMessage,
                    )
                },
            )
        }
    }
}
