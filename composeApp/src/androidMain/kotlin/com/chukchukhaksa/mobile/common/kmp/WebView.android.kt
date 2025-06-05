package com.chukchukhaksa.mobile.common.kmp

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun WebView(url: String, nativeWebView: Any) {
    val webView = nativeWebView as WebView
    AndroidView(
        factory = {
            webView.apply {
                if (webView.url == null) loadUrl(url)
            }
        }, update = {
            webView.apply {
                if (webView.url == null) loadUrl(url)
            }
        }
    )
}