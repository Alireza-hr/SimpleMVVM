package com.alireza.simplemvvm.model.data.remote

import com.alireza.simplemvvm.model.data.entities.Character
import com.alireza.simplemvvm.model.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterWebService {
    @GET("character")
    suspend fun getAllCharacters() : Response<CharacterList>

    @GET("character/{id}")
    suspend fun getOneCharacter(@Path("id") id: Int): Response<Character>
}