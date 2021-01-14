package com.miguel.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class AuthInterceptor @Inject constructor(private val KEY: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $KEY")
            .build()

        return chain.proceed(newRequest)
    }
}