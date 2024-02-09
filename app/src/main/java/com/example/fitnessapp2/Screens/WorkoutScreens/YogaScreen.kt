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
fun YogaWorkoutScreen() {
    val exerciseData = listOf(
        YogaExerciseData("Downward Dog", "Hold for 1 minute.\n\nWatch tutorial:", "https://youtu.be/EC7RGJ975iM?si=iCWRefrp2UzYCcPb",50 ,R.drawable.yoga_logo),
        YogaExerciseData("Tree Pose", "Hold for 45 seconds on each leg.\n\nWatch tutorial:", "https://youtu.be/wdln9qWYloU?si=r8l6deJ7n5yaPgUb",50 ,R.drawable.yoga_logo),
        YogaExerciseData("Child's Pose", "Hold for 2 minutes.\n\nWatch tutorial:", "https://youtu.be/kH12QrSGedM?si=FJVQh2v7jHevaKBJ",50 ,R.drawable.yoga_logo),
        YogaExerciseData("Warrior II", "Hold for 1 minute on each side.\n\nWatch tutorial:", "https://youtu.be/Mn6RSIRCV3w?si=zP1C-2iELjgu1hAp4",50 ,R.drawable.yoga_logo)
        // Add more yoga exercises as needed
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
                YogaExerciseCard(
                    exerciseName = exercise.name,
                    instructions = "Perform ${exercise.name}.\n\nWatch tutorial:",
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

data class YogaExerciseData(val name: String,val instructions: String, val youtubeLink: String, val calories: Int, val imageId: Int)

@Composable
fun YogaExerciseCard(
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
fun YogaWorkoutScreenPreview() {
    YogaWorkoutScreen()
}
