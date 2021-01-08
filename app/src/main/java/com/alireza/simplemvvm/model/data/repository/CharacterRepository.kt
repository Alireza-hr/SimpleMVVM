package com.alireza.simplemvvm.model.data.repository

import android.util.Log
import com.alireza.simplemvvm.model.data.remote.CharacterRemoteWebService
import com.alireza.simplemvvm.model.data.remote.base.BaseDataHandler
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterRemoteWebService: CharacterRemoteWebService
) : BaseDataHandler() {

    fun getAllCharacters() =
        performData { characterRemoteWebService.getAllCharacters() }

    fun getOneCharacter(id:Int)=
        performData { characterRemoteWebService.getOneCharacter(id) }
}