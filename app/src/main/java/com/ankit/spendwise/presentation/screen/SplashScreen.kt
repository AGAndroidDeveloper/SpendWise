package com.ankit.spendwise.presentation.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.fonts.FontFamily
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import com.ankit.spendwise.R
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme

@Composable
fun SplashScreen(onSplashFinish :() -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(R.string.app_name), modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = androidx.compose.ui.text.font.FontFamily.Serif,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        )
    }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun SplashScreenPreview() {
    SpendWiseTheme(dynamicColor = false) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            SplashScreen(){}
        }
    }
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun SplashScreenPreviewNight() {
    SpendWiseTheme(dynamicColor = false) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            SplashScreen(){}
        }

    }

}