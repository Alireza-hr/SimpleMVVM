package com.alireza.simplemvvm.model.data.remote.base

import retrofit2.Response

abstract class BaseHandleRetrofitConnection {

    protected suspend fun <T> makeConnection(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return Resource.error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return Resource.error(e.message ?: e.toString())
        }
    }}