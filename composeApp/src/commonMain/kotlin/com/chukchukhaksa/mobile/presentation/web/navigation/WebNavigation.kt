package com.chukchukhaksa.mobile.presentation.web.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chukchukhaksa.mobile.common.kmp.rememberNativeWebView
import com.chukchukhaksa.mobile.presentation.web.WebRoute

fun NavController.navigateWebDetail() {
    navigate(WebNavigationRoute.detailRoute)
}

fun NavGraphBuilder.webNavGraph(
    nativeWebView: Any,
    onUrlChange: (String) -> Boolean,
) {
    composable(route = WebNavigationRoute.homeRoute) {
        WebRoute(
            nativeWebView = nativeWebView,
            onUrlChange = onUrlChange,
        )
    }

    composable(route = WebNavigationRoute.detailRoute) {
        val webView = rememberNativeWebView()

        WebRoute(
            nativeWebView = webView,
            onUrlChange = onUrlChange,
        )
    }
}

object WebNavigationRoute {
    const val homeRoute = "webHome"
    const val detailRoute = "webDetail"
}