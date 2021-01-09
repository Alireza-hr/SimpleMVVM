package com.alireza.simplemvvm.model.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alireza.simplemvvm.model.data.entities.Character

@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class CharacterDataBase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {
        @Volatile  private var instance: CharacterDataBase? = null

        public fun getDatabase(context: Context): CharacterDataBase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, CharacterDataBase::class.java, "characters")
                .fallbackToDestructiveMigration()
                .build()
    }
}