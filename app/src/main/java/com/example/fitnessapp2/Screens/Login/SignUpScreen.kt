package com.example.fitnesstrackigapp.Screens.Login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitnessapp2.R
import com.example.fitnessapp2.Screen

import com.example.fitnesstrackigapp.data.UserCreds
import com.example.fitnesstrackigapp.data.UserCredsState
import com.example.fitnesstrackigapp.data.UserCredsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel : UserCredsViewModel
){ var isCheckBoxChecked by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    var name by remember { mutableStateOf("") }
    var check by remember{ mutableStateOf<String?>(" ") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
        contentAlignment = Alignment.TopCenter

    ){
        val userCredsList = viewModel.getUserCredsHis.collectAsState(initial = listOf())
         Column(
             modifier = Modifier
                 .fillMaxWidth()
                 .wrapContentHeight()
                 .padding(16.dp)
                 .verticalScroll(scrollState),
             verticalArrangement = Arrangement.Top,
                horizontalAlignment = CenterHorizontally
         ) {

            Text(
                text = "Hey there! \uD83D\uDC4B",
                style = MaterialTheme.typography.headlineSmall,
                color = colorResource(id = R.color.black)
            )
             Spacer(modifier = Modifier.size(14.dp))
                Text(
                    text = "Create an account",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = colorResource(id = R.color.black)
                )
                Spacer(modifier = Modifier.size(14.dp))
             TextField(value = name.toString(),
                 onValueChange = {/*TODO*/
                     name = it

                 },
                 modifier = Modifier
                     .fillMaxWidth()
                     .wrapContentHeight()
                     .background(color = colorResource(id = R.color.light_gray)),
                 colors = TextFieldDefaults.textFieldColors(
                     containerColor = colorResource(id = R.color.light_gray),
                     focusedIndicatorColor = colorResource(id = R.color.light_gray),
                     unfocusedIndicatorColor = colorResource(id = R.color.light_gray),

                     ),
                 leadingIcon = {
                     Icon(
                         painter = painterResource(id = R.drawable.__user),
                         contentDescription = "Arrow Forward",
                         modifier = Modifier
                             .size(20.dp)
                     )
                 },
                 label = {
                     Text(
                         text = "Name",
                         style = MaterialTheme.typography.bodyMedium,
                         color = colorResource(id = R.color.black)
                     )
                 }
             )
             Box (
                 modifier = Modifier
                     .fillMaxWidth()
                     .wrapContentHeight()
                     .padding(16.dp)
             ){
                 Column(
                     modifier = Modifier.fillMaxWidth(),
                     verticalArrangement = Arrangement.Center,
                     horizontalAlignment = CenterHorizontally
                 ) {
                     Spacer(modifier = Modifier.size(16.dp))
                     Row(
                         modifier = Modifier
                             .fillMaxWidth()
                             .padding(start = 16.dp, end = 16.dp),
                         horizontalArrangement = Arrangement.SpaceEvenly,
                         verticalAlignment = Alignment.CenterVertically
                     ) {
                         Image(
                             painter = painterResource(id = R.drawable.user_logo),
                             contentDescription = "existing user",
                             modifier = Modifier
                                 .size(36.dp)
                                 .clickable(onClick = {
                                     check =userCredsList.value.find { it.username== name }?.username

                                     if (isCheckBoxChecked) {
                                         if (check != null) {
                                             val id =
                                                 userCredsList.value.find { it.username == name }?.id
                                                     ?: 0L
                                             scope.launch {
                                                 navController.navigate(Screen.Welcome.route + "/$id")
                                             }
                                         } else {
                                             Toast
                                                 .makeText(
                                                     context,
                                                     "user not found click the right icon to create new profile",
                                                     Toast.LENGTH_SHORT
                                                 )
                                                 .show()
                                         }
                                     } else {
                                         Toast
                                             .makeText(
                                                 context,
                                                 "Please enter your name to display on profile",
                                                 Toast.LENGTH_SHORT
                                             )
                                             .show()
                                     }
                                 })
                         )
                         Image(
                             painter = painterResource(id = R.drawable.new_user_logo),
                             contentDescription = "new user",
                             modifier = Modifier
                                 .size(36.dp)
                                 .clickable(onClick = {
                                     val id = userCredsList.value.find { it.username == name }?.id ?: 0L
                                     if(check == null){
                                         viewModel.addUserCreds(UserCreds(
                                             username = name,
                                             gender = " ",
                                             age = 1.0f,
                                             steps = 1,
                                             bmi = 1.0f,
                                             waterIntake = 1,
                                             caloriesBurnt = 0.0f,
                                             ))
                                         scope.launch {
                                             navController.navigate(Screen.ProfileSetup.route + "/$id")
                                         }
                                     }else{
                                         Toast.makeText(context, "User already exists,click icon without + to proceed", Toast.LENGTH_SHORT).show()
                                     }
                                 })
                         )
                     }
                     Row(
                         modifier = Modifier.fillMaxWidth(),
                         horizontalArrangement = Arrangement.Start,
                         verticalAlignment = Alignment.CenterVertically
                     ) {
                         Checkbox(checked = isCheckBoxChecked, onCheckedChange = {
                             isCheckBoxChecked = it
                         })
                         ClickableText(
                             text = AnnotatedString(
                                 text = "By signing up, you agree to our terms and conditions",)
                             , onClick = {},)
                     }
                 }
             }

                Spacer(modifier = Modifier.size(16.dp))
             Button(onClick = {
                 val id = userCredsList.value.find { it.username == name }?.id ?: 0L
                 if(id > 1L){
                     val idToDel = id
                     val userToDel = userCredsList.value.find { it.id == idToDel }
                     scope.launch {
                         viewModel.deleteUserCreds(userToDel!!)
                     }
                 }else{
                     Toast.makeText(context, "No user to delete", Toast.LENGTH_SHORT).show()
                 }

             },
                 modifier = Modifier
                     .fillMaxWidth()
                     .wrapContentHeight()
                     .padding(16.dp)
                     .clip(RoundedCornerShape(100.dp))
                     .background(
                         Brush.linearGradient(
                             0.0f to colorResource(id = R.color.primary1),
                             1.0f to colorResource(id = R.color.primary2),
                             start = Offset(0f, 0f),
                             end = Offset(200f, 200f)
                         )
                     )
                 ) {
                    Text(text = "Delete this user", color = colorResource(id = R.color.brown))
             }

         }
    }
}

@Composable
fun WelcomeScreen(
    userCreds: UserCreds,
    navController: NavController
){
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(LocalConfiguration.current.screenHeightDp.dp/7))
        Image(
            painter = painterResource(id = R.drawable.greeting_name_image1),
            contentDescription = "Welcome",
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
        )
        Text(
            text = "Welcome, ${userCreds.username}! \uD83D\uDE0A",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = colorResource(id = R.color.black)
        )
        Text(
            text = "Now let's set your profile up",
            style = MaterialTheme.typography.bodyMedium.copy(
               fontSize = 16.sp
            ),
            color = colorResource(id = R.color.black)
        )
        Spacer(modifier = Modifier.size(LocalConfiguration.current.screenHeightDp.dp/18))
        Surface(
            shape = RoundedCornerShape(100),
            modifier = Modifier
                .padding(end = 32.dp, start = 32.dp)
                .wrapContentSize()
                .wrapContentSize(align = Alignment.BottomCenter)
                .clip(RoundedCornerShape(100.dp))//first round the corners then give background color, pehele shape fir color
                .background(
                    Brush.linearGradient(
                        0.0f to colorResource(id = R.color.primary1),
                        1.0f to colorResource(id = R.color.primary2),
                        start = Offset(0f, 0f),
                        end = Offset(200f, 200f)
                    )
                ),
            color = Color.Transparent
        ){
            Text(text = "Yeah!! \uD83E\uDD18",
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .clickable(onClick = {
                        /*TODO*/
                        scope.launch {
                            navController.navigate(Screen.DashBoard.route + "/${userCreds.id}")
                        }
                    })
                    .padding(start = 45.dp, end = 45.dp, bottom = 4.dp),
            )


        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview(){
    val viewState = UserCredsState()
    val viewModel = UserCredsViewModel()
    val navController = NavController(LocalContext.current)
    SignUpScreen(navController = navController,viewModel = viewModel)
   // WelcomeScreen(userCreds = UserCreds(username = "User Name"), navController = NavController(LocalContext.current))
}