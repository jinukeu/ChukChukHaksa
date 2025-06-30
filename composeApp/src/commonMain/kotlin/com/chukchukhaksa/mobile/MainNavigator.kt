package com.chukchukhaksa.mobile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chukchukhaksa.mobile.presentation.openmajor.navigation.navigateOpenMajor
import com.chukchukhaksa.mobile.presentation.timetable.navigation.TimetableRoute
import com.chukchukhaksa.mobile.presentation.timetable.navigation.argument.CellEditorArgument
import com.chukchukhaksa.mobile.presentation.timetable.navigation.argument.TimetableEditorArgument
import com.chukchukhaksa.mobile.presentation.timetable.navigation.navigateCellEditor
import com.chukchukhaksa.mobile.presentation.timetable.navigation.navigateOpenLecture
import com.chukchukhaksa.mobile.presentation.timetable.navigation.navigateTimetableEditor
import com.chukchukhaksa.mobile.presentation.timetable.navigation.navigateTimetableList
import com.chukchukhaksa.mobile.presentation.web.navigation.WebNavigationRoute
import com.chukchukhaksa.mobile.presentation.web.navigation.navigateWebDetail

class MainNavigator(
    val navController: NavHostController,
) {
    val startDestination = TimetableRoute.route

    fun navigateOpenMajor(selectedOpenMajor: String) {
        navController.navigateOpenMajor(selectedOpenMajor)
    }

    fun navigateCellEditor(argument: CellEditorArgument) {
        navController.navigateCellEditor(argument)
    }

    fun navigateTimetableEditor(argument: TimetableEditorArgument = TimetableEditorArgument()) {
        navController.navigateTimetableEditor(argument)
    }

    fun navigateTimetableList() {
        navController.navigateTimetableList()
    }

    fun navigateOpenLecture() {
        navController.navigateOpenLecture()
    }

    fun navigateWebDetail() {
        navController.navigateWebDetail()
    }

    fun navigateToTab(route: String) {
        when (route) {
            TimetableRoute.route -> {
                if (!isSameCurrentDestination(TimetableRoute.route)) {
                    navController.navigate(TimetableRoute.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }

            WebNavigationRoute.homeRoute -> {
                if (!isSameCurrentDestination(WebNavigationRoute.homeRoute)) {
                    navController.navigate(WebNavigationRoute.homeRoute) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination(TimetableRoute.route)) {
            navController.popBackStack()
        }
    }

    private fun isSameCurrentDestination(route: String) =
        navController.currentDestination?.route == route

}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
