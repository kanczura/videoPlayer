package com.videoplayer.presentation.eventslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.videoplayer.domain.usecase.GetEventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventsUseCase: GetEventUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<EventViewState>(EventViewState(isLoading = true))
    val uiState = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<Event>()
    val event = _event.asSharedFlow()

    var job: Job? = null

    init {
        startUpdates()
    }

    private fun startUpdates() {
        stopUpdates()
        job = viewModelScope.launch {
            while (true) {
                getEvents()
                delay(30000)
            }
        }
    }

    private fun stopUpdates() {
        job?.cancel()
        job = null
    }

    private suspend fun getEvents() {
            eventsUseCase().fold(
                onSuccess = { events ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            data = events
                        )
                    }
                },
                onFailure = { error ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = error.message,
                        )
                    }
                }
            )
    }

    fun onEventClicked(event: com.videoplayer.domain.model.Event) {
        viewModelScope.launch {
            _event.emit(Event.NavigateToVideo(event.videoUrl))
        }
    }
}
