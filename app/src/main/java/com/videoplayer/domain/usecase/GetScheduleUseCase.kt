package com.videoplayer.domain.usecase

import com.videoplayer.domain.extension.safeCall
import com.videoplayer.domain.model.Schedule
import com.videoplayer.domain.repository.ScheduleRepository
import javax.inject.Inject

class GetScheduleUseCase @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
) {

    suspend operator fun invoke(): Result<List<Schedule>> = safeCall {
        scheduleRepository.getSchedules()
    }
}
