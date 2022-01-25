package com.example.loginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.loginscreen.components.CustomInputField
import com.example.loginscreen.components.GradientButton
import com.example.loginscreen.ui.theme.LoginScreenTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.imePadding
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.navigationBarsWithImePadding


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            LoginScreenTheme {
                MainApp()
            }


        }
    }
}

@Preview
@Composable
fun MainApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val inputValueID = remember {
            mutableStateOf("")
        }
        val inputValuePass = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            bottomStart = 25.dp,
                            bottomEnd = 25.dp
                        )
                    )
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFFB42B93),
                                Color(0xFF000000)
                            ),
                            radius = 415f
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(280.dp)
                        .offset(y = (-20.dp)),
                    painter = painterResource(id = R.drawable.coloredtorus),
                    contentDescription = "Background Image"
                )
            }

            Card(
                modifier = Modifier
                    .offset(y = -20.dp)
                    .width(290.dp),
                shape = RoundedCornerShape(25.dp),
                elevation = 15.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .padding(top = 30.dp, bottom = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Torus", style = MaterialTheme.typography.h1, modifier = Modifier.padding(bottom = 16.dp))
                    CustomInputField(inputValue = inputValueID, type = "uid")
                    CustomInputField(inputValue = inputValuePass, type = "password")
                }
            }


            GradientButton(
                modifier = Modifier.offset(y = -50.dp),
                text = "Log in",
                textColor = Color.White,
                gradient = Brush.horizontalGradient(
                    listOf(
                        Color(0xFFC4A0F4),
                        Color(0xFFCF4CB9),
                        Color(0xFFE60B41)
                    )
                )
            ) {

            }

        }
    }
}