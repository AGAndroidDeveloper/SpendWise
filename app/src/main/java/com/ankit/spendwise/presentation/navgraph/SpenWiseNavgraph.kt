package com.ankit.spendwise.presentation.navgraph

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import com.ankit.spendwise.presentation.ProfileScreen
import com.ankit.spendwise.presentation.screen.RegisterScreen
import com.ankit.spendwise.presentation.screen.SplashScreen
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

@Serializable
data object Statics : NavKey

@Serializable
data object Wallet : NavKey

@Serializable
data object Profile : NavKey

@Composable
fun SpendWiseNavDisplay(modifier: Modifier, backStack: NavBackStack) {
    //  val backStack = remember { mutableStateListOf<Any>(OnBoarding) }

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
                        LoginScreen(){
                            backStack.add(Home)
                           // backStack.clear()
                        }
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
//                        when(screenState.intValue){
//                            0 -> {
//                                backStack.add(Home)
//                            }
//                            1 -> {
//                                backStack.add(Statics)
//                            }
//                            2 -> {
//                                backStack.add(Wallet)
//                            }
//                            3 -> {
//                                backStack.add(Profile)
//                            }
//                        }
//                        HomeScreen(screens = BottomNavItems, screenState = screenState)
                    }
                }

                is Statics -> {
                    NavEntry(key) {
                        //SplashScreen()
                    }
                }

                is Wallet -> {
                    NavEntry(key) {
                        //SplashScreen()
                        Text(text = "Wallet", modifier = Modifier.fillMaxSize())
                    }
                }

                is Profile -> {
                    NavEntry(key) {
                        //SplashScreen()
                        ProfileScreen(modifier = Modifier.fillMaxSize())
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