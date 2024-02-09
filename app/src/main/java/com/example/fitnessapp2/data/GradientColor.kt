package com.example.fitnesstrackigapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

class GradientColor {
    val priamaryColor = Brush.Companion.horizontalGradient(
        colors = listOf(Color(0xFF92A3FD), Color(0xFF9DCEFF)))
    val secondaryColor = Brush.Companion.horizontalGradient(
        colors = listOf(Color(0xFFC58BF2), Color(0xFFEEA4CE)))
}