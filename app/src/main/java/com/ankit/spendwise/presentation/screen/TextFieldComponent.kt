package com.ankit.spendwise.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun TextFieldWithTitle(
    modifier: Modifier, title: String = "",
    value: String,
    hint: String = "",
    onValueChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier,
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )
        TextField(
            value = value, onValueChange = { it -> onValueChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = hint) },
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            )
        )

    }
}

@Composable
@Preview(showBackground = true)
fun TextFieldPre() {
    TextFieldWithTitle(
        modifier = Modifier.fillMaxWidth(),
        title = "Email",
        hint = "enter your email",
        value = ""
    ) {

    }

}