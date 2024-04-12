package com.videoplayer.domain.model

data class Event(
    var id: String,
    var title: String,
    var subtitle: String,
    var date: String,
    var imageUrl: String,
    var videoUrl: String
)