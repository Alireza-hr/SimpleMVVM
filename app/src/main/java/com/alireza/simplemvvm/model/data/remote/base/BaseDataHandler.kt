package com.alireza.simplemvvm.model.data.remote.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

abstract class BaseDataHandler {
    protected fun <T, A> performData(databaseQuery: () -> LiveData<T>,
                                  networkCall: suspend () -> Resource<A>,
                                  saveCallResult: suspend (A) -> Unit): LiveData<Resource<T>>
            = liveData(Dispatchers.IO) {

        emit(Resource.loading())

        val source = databaseQuery.invoke().map { Resource.success(it) }

        emitSource(source)

        val responseStatus = networkCall.invoke()

        when (responseStatus.status) {
            Resource.Status.SUCCESS -> {
                saveCallResult(responseStatus.data!!)
            }
            Resource.Status.ERROR -> {
                emitSource(source)
            }
        }
        emit(Resource.loading())
    }
}