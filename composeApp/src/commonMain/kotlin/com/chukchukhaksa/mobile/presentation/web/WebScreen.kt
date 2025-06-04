package com.chukchukhaksa.mobile.presentation.web

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.chukchukhaksa.mobile.common.designsystem.component.SuwikiBackground
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.WebViewState

@Composable
fun WebRoute(
    webViewState: WebViewState,
    webViewNavigator: WebViewNavigator,
) {
    LaunchedEffect(webViewState) {
        if (webViewState.lastLoadedUrl == null) {
            webViewNavigator.loadUrl("https://naver.com")
        }
    }

    WebScreen(
        webViewState = webViewState,
        webViewNavigator = webViewNavigator,
    )
}

@Composable
private fun WebScreen(
    webViewState: WebViewState,
    webViewNavigator: WebViewNavigator,
) {
    SuwikiBackground {
        WebView(
            state = webViewState,
            navigator = webViewNavigator,
            factory = null,
        )

//        if (webViewState.lastLoadedUrl == null) {
//            WebView(
//                state = webViewState,
//                navigator = webViewNavigator,
//                factory = null,
//            )
//        } else {
//            WebView(
//                state = webViewState,
//                navigator = webViewNavigator,
//                factory = {
//                    webViewState.nativeWebView
//                },
//            )
//        }
    }
}