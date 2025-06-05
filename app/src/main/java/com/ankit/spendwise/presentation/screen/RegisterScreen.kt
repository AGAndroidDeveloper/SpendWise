package com.ankit.spendwise.presentation.screen

import  android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ankit.spendwise.presentation.screen.login.LoginScreen
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(onBackPressed: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { onBackPressed() },
            navigationIcon = {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back"
                    )
                }
            })
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                text = "Register ",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextFieldWithTitle(
                        modifier = Modifier.weight(1f),
                        title = "First Name",
                        hint = "John",
                        value = ""
                    ) {
                        // onValueChange
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    TextFieldWithTitle(
                        modifier = Modifier.weight(1f),
                        title = "Last Name",
                        hint = "Doe",
                        value = ""
                    ) {
                        // onValueChange
                    }
                }


                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                TextFieldWithTitle(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Email",
                    hint = "jondoe@gmail.com",
                    value = ""
                ) {

                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                TextFieldWithTitle(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Password",
                    hint = "********",
                    value = ""
                ) {


                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                TextFieldWithTitle(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Confirm Password",
                    hint = "********",
                    value = ""
                ) {


                }

                Spacer(
                    modifier = Modifier
                        .weight(1f).background(color = Color.Blue),

                )

                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Login")
                }

            }

        }

    }

}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun RegisterScreenPreview() {
    SpendWiseTheme(dynamicColor = false) {
        RegisterScreen(onBackPressed = {})
    }
}


