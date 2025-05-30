package com.chukchukhaksa.mobile.presentation.openmajor.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chukchukhaksa.mobile.common.designsystem.theme.Black
import com.chukchukhaksa.mobile.common.designsystem.theme.Blue5
import com.chukchukhaksa.mobile.common.designsystem.theme.Primary
import com.chukchukhaksa.mobile.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.mobile.common.designsystem.theme.White
import com.chukchukhaksa.mobile.common.ui.suwikiClickable

@Composable
fun OpenMajorContainer(
    modifier: Modifier = Modifier,
    text: String,
    isChecked: Boolean,
    onClick: () -> Unit = {},
) {
    val (textColor, backgroundColor) = if (isChecked) {
        Primary to Blue5
    } else {
        Black to White
    }

    Row(
        modifier = modifier
            .background(backgroundColor)
            .padding(vertical = 12.dp, horizontal = 24.dp)
            .fillMaxWidth()
            .suwikiClickable(
                rippleEnabled = false,
                onClick = onClick,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Text(
            text = text,
            style = SuwikiTheme.typography.body2,
            color = textColor,
        )
    }
}

//@Preview(widthDp = 300, heightDp = 50)
//@Composable
//fun OpenMajorContainerPreview() {
//    var isChecked by remember { mutableStateOf(false) }
//
//    SuwikiTheme {
//        OpenMajorContainer(
//            text = "개설학과명",
//            isChecked = isChecked,
//            onClick = { isChecked = !isChecked },
//        )
//    }
//}
