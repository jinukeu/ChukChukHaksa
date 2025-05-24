package com.chukchukhaksa.moblie

import androidx.compose.ui.window.ComposeUIViewController
import com.chukchukhaksa.moblie.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }