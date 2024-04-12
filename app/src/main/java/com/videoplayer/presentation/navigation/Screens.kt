package com.videoplayer.presentation.navigation

const val PLAYER_SCREEN_ROUTE = "PLAYER_ROUTE"
const val VIDEO_URL_ARG = "videoUrl"

sealed class Screens(val route: String) {
    data object EventsScreen : Screens("EVENTS_LIST_ROUTE")
    data object SchedulesScreen : Screens("SCHEDULES_LIST_ROUTE")
    data object PlayerScreen : Screens("PLAYER_ROUTE/{videoUrl}")
}
