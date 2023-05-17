package com.priyank.dogsapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DogTable")
data class DogInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val message: String?,
    val status: String
)
