package com.videoplayer.domain.usecase

import com.videoplayer.domain.extension.safeCall
import com.videoplayer.domain.model.Event
import com.videoplayer.domain.repository.EventRepository
import javax.inject.Inject

class GetEventUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {

    suspend operator fun invoke(): Result<List<Event>> = safeCall {
        eventRepository.getEvents()
    }
}
