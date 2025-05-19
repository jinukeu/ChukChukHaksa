package com.chukchukhaksa.moblie.preview.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.chukchukhaksa.moblie.common.designsystem.component.chip.SuwikiOutlinedChip
import com.chukchukhaksa.moblie.common.designsystem.theme.SuwikiTheme

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun SuwikiOutlinedChipPreview() {
    var isChecked by remember { mutableStateOf(false) }

    SuwikiTheme {
        SuwikiOutlinedChip(
            text = "label",
            isChecked = isChecked,
            onClick = { isChecked = !isChecked },
        )
    }
}