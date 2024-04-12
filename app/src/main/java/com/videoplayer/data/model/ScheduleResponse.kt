package com.videoplayer.data.model

import com.videoplayer.domain.model.Schedule
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ScheduleResponse(
    @SerialName("id") var id: String,
    @SerialName("title") var title: String,
    @SerialName("subtitle") var subtitle: String,
    @SerialName("date") var date: String,
    @SerialName("imageUrl") var imageUrl: String,
)

fun ScheduleResponse.toDomain(): Schedule = Schedule(
    id = id,
    title = title,
    subtitle = subtitle,
    date = date,
    imageUrl = imageUrl,
)
