package com.example.fitnessapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp2.ui.theme.FitnessApp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        scheduleDailyAlarm(applicationContext, 20,7,"its morbing time")
        scheduleDailyAlarm(applicationContext, 16,30,"its morbin time")
        scheduleDailyAlarm(applicationContext, 6,30,"its morbing time")
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FitnessApp2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FitNav(navController = navController)
                }
            }
        }
    }
}

