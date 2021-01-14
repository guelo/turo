package com.miguel.turotakehome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.miguel.data.Business
import com.miguel.data.Repo
import com.miguel.data.network.NetworkResponse
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class MainViewModelTest {
    @Test
    fun `vm starts with loading and then sends the 2 results`() {

        val biz1 = mockk<Business>()
        val biz2 = mockk<Business>()
        val biz3 = mockk<Business>()
        val biz4 = mockk<Business>()
        val repo = mockk<Repo> {
            coEvery { nearbyBeer() } returns NetworkResponse.SUCCESS(listOf(biz1, biz2))
            coEvery { nearbyPizza() } returns NetworkResponse.SUCCESS(listOf(biz3, biz4))
        }

        dispatcher.pauseDispatcher()
        val vm = MainViewModel(repo)

        val pizzaObserver = mockk<Observer<LoadableResource<List<Business>>>> { every { onChanged(any()) } just Runs }
        val beerObserver = mockk<Observer<LoadableResource<List<Business>>>> { every { onChanged(any()) } just Runs }
        vm.pizzaState.observeForever(pizzaObserver)
        vm.beerState.observeForever(beerObserver)
        dispatcher.resumeDispatcher()

        verifySequence {
            pizzaObserver.onChanged(LoadableResource.Loading)
            pizzaObserver.onChanged(LoadableResource.Success(listOf(biz3, biz4)))
        }
        verifySequence {
            beerObserver.onChanged(LoadableResource.Loading)
            beerObserver.onChanged(LoadableResource.Success(listOf(biz1, biz2)))
        }

/*
        val pizzaObserver = mockk<Observer<LoadableResource<List<Business>>>>()
        val pizzaSlot = slot<LoadableResource<List<Business>>>()
        val beerObserver = mockk<Observer<LoadableResource<List<Business>>>>()
        val beerSlot = slot<LoadableResource<List<Business>>>()
        val pizzaList = arrayListOf<LoadableResource<List<Business>>>()
        val beerList = arrayListOf<LoadableResource<List<Business>>>()

        vm.pizzaState.observeForever(pizzaObserver)
        vm.beerState.observeForever(beerObserver)

        every { pizzaObserver.onChanged(capture(pizzaSlot)) } answers {
            pizzaList.add(pizzaSlot.captured)
        }
        every { beerObserver.onChanged(capture(beerSlot)) } answers {
            beerList.add(beerSlot.captured)
        }

        assertEquals(vm.pizzaState.value, "foo")*/
    }

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = TestCoroutineDispatcher()
    @Before
    fun setup() = Dispatchers.setMain(dispatcher)
    @After
    fun tearDown() = Dispatchers.resetMain()

}