package com.videoplayer.presentation

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


private const val DEFAULT_DATE_PATTERN = "dd.MMMM.yyyy"
private const val HOURS_PATTERN = "HH:mm"

fun formatEventDate(dateString: String): String {
    val formatter = DateTimeFormatter.ISO_INSTANT
    val parsed = ZonedDateTime.parse(dateString, formatter.withZone(ZoneId.of("UTC")))
    val finalFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)
    println(parsed.toLocalDateTime())
    return when (parsed.toLocalDateTime().dayOfYear) {
        LocalDateTime.now().dayOfYear -> { "Today" }
        (LocalDateTime.now().minusDays(1)).dayOfYear -> { "Yesterday" }
        else -> { parsed.toLocalDateTime().format(finalFormatter) }
    }
}

fun formatScheduleDate(dateString: String): String {
    val formatter = DateTimeFormatter.ISO_INSTANT
    val parsed = ZonedDateTime.parse(dateString, formatter.withZone(ZoneId.of("UTC")))
    val finalFormatter = DateTimeFormatter.ofPattern(HOURS_PATTERN)
    println(parsed.toLocalDateTime())
    return when (parsed.toLocalDateTime().dayOfYear) {
        LocalDateTime.now().dayOfYear -> { "Today " + parsed.toLocalDateTime().format(finalFormatter) }
        (LocalDateTime.now().plusDays(1)).dayOfYear -> { "Tomorrow " + parsed.toLocalDateTime().format(finalFormatter) }
        else -> { parsed.toLocalDateTime().format(finalFormatter) }
    }
}
