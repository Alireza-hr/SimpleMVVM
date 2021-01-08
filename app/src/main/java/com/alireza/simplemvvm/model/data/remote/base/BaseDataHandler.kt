package com.alireza.simplemvvm.model.data.remote.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

abstract class BaseDataHandler {
    protected fun <T> performData(
        networkCall: suspend () -> Resource<T>
    ): LiveData<Resource<T>> = liveData(Dispatchers.IO) {

        emit(Resource.Loading(true))

        emit(networkCall.invoke())

        emit(Resource.Loading(false))
    }
}