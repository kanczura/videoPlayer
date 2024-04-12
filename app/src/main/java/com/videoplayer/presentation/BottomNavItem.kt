package com.videoplayer.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.videoplayer.presentation.navigation.Screens

data class BottomNavItem(
    val title: String = "",
    val selectedIcon: ImageVector = Icons.Filled.Home,
    val unselectedIcon: ImageVector = Icons.Filled.Home,
    val route: String = "",
) {

    fun bottomNavigationItems(): List<BottomNavItem> {
        return listOf(
            BottomNavItem(
                title = "Events",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                route = Screens.EventsScreen.route,
            ),
            BottomNavItem(
                title = "Schedule",
                selectedIcon = Icons.Filled.DateRange,
                unselectedIcon = Icons.Outlined.DateRange,
                route = Screens.SchedulesScreen.route,
            ),
        )
    }
}
