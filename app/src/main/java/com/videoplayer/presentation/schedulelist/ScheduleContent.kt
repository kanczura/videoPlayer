package com.videoplayer.presentation.schedulelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.videoplayer.domain.model.Schedule
import com.videoplayer.presentation.theme.VideoPlayerTheme

@Composable
fun ScheduleContent(
    state: ScheduleViewState,
) {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(items = state.data, key = { it.id }) { schedule ->
            ScheduleItem(
                schedule = schedule
            )
        }
    }
}

@Preview
@Composable
fun PreviewScheduleScreen() {
    VideoPlayerTheme {
        ScheduleContent(
            state = ScheduleViewState(
                data = listOf(
                    Schedule(
                        id = "1",
                        title = "United vs Juventus",
                        subtitle = "Champions League",
                        date = "2024-04-06T02:35:18.851Z",
                        imageUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg"
                    ),
                    Schedule(
                        id = "2",
                        title = "United vs Juventus",
                        subtitle = "Champions League",
                        date = "2024-04-06T02:35:18.851Z",
                        imageUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg"
                    ),
                    Schedule(
                        id = "3",
                        title = "United vs Juventus",
                        subtitle = "Champions League",
                        date = "2024-04-06T02:35:18.851Z",
                        imageUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg"
                    )
                )
            )
        )
    }
}