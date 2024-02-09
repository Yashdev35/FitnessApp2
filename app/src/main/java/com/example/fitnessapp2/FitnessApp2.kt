package com.example.fitnessapp2

import android.app.Application
import com.google.firebase.FirebaseApp

class FitnessApp2 : Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
        FirebaseApp.initializeApp(this)
    }
}