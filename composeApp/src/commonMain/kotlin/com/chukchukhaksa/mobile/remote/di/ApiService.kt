package com.chukchukhaksa.mobile.remote.di

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ApiService(val httpClient: HttpClient) {

    suspend inline fun <reified T> get(
        url: String,
        parameters: Map<String, String> = emptyMap(),
        headers: Map<String, String> = emptyMap()
    ): T {
        return httpClient.get(url) {
            parameters.forEach { (key, value) ->
                parameter(key, value)
            }
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }.body()
    }

    suspend inline fun <reified T, reified R> post(
        url: String,
        body: T,
        headers: Map<String, String> = emptyMap()
    ): R {
        return httpClient.post(url) {
            contentType(ContentType.Application.Json)
            setBody(body)
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }.body()
    }

    suspend inline fun <reified T, reified R> put(
        url: String,
        body: T,
        headers: Map<String, String> = emptyMap()
    ): R {
        return httpClient.put(url) {
            contentType(ContentType.Application.Json)
            setBody(body)
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }.body()
    }

    suspend fun delete(
        url: String,
        headers: Map<String, String> = emptyMap()
    ): HttpResponse {
        return httpClient.delete(url) {
            headers.forEach { (key, value) ->
                header(key, value)
            }
        }
    }
}