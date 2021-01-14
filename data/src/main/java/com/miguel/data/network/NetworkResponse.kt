package com.miguel.data.network

import retrofit2.HttpException
import java.io.IOException

sealed class NetworkResponse<T> {
    data class SUCCESS<T>(val body: T) : NetworkResponse<T>()
    data class API_ERROR(val exception: HttpException) : NetworkResponse<Nothing>()
    data class NETWORK_ERROR(val exception: IOException) : NetworkResponse<Nothing>()
}