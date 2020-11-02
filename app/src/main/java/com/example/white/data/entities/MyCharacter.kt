package com.example.white.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class MyCharacter(
    @PrimaryKey
    val char_id: Int,
    val name: String,
    val img: String
)