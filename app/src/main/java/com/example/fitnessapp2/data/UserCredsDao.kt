package com.example.fitnesstrackigapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserCredsDao {
    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
   abstract suspend fun insertUserCreds(userCreds: UserCreds)

   @Update
    abstract suspend fun updateUserCreds(userCreds: UserCreds)

   @Query("SELECT * FROM usercreds where id = :id")
   abstract fun getUserCreds(id : Long): Flow<UserCreds>

   @Query("SELECT * FROM usercreds")
    abstract fun getAllUserCreds(): Flow<List<UserCreds>>

    @Delete
    abstract suspend fun deleteUserCreds(userCreds: UserCreds)
}