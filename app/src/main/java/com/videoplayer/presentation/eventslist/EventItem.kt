package com.videoplayer.presentation.eventslist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.videoplayer.R
import com.videoplayer.domain.model.Event
import com.videoplayer.presentation.formatEventDate
import com.videoplayer.presentation.theme.largeFont
import com.videoplayer.presentation.theme.mediumFont
import com.videoplayer.presentation.theme.smallFont

@Composable
fun EventItem(
    event: Event,
    onClick: (String) -> Unit = {},
) {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onClick(event.videoUrl)
            }
            .padding(12.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
    ) {
        AsyncImage(
            modifier = Modifier
                .size(120.dp)
                .padding(6.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(event.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Call icon",
        )
        Column {
            Text(
                text = event.title,
                color = colorResource(id = R.color.black),
                style = largeFont,
            )
            Text(
                text = event.subtitle,
                color = colorResource(id = R.color.black),
                style = mediumFont,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = formatEventDate(event.date),
                color = colorResource(id = R.color.black),
                style = smallFont,
            )
        }
    }
}

@Preview
@Composable
fun PreviewEventItemComponent() {
    EventItem(
        Event(
            id = "1",
            title = "United vs Juventus",
            subtitle = "Champions League",
            date = "2024-04-06T02:35:18.851Z",
            videoUrl = "",
            imageUrl = "",
        )
    )
}