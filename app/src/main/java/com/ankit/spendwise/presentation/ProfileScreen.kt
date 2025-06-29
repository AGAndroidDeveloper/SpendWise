package com.ankit.spendwise.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ankit.spendwise.R
import com.ankit.spendwise.domain.Constant.profileItemChip
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme

@Composable
fun ProfileScreen(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.weight(1f),
                    painter = painterResource(R.drawable.rectangle_11), contentDescription = "",
                    contentScale = ContentScale.FillBounds
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.onPrimary)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onPrimary),
                    painter = painterResource(R.drawable.woman), contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
//            Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Ankit",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                items(
                    profileItemChip.size,
                    key = { profileItemChip[it].title }) { it ->
                    SingleItemChip(
                        it,
                        modifier = Modifier.fillMaxWidth(),
                        icon = profileItemChip[it].icon,
                        title = profileItemChip[it].title,
                    ) {

                    }
                }

            }
//            profileItemChip.forEachIndexed { index, destinations ->
//
//
//            }

        }
    }

}


@Composable
fun SingleItemChip(
    index: Int,
    modifier: Modifier,
    icon: Int,
    title: String,
    onClick: (Int) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .background(color = Color.Transparent)
                .clickable(onClick = { onClick.invoke(index) }),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(if (index == 0) MaterialTheme.colorScheme.primaryContainer else Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(icon), contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 20.dp),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                ),
                maxLines = 1
            )
        }

        AnimatedVisibility(visible = index == 0) {
            HorizontalDivider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = .3f), thickness = 1.dp,
                modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp))
        }
    }
    
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
fun ProfileScreenPreview() {
    SpendWiseTheme(dynamicColor = false) {
        ProfileScreen(modifier = Modifier.fillMaxSize())
    }
}