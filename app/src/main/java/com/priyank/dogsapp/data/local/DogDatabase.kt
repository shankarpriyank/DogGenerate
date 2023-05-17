package com.priyank.dogsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.priyank.dogsapp.data.model.DogInfo

@Database(entities = [DogInfo::class], version = 1)
abstract class DogDatabase : RoomDatabase() {
    abstract val DogsDao: DogsDao
}
