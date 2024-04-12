package com.videoplayer.data.network

import com.videoplayer.data.model.EventResponse
import retrofit2.http.GET

interface EventApi {

    @GET("/getEvents")
    suspend fun getEvents(): List<EventResponse>
}
