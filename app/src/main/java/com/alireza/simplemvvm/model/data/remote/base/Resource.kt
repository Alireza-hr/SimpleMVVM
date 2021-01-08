package com.alireza.simplemvvm.model.data.remote.base

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null,
    val isLoading: Boolean? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(isLoading: Boolean) : Resource<T>(isLoading = isLoading)
}