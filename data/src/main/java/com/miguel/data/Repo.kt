package com.miguel.data

import com.miguel.data.network.Network
import com.miguel.data.network.YelpService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repo @Inject internal constructor(private val network: Network) {

    suspend fun nearbyPizza() = coroutineScope {
        withContext(Dispatchers.IO) {
            network.nearbyPizza()
        }
    }
    suspend fun nearbyBeer() = coroutineScope {
        withContext(Dispatchers.IO) {
            network.nearbyBeer()
        }
    }
}