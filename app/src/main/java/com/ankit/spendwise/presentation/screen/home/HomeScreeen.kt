package com.ankit.spendwise.presentation.screen.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {})
        },
        bottomBar = {

        }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

        }

    }


}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun HomeScreenPr() {
    SpendWiseTheme(dynamicColor = false) {
        HomeScreen()
    }

}