package com.alireza.simplemvvm.model.data.repository

import com.alireza.simplemvvm.model.data.entities.Character
import com.alireza.simplemvvm.model.data.local.CharacterDao
import com.alireza.simplemvvm.model.data.remote.CharacterRemoteWebService
import com.alireza.simplemvvm.model.data.remote.base.BaseDataHandler
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterRemoteWebService: CharacterRemoteWebService,
    private val characterDao: CharacterDao
) : BaseDataHandler() {

    fun getAllCharacters() =
        performData(
            networkCall = {
                characterRemoteWebService.getAllCharacters()
            },
            databaseQuery = {
                characterDao.getAllCharacters()
            },
            saveCallResult = {
                characterDao.insertAllCharacters(it.results)
            }
        )

    fun getOneCharacter(id: Int) =
        performData(
            networkCall = {
                characterRemoteWebService.getOneCharacter(id)
            },
            databaseQuery = {
                characterDao.getOneCharacter(id)
            },
            saveCallResult = {
                characterDao.insertCharacter(it)
            }
        )
}