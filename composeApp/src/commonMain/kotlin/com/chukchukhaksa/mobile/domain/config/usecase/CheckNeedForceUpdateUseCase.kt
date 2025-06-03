package com.chukchukhaksa.mobile.domain.config.usecase

import com.chukchukhaksa.mobile.common.kmp.Platform
import com.chukchukhaksa.mobile.domain.common.runCatchingIgnoreCancelled
import com.chukchukhaksa.mobile.domain.config.repository.AppConfigRepository

class CheckNeedForceUpdateUseCase(
    private val appConfigRepository: AppConfigRepository
) {
    suspend operator fun invoke(platform: Platform, currentVersion: String): Result<Boolean> = runCatchingIgnoreCancelled {
        val minVersion = when (platform) {
            Platform.Android -> appConfigRepository.getAndroidMinVersion()
            Platform.iOS -> appConfigRepository.getIOSMinVersion()
        }
        
        compareVersions(currentVersion, minVersion) < 0
    }
    
    private fun compareVersions(currentVersion: String, minVersion: String): Int {
        val currentParts = currentVersion.split(".").map { it.toInt() }
        val minimumParts = minVersion.split(".").map { it.toInt() }
        
        val maxLength = maxOf(currentParts.size, minimumParts.size)
        
        for (i in 0 until maxLength) {
            val currentPart = currentParts.getOrElse(i) { 0 }
            val minimumPart = minimumParts.getOrElse(i) { 0 }
            
            when {
                currentPart < minimumPart -> return -1
                currentPart > minimumPart -> return 1
            }
        }
        
        return 0
    }
}