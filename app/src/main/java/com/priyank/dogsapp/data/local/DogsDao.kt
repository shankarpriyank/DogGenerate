package com.priyank.dogsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.priyank.dogsapp.data.model.DogInfo

@Dao
interface DogsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(image: String)

    @Query("SELECT * FROM dogTable ORDER BY id DESC LIMIT 20")
    suspend fun getAllImages(): List<DogInfo>

    @Query("DELETE FROM dogTable where id NOT IN (SELECT id from dogTable ORDER BY id ASC LIMIT 20)")
    fun clearTable()
}
