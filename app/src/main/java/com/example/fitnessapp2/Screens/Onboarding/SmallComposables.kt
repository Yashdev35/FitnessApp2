package com.example.fitnesstrackigapp.Screens.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessapp2.R
import kotlinx.coroutines.launch
 @Composable
fun RoundedCornerButton(
    text: String,
    onClick: () -> Unit
){
     Surface(
         shape = RoundedCornerShape(100),
         modifier = Modifier
             .padding(bottom = 32.dp, end = 32.dp, start = 32.dp).
                 fillMaxWidth()
             .wrapContentSize(align = Alignment.BottomCenter).clip(RoundedCornerShape(50.dp)),
         color = colorResource(id = R.color.white)
     ){
         Text(text = text,
             style = MaterialTheme.typography.bodyMedium.copy(
                 brush = Brush.linearGradient(
                     0.0f to colorResource(id = R.color.primary1),
                     1.0f to colorResource(id = R.color.primary2),
                     start = Offset(0f, 0f),
                     end = Offset(200f, 200f)
                 )),
             color = colorResource(id = R.color.primary1),
             fontWeight = FontWeight.Bold,
             fontSize = 20.sp,
             modifier = Modifier.clickable(onClick = {
                    onClick()
             }).padding(start = 45.dp, end = 45.dp),
         )


     }
}
@Preview
@Composable
fun RoundedCornerButtonPreview(){
    RoundedCornerButton("somethng"){}
}