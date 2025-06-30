package com.chukchukhaksa.mobile.common.kmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.backhandler.PredictiveBackHandler
import androidx.compose.ui.viewinterop.UIKitView
import platform.WebKit.*
import platform.Foundation.*
import platform.darwin.NSObject

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun WebView(
    url: String,
    nativeWebView: Any,
    onUrlChange: (String) -> Boolean,
) {
    val webView = nativeWebView as WKWebView

    UIKitView(
        factory = {
            val request = NSURLRequest(NSURL(string = url))
            webView.allowsBackForwardNavigationGestures = true
            webView.navigationDelegate = object : NSObject(), WKNavigationDelegateProtocol {

                override fun webView(
                    webView: WKWebView,
                    decidePolicyForNavigationAction: WKNavigationAction,
                    decisionHandler: (WKNavigationActionPolicy) -> Unit
                ) {
                    val nextUrl = decidePolicyForNavigationAction.request.URL?.absoluteString ?: ""
                    if (onUrlChange(nextUrl)) {
                        decisionHandler(WKNavigationActionPolicy.WKNavigationActionPolicyCancel)
                    } else {
                        decisionHandler(WKNavigationActionPolicy.WKNavigationActionPolicyAllow)
                    }
                }
            }

            if (webView.URL == null) {
                webView.loadRequest(request)
            }
            webView
        },
    )
}