package com.example.fitnesstrackigapp.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
//state for usercreds, like if the data is loaded or not
data class UserCredsState(
    val userCreds: List<UserCreds> = emptyList(),
    val username: MutableState<String> = mutableStateOf(""),
)
