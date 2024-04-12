package com.videoplayer.presentation.eventslist

sealed class Action {

    data class NavigateToVideo(val videoUrl: String) : Action()

}
