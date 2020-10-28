package com.servinf.androidstack.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Model class for a dog
 */
@Entity(tableName = "dogs")
class Dog {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String = ""

    @SerializedName("created_at")
    @Expose
    var createdAt: String = ""

    @SerializedName("years")
    @Expose
    var years: String = ""
}