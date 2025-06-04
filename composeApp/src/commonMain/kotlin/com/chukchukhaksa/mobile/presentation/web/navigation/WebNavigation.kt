package com.chukchukhaksa.mobile.presentation.web.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chukchukhaksa.mobile.presentation.web.WebRoute

fun NavController.navigateWeb() {
    navigate(WebNavigationRoute.route)
}

fun NavGraphBuilder.webNavGraph() {
    composable(route = WebNavigationRoute.route) {
        WebRoute()
    }
}

object WebNavigationRoute {
    const val route = "web"
}