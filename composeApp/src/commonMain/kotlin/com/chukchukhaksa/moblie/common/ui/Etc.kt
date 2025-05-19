package com.chukchukhaksa.moblie.common.ui

internal inline fun <T> T.runIf(condition: Boolean, run: T.() -> T) = if (condition) {
  run()
} else {
  this
}
