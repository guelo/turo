package com.miguel.data.network

import androidx.annotation.WorkerThread
import com.miguel.data.Business
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

internal class Network @Inject constructor(private val yelpService: YelpService) {
    @WorkerThread
    suspend fun nearbyPizza(): NetworkResponse<out List<Business>> =
        toNetworkResponse { yelpService.nearbyPizza() }

    @WorkerThread
    suspend fun nearbyBeer(): NetworkResponse<out List<Business>> =
        toNetworkResponse { yelpService.nearbyBeer() }

    private suspend fun toNetworkResponse(call: suspend () -> Response<YelpSearchResponse>): NetworkResponse<out List<Business>> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                NetworkResponse.SUCCESS(response.body()!!.businesses.map { it.toEntity() })
            } else {
                NetworkResponse.API_ERROR(HttpException(response))
            }
        } catch (i: IOException) {
            NetworkResponse.NETWORK_ERROR(i)
        }
    }
}

private fun YelpSearchResponse.Business.toEntity() =
    Business(
        id = id,
        phone = phone,
        distance = distance,
        imageUrl = image_url.toHttpUrl(),
        address = location.display_address.joinToString(separator = ", "),
        name = name,
        price = price,
        rating = rating,
        numberReviews = review_count
    )
