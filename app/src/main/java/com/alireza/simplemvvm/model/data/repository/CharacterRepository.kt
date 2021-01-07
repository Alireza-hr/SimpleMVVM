package com.alireza.simplemvvm.model.data.repository

import com.alireza.simplemvvm.model.data.remote.CharacterRemoteWebService
import com.alireza.simplemvvm.model.data.remote.base.BaseDataHandler
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterRemoteWebService: CharacterRemoteWebService
) : BaseDataHandler() {

    fun getAllCharacters() =
        performData { characterRemoteWebService.getAllCharacters() }
}