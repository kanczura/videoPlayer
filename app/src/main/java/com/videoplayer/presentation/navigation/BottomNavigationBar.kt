package com.videoplayer.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.videoplayer.presentation.BottomNavItem
import com.videoplayer.presentation.eventslist.EventsScreen
import com.videoplayer.presentation.player.PlayerScreen
import com.videoplayer.presentation.schedulelist.ScheduleScreen
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun BottomNavigationBar() {
    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavItem().bottomNavigationItems().forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItem,
                        label = {
                            Text(navigationItem.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == navigationSelectedItem) {
                                    navigationItem.selectedIcon
                                } else navigationItem.unselectedIcon,
                                contentDescription = navigationItem.title
                            )
                        },
                        onClick = {
                            navigationSelectedItem = index
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.EventsScreen.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.EventsScreen.route) {
                EventsScreen(navController = navController)
            }
            composable(Screens.SchedulesScreen.route) {
                ScheduleScreen(navController = navController)
            }
            composable(
                Screens.PlayerScreen.route,
                arguments = listOf(navArgument("videoUrl") { type = NavType.StringType })
            ) {
                val encodedVideoUrl = requireNotNull(it.arguments?.getString("videoUrl"))
                val videoUrl = URLDecoder.decode(encodedVideoUrl, StandardCharsets.UTF_8.toString())
                PlayerScreen(videoUrl)
            }
        }
    }
}