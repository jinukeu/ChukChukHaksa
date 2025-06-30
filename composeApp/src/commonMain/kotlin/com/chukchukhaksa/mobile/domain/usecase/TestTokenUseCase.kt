package com.chukchukhaksa.mobile.domain.usecase

import com.chukchukhaksa.mobile.remote.api.TokenTestData
import com.chukchukhaksa.mobile.remote.api.TokenTestResponse
import com.chukchukhaksa.mobile.remote.api.UserRepository

class TestTokenUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(): Result<TokenTestData> {
        return userRepository.testToken()
    }
}