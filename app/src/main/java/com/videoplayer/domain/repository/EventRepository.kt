package com.videoplayer.domain.repository

import com.videoplayer.domain.model.Event

interface EventRepository {

    suspend fun getEvents(): List<Event>
}
