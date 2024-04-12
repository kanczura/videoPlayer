package com.videoplayer.presentation.eventslist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun EventsScreen(
    navController: NavController,
) {
    val viewModel: EventsViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.event.collectLatest {
            when (it) {
                is Event.NavigateToVideo -> {
                    val encodedUrl =
                        withContext(Dispatchers.IO) {
                            URLEncoder.encode(it.videoUrl, StandardCharsets.UTF_8.toString())
                        }
                    navController.navigate("PLAYER_ROUTE/$encodedUrl")
                }
            }
        }
    }

    EventsContent(
        state = state.value,
        onEventClicked = { event -> viewModel.onEventClicked(event) },
    )
}
