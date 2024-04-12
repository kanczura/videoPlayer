package com.videoplayer.presentation.eventslist

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
import com.videoplayer.domain.model.Event
import com.videoplayer.presentation.theme.VideoPlayerTheme

@Composable
fun EventsContent(
    state: EventViewState,
    onEventClicked: (Event) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        state = rememberLazyListState()
    ) {
        items(items = state.data, key = { it.id }) { event ->
            EventItem(
                event = event,
                onClick = { onEventClicked(event) }
            )
        }
    }
}

@Preview
@Composable
fun PreviewEventsContent() {
    VideoPlayerTheme {
        EventsContent(
            state = EventViewState(
                data = listOf(
                    Event(
                        id = "1",
                        title = "United vs Juventus",
                        subtitle = "Champions League",
                        date = "2024-04-06T02:35:18.851Z",
                        videoUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg",
                        imageUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg"
                    ),
                    Event(
                        id = "2",
                        title = "United vs Juventus",
                        subtitle = "Champions League",
                        date = "2024-04-06T02:35:18.851Z",
                        videoUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg",
                        imageUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg"
                    ),
                    Event(
                        id = "3",
                        title = "United vs Juventus",
                        subtitle = "Champions League",
                        date = "2024-04-06T02:35:18.851Z",
                        videoUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg",
                        imageUrl = "https://pl.wikipedia.org/wiki/Grafika_Google#/media/Plik:Google_Images_2015_logo.svg"
                    ),
                )
            ),
            onEventClicked = {},
        )
    }
}
