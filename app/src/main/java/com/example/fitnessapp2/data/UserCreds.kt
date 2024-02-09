package com.example.fitnesstrackigapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//this is the data class which holds the user credentials, like age , name ,gender
@Entity()
data class UserCreds(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "age")
    val age: Float,
    @ColumnInfo(name = "steps")
    val steps: Int,
    @ColumnInfo(name = "bmi")
    val bmi: Float,
    @ColumnInfo(name = "waterIntake")
    val waterIntake: Int,
    @ColumnInfo(name = "caloriesBurnt")
    val caloriesBurnt: Float,
)
