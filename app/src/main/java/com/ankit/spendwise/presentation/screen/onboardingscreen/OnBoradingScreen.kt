package com.ankit.spendwise.presentation.screen.onboardingscreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ankit.spendwise.presentation.screen.SplashScreen
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme


@Composable
fun OnBoardingScreen() {

}


@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun OnBoardingScreenNight() {
    SpendWiseTheme(dynamicColor = false) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            OnBoardingScreen()
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun OnBoardingScreenDay() {
    SpendWiseTheme(dynamicColor = false) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            OnBoardingScreen()
        }
    }
}