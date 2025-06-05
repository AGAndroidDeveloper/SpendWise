package com.ankit.spendwise.presentation.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme


@Composable
fun HomeScreen(){

}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun HomeScreenPr(){
    SpendWiseTheme(dynamicColor = false) {
        HomeScreen()
    }

}