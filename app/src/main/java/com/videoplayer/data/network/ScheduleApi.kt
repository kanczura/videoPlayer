package com.videoplayer.data.network

import com.videoplayer.data.model.ScheduleResponse
import retrofit2.http.GET

interface ScheduleApi {

    @GET("/getSchedule")
    suspend fun getSchedule(): List<ScheduleResponse>
}
