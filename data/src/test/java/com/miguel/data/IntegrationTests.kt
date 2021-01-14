package com.miguel.data

import com.miguel.data.di.DataModule
import com.miguel.data.network.AuthInterceptor
import com.miguel.data.network.Network
import com.miguel.data.network.NetworkResponse
import dagger.Component
import junit.framework.TestCase.*
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.SocketPolicy
import org.junit.Ignore
import org.junit.Test
import javax.inject.Singleton


/**
 * This integration test uses Dagger and a MockWebserver to ensure that all the layers are wired
 * correctly and it all works
 */
class IntegrationTests {

    @Test
    fun testHappyPath() = runBlocking {
        val server = MockWebServer().apply {
            enqueue(MockResponse().setBody(SAMPLE_RESPONSE))
            start()
        }
        val network = network(server)

        val response = network.nearbyBeer()

        // some spot checks
        assertTrue(response is NetworkResponse.SUCCESS)
        val businesses = (response as NetworkResponse.SUCCESS).body
        assertEquals(20, businesses.size)
        assertEquals("Escape From New York Pizza", businesses[3].name)
        assertEquals("348 Columbus Ave, San Francisco, CA 94133", businesses[1].address)
    }

    @Test
    fun testApiError() = runBlocking {
        val server = MockWebServer().apply {
            enqueue(
                MockResponse()
                    .setResponseCode(500)
                    .setBody("server error")
            )
            start()
        }
        val network = network(server)


        val response = network.nearbyBeer()

        assertTrue(response is NetworkResponse.API_ERROR)
    }

    @Test
    fun testBadNetwork() = runBlocking {
        val server = MockWebServer().apply {
            enqueue(
                MockResponse()
                    .setSocketPolicy(SocketPolicy.DISCONNECT_AT_START) // simulate network problems
            )
            start()
        }
        val network = network(server)

        val response = network.nearbyBeer()

        assertTrue(response is NetworkResponse.NETWORK_ERROR)
    }


    private fun network(server: MockWebServer): Network {
        DataModule.BASE_URL = server.url("")

        val dagger = DaggerTestComponent.create()
        return dagger.network()
    }


    @Test
    @Ignore(" This test makes an actual network call, it should not be enabled except during development.")
    fun actualNetworkCall() {
        val di = DataModule
        val yelpService = di.yelpService(
            retrofit = di.retrofit(
                okHttp = di.okHttp(authInterceptor = AuthInterceptor(di.authKey())),
                moshi = di.moshi()
            )
        )
        runBlocking {
            println(yelpService.nearbyBeer())
            println(yelpService.nearbyPizza())
        }
    }
}


@Component(modules = [DataModule::class])
@Singleton
internal interface TestComponent {
    fun network(): Network
}
