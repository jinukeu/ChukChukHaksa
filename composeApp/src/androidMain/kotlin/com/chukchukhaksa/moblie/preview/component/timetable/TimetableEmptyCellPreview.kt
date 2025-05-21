package com.chukchukhaksa.moblie.preview.component.timetable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chukchukhaksa.moblie.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.moblie.presentation.timetable.timetable.component.timetable.cell.EmptyCell

@Preview(showBackground = true)
@Composable
fun TimetableEmptyCellPreview() {
    SuwikiTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            EmptyCell()

            EmptyCell(text = "월")
        }
    }
}