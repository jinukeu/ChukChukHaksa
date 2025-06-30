package com.chukchukhaksa.mobile.remote.di

import com.chukchukhaksa.mobile.remote.api.UserApi
import com.chukchukhaksa.mobile.remote.api.UserApiImpl
import com.chukchukhaksa.mobile.remote.api.UserRepository
import com.chukchukhaksa.mobile.remote.api.UserRepositoryImpl
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                })
            }

            install(Logging) {
                level = LogLevel.INFO
            }
        }
    }

    single<ApiService> {
        ApiService(get())
    }

    single<UserApi> {
        UserApiImpl(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}