package com.example.testtaskfornwcode.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="image_table")
data class DbModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val imageId: Int,

    val largeImage: String,

    val previewImage: String
)
