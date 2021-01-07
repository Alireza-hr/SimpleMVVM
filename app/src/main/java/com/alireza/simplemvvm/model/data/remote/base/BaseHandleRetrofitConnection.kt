package com.alireza.simplemvvm.model.data.remote.base

import retrofit2.Response

abstract class BaseHandleRetrofitConnection {

    protected suspend fun <T> makeConnection(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.Success(body)
            }
            return Resource.Error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return Resource.Error(e.message ?: e.toString())
        }
    }}