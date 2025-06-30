package com.chukchukhaksa.mobile.remote.api

import com.chukchukhaksa.mobile.remote.di.ApiService

class UserApiImpl(private val apiService: ApiService) : UserApi {

    companion object {
        private const val BASE_URL = "https://dev.api.cchaksa.com"
        private const val TOKEN_TEST_ENDPOINT = "$BASE_URL/api/users/test/token"
    }

    override suspend fun tokenTest(): TokenTestData {
        return apiService.get(
            url = TOKEN_TEST_ENDPOINT
        )
    }
}