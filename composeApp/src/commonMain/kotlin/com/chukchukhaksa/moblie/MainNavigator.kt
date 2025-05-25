package com.chukchukhaksa.moblie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chukchukhaksa.moblie.presentation.openmajor.navigation.navigateOpenMajor
import com.chukchukhaksa.moblie.presentation.timetable.navigation.TimetableRoute
import com.chukchukhaksa.moblie.presentation.timetable.navigation.argument.CellEditorArgument
import com.chukchukhaksa.moblie.presentation.timetable.navigation.argument.TimetableEditorArgument
import com.chukchukhaksa.moblie.presentation.timetable.navigation.navigateCellEditor
import com.chukchukhaksa.moblie.presentation.timetable.navigation.navigateOpenLecture
import com.chukchukhaksa.moblie.presentation.timetable.navigation.navigateTimetableEditor
import com.chukchukhaksa.moblie.presentation.timetable.navigation.navigateTimetableList

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