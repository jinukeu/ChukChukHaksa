package com.chukchukhaksa.mobile.common.kmp

import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun rememberNativeWebView(): Any {
    val context = LocalContext.current

    return remember {
        android.webkit.WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
    }
}