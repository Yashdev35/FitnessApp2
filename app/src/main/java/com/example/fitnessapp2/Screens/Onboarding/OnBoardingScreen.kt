package com.example.fitnesstrackigapp.Screens.Onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitnessapp2.R
import com.example.fitnessapp2.Screen
import kotlinx.coroutines.launch
//this page will load the on boarding pages
@Composable
fun OnBoardingPage(
    mainHeading: String,
    bodyText: String,
    image: Int,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = "Onboarding Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.909f),
            )
            Text(
                text = mainHeading,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            Text(
                text = bodyText,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPages(
    navController: NavController
){
    val onboardingPages = listOf(
        OnboardingPage(
            mainHeading = "Track Your Goals",
            bodyText = "Dont worry if you have trouble determining your goals, We will help you to track your fitness and health",
            image = R.drawable.on_boarding1
        ),
        OnboardingPage(
            mainHeading = "Get Burn",
            bodyText = "Lets keep burning, to achieve your goals, it hurts only temporary, but if you quit, the pain will last forever",
            image = R.drawable.on_boarding2
        ),
        OnboardingPage(
            mainHeading = "Eat Well",
            bodyText = "lets start a healthy lifestyle with us, we will help you to track your diet and nutrition",
            image = R.drawable.on_boarding3
        ),
        OnboardingPage(
            mainHeading = "Improve Sleep Quality",
            bodyText = "Sleep is the best meditation, we will help you to improve your sleep quality and track your sleep patterns",
            image = R.drawable.on_boarding4
        )
    )
val pagerState = rememberPagerState(0,0f) { 4 }
    //scrolling with button requires a suspend function , so we use coroutine scope
    val scope = rememberCoroutineScope()
    val gradientPrimary = Brush.horizontalGradient(
        colors = listOf(
            colorResource(id = R.color.primary1),
            colorResource(id = R.color.primary2)
        )
    )
    val animaitonPlayed = remember { mutableStateOf(false) }
    val currentPage by animateFloatAsState(
        targetValue = if(animaitonPlayed.value){(pagerState.currentPage.toFloat()/3)}else {0f},
        animationSpec = tween(300)
    )
    LaunchedEffect(pagerState.currentPage){
        animaitonPlayed.value = true
    }
    Box {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            key = {onboardingPages[it].image}
        ) {
               OnBoardingPage(
                    mainHeading = onboardingPages[it].mainHeading,
                    bodyText = onboardingPages[it].bodyText,
                    image = onboardingPages[it].image
                )
        }
        Surface(
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp, end = 32.dp, start = 32.dp)
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.BottomEnd).clip(RoundedCornerShape(50.dp)),
            color = MaterialTheme.colorScheme.primary
        ) {

     IconButton(onClick ={
    scope.launch {
       if(pagerState.currentPage < 3){
           pagerState.animateScrollToPage(pagerState.currentPage + 1)
       }else{
           /*TODO*/
           //open the welcome screen
              navController.navigate(Screen.ProfileSetup.route)
       }
    }
},
modifier = Modifier.background(gradientPrimary)
) {
         CircularProgressIndicator(progress = currentPage, modifier = Modifier.size(70.dp))
    Icon(
        imageVector = Icons.Default.KeyboardArrowRight,
        contentDescription = "Next",
        tint = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.size(45.dp)
    )
}
        }
        }
    }


@Preview(showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    //OnboardingPages({})
}