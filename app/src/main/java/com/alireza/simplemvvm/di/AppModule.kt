package com.alireza.simplemvvm.di

import com.alireza.simplemvvm.model.data.remote.CharacterRemoteWebService
import com.alireza.simplemvvm.model.data.remote.CharacterWebService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    private const val ADDRESS = "https://rickandmortyapi.com/api/"

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(ADDRESS)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterWebService(retrofit: Retrofit): CharacterWebService
            = retrofit.create(CharacterWebService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteWebService(characterWebService: CharacterWebService)
            = CharacterRemoteWebService(characterWebService)

}