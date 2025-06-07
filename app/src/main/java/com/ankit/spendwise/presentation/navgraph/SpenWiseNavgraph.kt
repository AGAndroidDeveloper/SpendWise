package com.ankit.spendwise.presentation.navgraph

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.ankit.spendwise.presentation.screen.RegisterScreen
import com.ankit.spendwise.presentation.screen.SplashScreen
import com.ankit.spendwise.presentation.screen.home.HomeScreen
import com.ankit.spendwise.presentation.screen.login.LoginScreen
import com.ankit.spendwise.presentation.screen.onboardingscreen.OnBoardingScreen
import kotlinx.serialization.Serializable


@Serializable
data object SplashScreen : NavKey

@Serializable
data object Login : NavKey

@Serializable
data object Signup : NavKey

@Serializable
data object OnBoarding : NavKey

@Serializable
data object Home : NavKey

@Composable
fun SpendWiseNavDisplay() {
    //  val backStack = remember { mutableStateListOf<Any>(OnBoarding) }
    val backStack = rememberNavBackStack(OnBoarding)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        transitionSpec = {
            // Slide in from right when navigating forward
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
            ) togetherWith
                    slideOutHorizontally(
                        targetOffsetX = { -it },
                        animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
                    )
        },
        popTransitionSpec = {
            // Slide in from left when navigating back
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
            ) togetherWith
                    slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = spring(stiffness = Spring.StiffnessMediumLow)
                    )
        },
        entryProvider = { key ->
            when (key) {
                is SplashScreen -> {
                    NavEntry(key) {
                        SplashScreen() {
                            backStack.add(OnBoarding)
                        }
                    }
                }

                is Login -> {
                    NavEntry(key) {
                        LoginScreen()
                    }

                }

                is Signup -> {
                    NavEntry(key) {
                        RegisterScreen { }
                    }
                }

                is OnBoarding -> {
                    NavEntry(key) {
                        OnBoardingScreen(onGetStarted = {
                            backStack.add(Signup)
                        }) {
                            backStack.add(Login)
                        }
                    }
                }

                is Home -> {
                    NavEntry(key) {
                        HomeScreen()
                    }
                }

                else -> {
                    NavEntry(key) {
                        //SplashScreen()
                    }
                }
            }
        })
}