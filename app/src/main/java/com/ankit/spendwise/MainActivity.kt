package com.ankit.spendwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation3.runtime.rememberNavBackStack
import com.ankit.spendwise.domain.BottomDestinations
import com.ankit.spendwise.domain.Constant.BottomNavItems
import com.ankit.spendwise.presentation.navgraph.OnBoarding
import com.ankit.spendwise.presentation.navgraph.SpendWiseNavDisplay
import com.ankit.spendwise.presentation.ui.theme.SpendWiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendWiseTheme(dynamicColor = false) {
                val backStack = rememberNavBackStack(OnBoarding)
                val screenState = rememberSaveable { mutableIntStateOf(0) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedVisibility(visible = BottomNavItems.contains(BottomNavItems[screenState.intValue])) {
                            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                                BottomNavItems.forEachIndexed { index, screen ->
                                    BottomNavigationItem(index, screen, screenState)
                                }

                            }
                        }
                    }) {
                    SpendWiseNavDisplay(Modifier.padding(it), backStack)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RowScope.BottomNavigationItem(
    index: Int,
    screen: BottomDestinations,
    screenState: MutableIntState
) {
    NavigationBarItem(
        label = {
            AnimatedVisibility(visible = screenState.intValue == index) {
                Text(text = screen.title)
            }
        },
        onClick = {
            screenState.intValue = index
        },
        selected = screenState.intValue == index,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(screen.icon), contentDescription = screen.title,
                tint = if (screenState.intValue == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
            )
        })

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    SpendWiseTheme(dynamicColor = false) {
//        Scaffold(modifier = Modifier.fillMaxSize()) {
//          //  SpendWiseNavDisplay(Modifier.padding(it), backStack)
//        }
//    }
}