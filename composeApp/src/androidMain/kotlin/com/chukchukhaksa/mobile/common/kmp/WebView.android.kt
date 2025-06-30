package com.chukchukhaksa.mobile.common.kmp

import android.graphics.Bitmap
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.viewinterop.AndroidView
import io.github.aakira.napier.Napier

@Composable
actual fun WebView(
    url: String,
    nativeWebView: Any,
    onUrlChange: (String) -> Boolean,
) {
    val webView = nativeWebView as WebView

    AndroidView(
        factory = {
            webView.apply {
                webViewClient = object : WebViewClient() {

                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        Napier.d(tag = "TEST", message = "shouldOverrideUrlLoading $url")
                        return super.shouldOverrideUrlLoading(view, request)
                    }

//                    override fun doUpdateVisitedHistory(
//                        view: WebView?,
//                        url: String?,
//                        isReload: Boolean
//                    ) {
//                        Napier.d(tag = "TEST", message = "doUpdateVisitedHistory $url")
//                        url ?: return
//                        if (url == "https://www.cchaksa.com/") return
//                        if (onUrlChange(url)) {
//                            // 차단: 이전 페이지로 되돌리기
//                            view?.post { view.goBack() }
//                        }
//                        super.doUpdateVisitedHistory(view, url, isReload)
//                    }
                }

                webView.webChromeClient = object : WebChromeClient() {
                    
                }

                if (webView.url == null) loadUrl(url)
            }
        },
    )
}