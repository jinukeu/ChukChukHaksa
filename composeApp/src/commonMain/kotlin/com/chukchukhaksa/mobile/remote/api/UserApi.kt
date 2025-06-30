package com.chukchukhaksa.mobile.remote.api

import kotlinx.serialization.Serializable

@Serializable
data class TokenTestData(
    val accessToken: String,
    val refreshToken: String
)

@Serializable
data class TokenTestResponse(
    val success: Boolean,
    val data: TokenTestData?,
    val message: String
)

interface UserApi {
    suspend fun tokenTest(): TokenTestData
}