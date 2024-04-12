package com.videoplayer.presentation.schedulelist

import com.videoplayer.domain.model.Schedule

data class ScheduleViewState(
    val data: List<Schedule> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
