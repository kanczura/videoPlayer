package com.videoplayer.presentation.schedulelist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.videoplayer.presentation.theme.VideoPlayerTheme

@Composable
fun ScheduleScreen(
    navController: NavController?,
) {

    val viewModel: ScheduleListViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState()

    VideoPlayerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ScheduleContent(
                state = state.value
            )
        }
    }
}
