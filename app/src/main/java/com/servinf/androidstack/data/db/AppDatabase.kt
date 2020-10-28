package com.servinf.androidstack.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.servinf.androidstack.data.db.dao.DogDao
import com.servinf.androidstack.data.db.model.Dog

@Database(
    entities = [Dog::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract val dogDao: DogDao
}