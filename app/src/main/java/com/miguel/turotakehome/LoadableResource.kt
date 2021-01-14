package com.miguel.turotakehome

sealed class LoadableResource<out T> {
    data class Success<T>(val result: T): LoadableResource<T>()
    object Loading: LoadableResource<Nothing>()
    data class Error(val message: String): LoadableResource<Nothing>()
}
