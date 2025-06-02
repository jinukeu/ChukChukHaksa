package com.chukchukhaksa.mobile.data.config.datasource

interface RemoteAppConfigDataSource {
    suspend fun getAndroidMinVersion(): String
    suspend fun getIOSMinVersion(): String
}
