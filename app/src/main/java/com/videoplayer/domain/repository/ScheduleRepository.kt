package com.videoplayer.domain.repository

import com.videoplayer.domain.model.Schedule

interface ScheduleRepository {

    suspend fun getSchedules(): List<Schedule>
}
