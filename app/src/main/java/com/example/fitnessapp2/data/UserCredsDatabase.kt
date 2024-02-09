package com.example.fitnesstrackigapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [UserCreds::class],
    version = 1,
    exportSchema = false
    )
abstract class UserCredsDatabase : RoomDatabase() {
    abstract fun userCredsDao(): UserCredsDao

}