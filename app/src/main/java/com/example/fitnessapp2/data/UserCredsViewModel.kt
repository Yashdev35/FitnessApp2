package com.example.fitnesstrackigapp.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp2.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
//viewmodel for usercreds, it bridges between the data and the ui and handles the logic , like update and delete etc.
class UserCredsViewModel(
    private val repository: UserCredsRepository = Graph.userCredsRepository
): ViewModel() {

    var usernameState by mutableStateOf("")
    var genderState by mutableStateOf("")
    var ageState by mutableStateOf(0f)
    var stepsState by mutableStateOf(0)
    var bmiState by mutableStateOf(0f)
    var waterIntakeState by mutableStateOf(0)
    var caloriesBurntState by mutableStateOf(0f)

    fun onUsernameChanged(newString: String){
        usernameState = newString
    }
    fun onGenderChanged(newString: String){
        genderState = newString
    }
    fun onAgeChanged(newFloat: Float){
        ageState = newFloat
    }
    fun onStepsChanged(newInt: Int){
        stepsState = newInt
    }
    fun onBmiChanged(newFloat: Float){
        bmiState = newFloat
    }
    fun onWaterIntakeChanged(newInt: Int){
        waterIntakeState = newInt
    }
    fun onCaloriesBurntChanged(newFloat: Float){
        caloriesBurntState = newFloat
    }

    lateinit var getUserCredsHis : Flow<List<UserCreds>>

    init {
        viewModelScope.launch {
            getUserCredsHis = repository.getUserCredsHistory()
        }
    }
      //the usercreds dao functions are called here
    fun addUserCreds(userCreds: UserCreds) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUserCreds(userCreds)
        }
    }
    fun updateUserCreds(userCreds: UserCreds) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUserCreds(userCreds)
        }
    }

    fun getUserCreds(id: Long): Flow<UserCreds> {
        return repository.getUserCreds(id)
    }

    fun deleteUserCreds(userCreds: UserCreds) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUserCreds(userCreds)
        }
    }
}

