package com.chukchukhaksa.mobile.presentation.timetable.timetable.component.timetable.column

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chukchukhaksa.mobile.presentation.timetable.timetable.component.timetable.cell.EmptyCell

@Composable
internal fun TimeColumn(
  modifier: Modifier = Modifier,
  maxPeriod: Int,
) {
  Column(
    modifier = modifier,
  ) {
    EmptyCell()

    for (time in 1..maxPeriod) {
      EmptyCell(text = "${time + 8}")
    }
  }
}
