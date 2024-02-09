package com.example.fitnessapp2

import android.content.Context
import androidx.room.Room
import com.example.fitnesstrackigapp.data.UserCredsDatabase
import com.example.fitnesstrackigapp.data.UserCredsRepository
//this graph object is used to provide the database and repository to the app
object Graph {
    lateinit var database : UserCredsDatabase

    val userCredsRepository by lazy {
        UserCredsRepository(database.userCredsDao())
    }

    fun provide(context : Context){
        database = Room.databaseBuilder(
            context,
            UserCredsDatabase::class.java,
            "userCreds2.db"
        ).build()

    }
}