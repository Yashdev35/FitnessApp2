package com.example.fitnesstrackigapp.data

import kotlinx.coroutines.flow.Flow

class UserCredsRepository(
    private val userCredsDao: UserCredsDao
) {
    suspend fun addUserCreds(userCredsEntity: UserCreds) {
            userCredsDao.insertUserCreds(userCredsEntity)
        }
    fun getUserCreds(id : Long): Flow<UserCreds> {
                return userCredsDao.getUserCreds(id)
            }
    fun getUserCredsHistory(): Flow<List<UserCreds>> {
                return userCredsDao.getAllUserCreds()
            }
    suspend fun updateUserCreds(userCredsEntity: UserCreds) {
                userCredsDao.updateUserCreds(userCredsEntity)
            }
    suspend fun deleteUserCreds(userCredsEntity: UserCreds) {
                userCredsDao.deleteUserCreds(userCredsEntity)
            }
}