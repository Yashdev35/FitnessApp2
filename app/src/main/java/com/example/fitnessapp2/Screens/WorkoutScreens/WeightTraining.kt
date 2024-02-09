package com.example.fitnesstrackigapp.Screens.WorkoutScreens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp2.R

@Composable
fun WeightTrainingScreen() {
    val exerciseData = listOf(
        WeightTrainingExerciseData("Bench Press", 150, "https://youtube.com/shorts/EdDqD4aKwxM?si=fGy9iFm126ktFJK0", R.drawable.bench_press_logo),
        WeightTrainingExerciseData("Deadlift", 180, "https://youtube.com/shorts/vfKwjT5-86k?si=ExmdQD8svRrb8iq2", R.drawable.deadlift_logo),
        WeightTrainingExerciseData("Dumbbell Rows", 90, "https://youtu.be/hTgYHkUjtAw?si=dbJb1e6d5zLIF3uF", R.drawable.dumbbell_logo),
        WeightTrainingExerciseData("Squats", 200, "https://youtube.com/shorts/gslEzVggur8?si=lFotEaQf7hR7eSVK", R.drawable.squat_logo)
        // Add more weight training exercises as needed
    )

    var totalCaloriesBurnt by remember { mutableStateOf(0) }

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (exercise in exerciseData) {
                WeightTrainingExerciseCard(
                    exerciseName = exercise.name,
                    instructions = "Perform ${exercise.name} for ${exercise.calories} seconds.\n\nWatch tutorial:",
                    youtubeLink = exercise.youtubeLink,
                    imageId = exercise.imageId,
                    caloriesBurnt = exercise.calories
                ) {
                    totalCaloriesBurnt += exercise.calories
                }
            }

            Text(
                text = "Total Calories Burnt: $totalCaloriesBurnt",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(top = 16.dp)
            )

            Button(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Done")
            }
        }
    }
}

data class WeightTrainingExerciseData(val name: String, val calories: Int, val youtubeLink: String, val imageId: Int)

@Composable
fun WeightTrainingExerciseCard(
    exerciseName: String,
    instructions: String,
    youtubeLink: String,
    imageId: Int,
    caloriesBurnt: Int,
    onDoneClick: () -> Unit
) {
    val context = LocalContext.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable {
                onDoneClick()
            },
        color = MaterialTheme.colors.surface,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = exerciseName, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Calories Burnt: $caloriesBurnt",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = instructions, style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = youtubeLink,
                color = Color.Blue,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.clickable {
                    openYoutubeLink(youtubeLink, context)
                }
            )
        }
    }
}

@Preview
@Composable
fun WeightTrainingScreenPreview() {
    WeightTrainingScreen()
}
