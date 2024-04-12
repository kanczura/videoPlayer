package com.videoplayer.data.repository.di

import com.videoplayer.data.repository.EventRepositoryImpl
import com.videoplayer.data.repository.ScheduleRepositoryImpl
import com.videoplayer.domain.repository.EventRepository
import com.videoplayer.domain.repository.ScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsEventRepository(eventRepositoryImpl: EventRepositoryImpl): EventRepository

    @Binds
    abstract fun bindsScheduleRepository(scheduleRepositoryImpl: ScheduleRepositoryImpl): ScheduleRepository
}
