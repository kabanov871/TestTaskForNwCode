package com.example.testtaskfornwcode.data.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testtaskfornwcode.data.models.DbModel

@Database(entities = [DbModel::class], version = 1)
abstract class ImageDatabase: RoomDatabase() {

    abstract val imageDao: ImageDao

    companion object{
        @Volatile
        private var INSTANCE : ImageDatabase? = null
        fun getInstance(context: Context):ImageDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext, ImageDatabase::class.java, "database"
                    ).build()
                }
                return instance
            }
        }

    }
}