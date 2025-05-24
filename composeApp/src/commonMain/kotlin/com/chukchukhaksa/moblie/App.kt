package com.chukchukhaksa.moblie

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.chukchukhaksa.moblie.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.moblie.presentation.timetable.timetable.TimetableRoute
import com.chukchukhaksa.moblie.presentation.timetable.timetable.TimetableViewModel

@Composable
fun App(
    modifier: Modifier = Modifier,
) {
    SuwikiTheme {
        Scaffold(
            modifier = modifier,
            content = { innerPadding ->
                TimetableRoute(
                    padding = innerPadding,
                    viewModel = TimetableViewModel(),
                    navigateTimetableEditor = { -> },
                    navigateOpenLecture = { -> },
                    navigateTimetableList = { -> },
                    handleException = { },
                    onShowToast = { },
                    navigateCellEditor = { },
                )
            },
        )
    }
}