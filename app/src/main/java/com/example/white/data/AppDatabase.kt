package com.example.white.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.white.data.dao.CharacterDao
import com.example.white.data.entities.MyCharacter

@Database(entities = [MyCharacter::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
}