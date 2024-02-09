package com.example.fitnesstrackigapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fitnessapp2.R
import com.example.fitnessapp2.Screen

@Composable
fun LandingPage(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize().background(
            brush = Brush.linearGradient(
                0.0f to colorResource(id = R.color.primary1),
                1.0f to colorResource(id = R.color.primary2),
                start = Offset(10f, 10f),
                end = Offset(100f, 100f)
            )
        ),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WorkoutOptionButton(
                text = "Cardio",
                onClick = { navController.navigate(Screen.CardioWorkout.route) },
                imageId = R.drawable.cardio_logo
            )
            Spacer(modifier = Modifier.height(16.dp))
            WorkoutOptionButton(
                text = "Weight Training",
                onClick = { navController.navigate(Screen.WeightTraining.route) },
                imageId = R.drawable.weight_training
            )
            Spacer(modifier = Modifier.height(16.dp))
            WorkoutOptionButton(
                text = "Yoga",
                onClick = { navController.navigate(Screen.Yoga.route) },
                imageId = R.drawable.yoga_logo
            )
            Spacer(modifier = Modifier.height(16.dp))
            WorkoutOptionButton(
                text = "Calisthenics",
                onClick = { navController.navigate(Screen.Calisthenics.route) },
                imageId = R.drawable.calasthetics_logo
            )
        }
    }
}

@Composable
fun WorkoutOptionButton(text: String, onClick: () -> Unit,imageId: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp).clip(RoundedCornerShape(100.dp)),
        color = Color(0xFFF5FAFA),
        elevation = 10.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp).clip(RoundedCornerShape(100.dp))
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, style = MaterialTheme.typography.headlineSmall)
        }
    }
}

@Preview
@Composable
fun LandingPagePreview() {
    val navController = rememberNavController()
    LandingPage(navController)
}
