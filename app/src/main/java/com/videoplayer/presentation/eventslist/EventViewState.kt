package com.videoplayer.presentation.eventslist

import com.videoplayer.domain.model.Event

data class EventViewState(
    val data: List<Event> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
