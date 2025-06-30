package com.chukchukhaksa.mobile.remote.api

interface UserRepository {
    suspend fun testToken(): Result<TokenTestData>
}

class UserRepositoryImpl(private val userApi: UserApi) : UserRepository {

    override suspend fun testToken(): Result<TokenTestData> {
        return try {
            val response = userApi.tokenTest()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}