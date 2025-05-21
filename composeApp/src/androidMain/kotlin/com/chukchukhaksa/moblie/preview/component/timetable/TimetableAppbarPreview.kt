package com.chukchukhaksa.moblie.preview.component.timetable

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chukchukhaksa.moblie.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.moblie.presentation.timetable.timetable.component.TimetableAppbar

@Preview
@Composable
fun TimetableAppbarPreview() {
    SuwikiTheme {
        TimetableAppbar()
    }
}