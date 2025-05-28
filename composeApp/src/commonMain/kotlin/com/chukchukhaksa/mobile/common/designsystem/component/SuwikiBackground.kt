package com.chukchukhaksa.mobile.common.designsystem.component

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.MutableWindowInsets
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.onConsumedWindowInsetsChanged
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.chukchukhaksa.mobile.common.designsystem.theme.White

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuwikiBackground(
    modifier: Modifier = Modifier,
    color: Color = White,
    contentWindowInsets: WindowInsets = WindowInsets.systemBars,
    content: @Composable () -> Unit,
) {
    val safeInsets = remember(contentWindowInsets) {
        MutableWindowInsets(
            contentWindowInsets
        )
    }

    Surface(
        color = color,
        modifier = modifier
            .fillMaxSize()
            .onConsumedWindowInsetsChanged { consumedWindowInsets ->
                safeInsets.insets = contentWindowInsets.exclude(consumedWindowInsets)
            }
            .padding(safeInsets.insets.asPaddingValues()),
    ) {
        content()
    }
}