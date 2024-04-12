package com.videoplayer.data.model

import com.videoplayer.domain.model.Event
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class EventResponse(
    @SerialName("id") var id: String,
    @SerialName("title") var title: String,
    @SerialName("subtitle") var subtitle: String,
    @SerialName("date") var date: String,
    @SerialName("imageUrl") var imageUrl: String,
    @SerialName("videoUrl") var videoUrl: String,
)

fun EventResponse.toDomain(): Event = Event(
    id = id,
    title = title,
    subtitle = subtitle,
    date = date,
    imageUrl = imageUrl,
    videoUrl = videoUrl,
)
