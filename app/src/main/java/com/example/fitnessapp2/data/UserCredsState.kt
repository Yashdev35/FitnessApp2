package com.example.fitnesstrackigapp.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class UserCredsState(
    val userCreds: List<UserCreds> = emptyList(),
    val username: MutableState<String> = mutableStateOf(""),
)
