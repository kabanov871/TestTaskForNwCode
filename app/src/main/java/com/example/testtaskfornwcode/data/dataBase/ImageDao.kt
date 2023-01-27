package com.example.testtaskfornwcode.data.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testtaskfornwcode.data.models.DbModel

@Dao
interface ImageDao {

    @Insert
    suspend fun insertImage(dbModel: DbModel)

    @Query("SELECT * FROM image_table")
    fun getAllImages(): LiveData<List<DbModel>>

    @Query("DELETE FROM image_table")
    suspend fun clearImages()
}