package com.ankit.spendwise.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.ankit.spendwise.R

data class BottomDestinations(val title: String, val icon: Int, val route: String? = null)
object Constant {

    val BottomNavItems = listOf(
        BottomDestinations(
            title = "Home",
            icon = R.drawable.home,
            route = "home"
        ),
        BottomDestinations(
            title = "Statistics",
            icon = R.drawable.bar_char,
            route = "Statistics"
        ),

        BottomDestinations(
            title = "Wallet",
            icon = R.drawable.wallet,
            route = "Wallet"
        ),

        BottomDestinations(
            title = "Profile",
            icon = R.drawable.user,
            route = "Profile"
        ),
    )

    val profileItemChip = listOf(
        BottomDestinations(
            title = "Invite Friends",
            icon = R.drawable.diamond__dark_,
            route = "Invite Friends"
        ),
        BottomDestinations(
            title = "Account info",
            icon = R.drawable.user_fill_1,
            route = "Account info"
        ),

        BottomDestinations(
            title = "Personal profile",
            icon = R.drawable.users_fill_1,
            route = "Personal profile"
        ),
        BottomDestinations(
            title = "Message center",
            R.drawable.envelope_simple_fill_1,
            route = "Profile"
        ),
        BottomDestinations(
            title = "Login and security",
            R.drawable.shield_checkered_fill_1,
            route = "Login and security"
        ),
        BottomDestinations(
            title = "Data and privacy",
            R.drawable.lock_key_fill_1,
            route = "Data and privacy"
        ),

    )


}