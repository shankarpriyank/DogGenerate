package com.priyank.dogsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.priyank.dogsapp.data.model.DogInfo

@Dao
interface DogsDao {
    @Insert()
    suspend fun insertImage(image: DogInfo)

    @Query("SELECT * FROM dogTable O")
    suspend fun getAllImages(): List<DogInfo>

    @Query("SELECT COUNT(*) FROM dogTable")
    suspend fun getTotalEntries(): Int

    @Query("DELETE FROM dogTable WHERE id = (SELECT MIN(id) FROM dogTable)")
    suspend fun deleteFirstEntry()

    @Query("DELETE FROM dogTable")
    suspend fun deleteAllEntries()
}
