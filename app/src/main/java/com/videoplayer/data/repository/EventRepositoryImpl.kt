package com.videoplayer.data.repository

import com.videoplayer.data.network.EventApi
import com.videoplayer.data.model.toDomain
import com.videoplayer.domain.model.Event
import com.videoplayer.domain.repository.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val eventApi: EventApi
) : EventRepository {

    override suspend fun getEvents(): List<Event> {
        return eventApi.getEvents().map {
            it.toDomain()
        }
    }
}
