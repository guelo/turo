package com.miguel.turotakehome

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.miguel.data.Business
import com.miguel.data.Repo
import com.miguel.data.network.NetworkResponse
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: Repo
) : ViewModel() {

    val pizzaState: LiveData<LoadableResource<List<Business>>>
        get() = _pizzaState
    val beerState: LiveData<LoadableResource<List<Business>>>
        get() = _beerState

    private val _pizzaState =
        MutableLiveData<LoadableResource<List<Business>>>(LoadableResource.Loading)
    private val _beerState =
        MutableLiveData<LoadableResource<List<Business>>>(LoadableResource.Loading)

    init {
        viewModelScope.launch {
            val pizzaResponse = repository.nearbyPizza()
            _pizzaState.value = when (pizzaResponse) {
                is NetworkResponse.SUCCESS -> LoadableResource.Success(pizzaResponse.body)
                is NetworkResponse.API_ERROR -> LoadableResource.Error(pizzaResponse.exception.toString())
                is NetworkResponse.NETWORK_ERROR -> LoadableResource.Error("Network Unavailable")
            }
        }
        viewModelScope.launch() {
            val beerResponse = repository.nearbyBeer()
            _beerState.value = when (beerResponse) {
                is NetworkResponse.SUCCESS -> LoadableResource.Success(beerResponse.body)
                is NetworkResponse.API_ERROR -> LoadableResource.Error(beerResponse.exception.toString())
                is NetworkResponse.NETWORK_ERROR -> LoadableResource.Error("Network Unavailable")
            }
        }
    }
}