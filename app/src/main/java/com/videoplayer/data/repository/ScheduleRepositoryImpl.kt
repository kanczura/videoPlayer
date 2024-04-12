package com.videoplayer.data.repository

import com.videoplayer.data.network.ScheduleApi
import com.videoplayer.data.model.toDomain
import com.videoplayer.domain.model.Schedule
import com.videoplayer.domain.repository.ScheduleRepository
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val scheduleApi: ScheduleApi
) : ScheduleRepository {

    override suspend fun getSchedules(): List<Schedule> {
        return scheduleApi.getSchedule().map {
            it.toDomain()
        }
    }
}
