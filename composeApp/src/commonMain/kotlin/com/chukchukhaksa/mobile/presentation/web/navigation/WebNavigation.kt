package com.chukchukhaksa.mobile.presentation.web.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chukchukhaksa.mobile.presentation.web.WebRoute
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.WebViewState

fun NavController.navigateWeb() {
    navigate(WebNavigationRoute.route)
}

fun NavGraphBuilder.webNavGraph(
    webViewState: WebViewState,
    webViewNavigator: WebViewNavigator,
) {
    composable(route = WebNavigationRoute.route) {
        WebRoute(
            webViewState = webViewState,
            webViewNavigator = webViewNavigator,
        )
    }
}

object WebNavigationRoute {
    const val route = "web"
}