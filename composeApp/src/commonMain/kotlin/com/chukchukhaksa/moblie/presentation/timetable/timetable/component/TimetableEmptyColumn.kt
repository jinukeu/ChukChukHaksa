package com.chukchukhaksa.moblie.presentation.timetable.timetable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import chukchukhaksa.composeapp.generated.resources.Res
import chukchukhaksa.composeapp.generated.resources.timetable_screen_create_timetable
import chukchukhaksa.composeapp.generated.resources.timetable_screen_create_timetable_button
import com.chukchukhaksa.moblie.common.designsystem.component.button.SuwikiContainedMediumButton
import com.chukchukhaksa.moblie.common.designsystem.theme.Gray95
import com.chukchukhaksa.moblie.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.moblie.common.designsystem.theme.White
import org.jetbrains.compose.resources.stringResource

@Composable
fun TimetableEmptyColumn(
  modifier: Modifier,
  onClickAdd: () -> Unit = {},
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Spacer(modifier = Modifier.padding(top = 130.dp))

    Text(
      text = stringResource(Res.string.timetable_screen_create_timetable),
      color = Gray95,
      style = SuwikiTheme.typography.header4,
      textAlign = TextAlign.Center,
    )

    Spacer(modifier = Modifier.size(28.dp))

    SuwikiContainedMediumButton(
      text = stringResource(Res.string.timetable_screen_create_timetable_button),
      onClick = onClickAdd,
    )
  }
}
