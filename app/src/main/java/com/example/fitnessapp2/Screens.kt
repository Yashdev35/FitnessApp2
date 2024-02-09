package com.example.fitnessapp2

sealed class Screen(val route: String) {
    object OnBoarding : Screen("onboarding_screen")
    object GetStarted : Screen("get_started_screen")
    object Login : Screen("login_screen")
    object SignUp : Screen("signup_screen")
    object DashBoard : Screen("home_screen")
    object Welcome : Screen("welcome_screen")
    object ProfileSetup : Screen("profile_set_screen")
    object CardioWorkout : Screen("cardio_workout_screen")
    object WeightTraining : Screen("weight_training_screen")
    object Yoga : Screen("yoga_screen")
    object Calisthenics : Screen("calisthenics_screen")
    object WorkingOutLanding : Screen("work_landing_screen")
}