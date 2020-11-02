package com.example.white.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.white.data.entities.MyCharacter

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun storeList(data: List<MyCharacter>)

    @Query("select * from characters")
    fun getAllLive(): LiveData<List<MyCharacter>>

}