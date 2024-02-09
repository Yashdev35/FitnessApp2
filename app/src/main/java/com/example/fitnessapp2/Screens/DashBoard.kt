package com.example.fitnesstrackigapp.Screens

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp2.Screen
import com.example.fitnesstrackigapp.data.UserCreds
import com.example.fitnesstrackigapp.data.UserCredsViewModel
import kotlinx.coroutines.launch

@Composable
fun Dashboard(
    userId: Long,
    viewModel: UserCredsViewModel,
    navController: NavController
) {
    val user = viewModel.getUserCreds(userId).collectAsState(initial = null).value?: UserCreds(0,"","",1.0f,1,1f,1,0f)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Greeting(name = "Greetings ${user.username}")
        Spacer(modifier = Modifier.height(16.dp))
        WaterIntakeProgress(waterIntake = remember{ mutableStateOf(viewModel.waterIntakeState) }, goal = remember{ mutableStateOf(8)})
        Spacer(modifier = Modifier.height(16.dp))
        CaloriesBurnt(caloriesBurnt = remember{ mutableStateOf(viewModel.caloriesBurntState) })
        Spacer(modifier = Modifier.height(16.dp))
        TodaysGoal(goal = 10000, current = remember{ mutableStateOf(viewModel.stepsState) })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate(Screen.WorkingOutLanding.route)
        }) {
            Text(text = "To workouts")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun WaterIntakeProgress(waterIntake: MutableState<Int>, goal: MutableState<Int>) {
    val currentWaterIntake by rememberUpdatedState(waterIntake.value)
    val scope = rememberCoroutineScope()
    val animatedProgress = remember { Animatable(currentWaterIntake.toFloat() / goal.value.toFloat()) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Water Intake", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            CircularProgressBar(progress = animatedProgress.value)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Today's Water Intake: $currentWaterIntake glasses")
            Text(text = "Goal: ${goal.value} glasses")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {

                waterIntake.value = waterIntake.value + 1
                scope.launch {
                    animatedProgress.animateTo(waterIntake.value.toFloat() / goal.value.toFloat())
                }
            }) {
                Text(text = "+ 1")
            }
        }
    }
}

@Composable
fun CircularProgressBar(progress: Float) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(150.dp)
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.size(150.dp),
            color = Color.Blue,
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Blue
        )
    }
}



@Composable
fun CaloriesBurnt(caloriesBurnt: MutableState<Float>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Calories Burnt", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${caloriesBurnt.value} calories burnt today")
        }
    }
}

@Composable
fun TodaysGoal(goal: Int, current: MutableState<Int>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Today's Goal", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Your goal for today is to achieve $goal steps\n current ${current.value} steps"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {

                current.value = current.value + 100
            }) {
                Text(text = "+ 100")
            }
        }
    }
}


@Preview
@Composable
fun PreviewDashboard() {
    val navController = rememberNavController()
    val viewModel = UserCredsViewModel()
    val id = 1L
    Dashboard(navController = navController, viewModel = viewModel, userId = id)
}
