package com.ankit.spendwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ankit.spendwise.presentation.screen.RegisterScreen
import com.ankit.spendwise.presentation.screen.login.LoginScreen
import com.ankit.spendwise.presentation.screen.onboardingscreen.OnBoardingScreen
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendWiseTheme(dynamicColor = false) {
//                OnBoardingScreen(onGetStarted = {}) {
//
//                }

              //  LoginScreen()
                RegisterScreen(){

                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpendWiseTheme(dynamicColor = false) {
        Greeting("Android")
    }
}