package com.chukchukhaksa.mobile.common.kmp

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun WebView(url: String, nativeWebView: Any) {
    val webView = nativeWebView as WebView
    var backEnabled by remember { mutableStateOf(webView.canGoBack()) }

    BackHandler(enabled = backEnabled) {
        webView.goBack()
    }

    AndroidView(
        factory = {
            webView.apply {
                webViewClient = object : WebViewClient() {
                    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                        backEnabled = view.canGoBack()
                    }
                }
                if (webView.url == null) loadUrl(url)
            }
        }, update = {
            webView.apply {
                if (webView.url == null) loadUrl(url)
            }
        }
    )
}