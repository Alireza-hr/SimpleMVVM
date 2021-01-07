package com.alireza.simplemvvm.model.data.remote

import com.alireza.simplemvvm.model.data.remote.base.BaseHandleRetrofitConnection
import javax.inject.Inject

class CharacterRemoteWebService @Inject constructor(
    private val characterWebService: CharacterWebService
) : BaseHandleRetrofitConnection() {

    suspend fun getAllCharacters() =
        makeConnection { characterWebService.getAllCharacters() }

    suspend fun getOneCharacter(id: Int) =
        makeConnection { characterWebService.getOneCharacter(id) }
}