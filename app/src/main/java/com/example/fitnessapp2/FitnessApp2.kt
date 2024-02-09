package com.example.fitnessapp2

import android.app.Application
import com.google.firebase.FirebaseApp
//this class is used to initialize the app and firebase, this class has global scope
class FitnessApp2 : Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
        FirebaseApp.initializeApp(this)
    }
}