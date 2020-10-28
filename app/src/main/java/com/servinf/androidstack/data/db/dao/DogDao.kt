package com.servinf.androidstack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.servinf.androidstack.data.db.model.Dog

@Dao
interface DogDao {

    @Query("SELECT * FROM dogs")
    fun findAll(): List<Dog>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(dog: Dog)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(dogs: List<Dog>)
}