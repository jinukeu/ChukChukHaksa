package com.chukchukhaksa.mobile.presentation.web

import androidx.compose.runtime.Composable
import com.chukchukhaksa.mobile.common.designsystem.component.SuwikiBackground
import com.chukchukhaksa.mobile.common.kmp.WebView

@Composable
fun WebRoute(
    nativeWebView: Any,
    onUrlChange: (String) -> Boolean,
) {

    WebScreen(
        nativeWebView = nativeWebView,
        onUrlChange = onUrlChange,
    )
}

@Composable
private fun WebScreen(
    nativeWebView: Any,
    onUrlChange: (String) -> Boolean,
) {
    SuwikiBackground {
        WebView(
            url = "https://www.cchaksa.com/",
            nativeWebView = nativeWebView,
            onUrlChange = onUrlChange,
        )
    }
}