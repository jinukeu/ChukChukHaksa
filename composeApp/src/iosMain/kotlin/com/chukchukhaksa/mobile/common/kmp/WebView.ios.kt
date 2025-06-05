package com.chukchukhaksa.mobile.common.kmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.UIKitView
import io.github.aakira.napier.Napier
import platform.WebKit.*
import platform.Foundation.*

@Composable
actual fun WebView(url: String, nativeWebView: Any) {
    val webView = nativeWebView as WKWebView
    UIKitView(
        factory = {
            val request = NSURLRequest(NSURL(string = url))
            if (webView.URL == null) {
                Napier.d("Loading ${webView.URL}")
                webView.loadRequest(request)
            }
            webView
        },
    )
}