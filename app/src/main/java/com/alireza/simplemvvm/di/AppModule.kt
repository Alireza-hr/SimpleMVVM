package com.alireza.simplemvvm.di

import android.content.Context
import com.alireza.simplemvvm.model.data.local.CharacterDao
import com.alireza.simplemvvm.model.data.local.CharacterDataBase
import com.alireza.simplemvvm.model.data.remote.CharacterRemoteWebService
import com.alireza.simplemvvm.model.data.remote.CharacterWebService
import com.alireza.simplemvvm.model.data.repository.CharacterRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context)
            = CharacterDataBase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: CharacterDataBase)
            = db.characterDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: CharacterRemoteWebService,
                          localDataSource: CharacterDao
    ) = CharacterRepository(remoteDataSource, localDataSource)
}