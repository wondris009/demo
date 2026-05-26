package cz.sg.backend.extension

import kotlinx.datetime.TimeZone
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
fun Instant.format(pattern: String, timeZone: TimeZone = TimeZone.currentSystemDefault()): String {
    val dateTime = toLocalDateTime(timeZone)

    return pattern
        .replace("yyyy", dateTime.year.toString().padStart(4, '0'))
        .replace("MM", dateTime.month.number.toString().padStart(2, '0'))
        .replace("dd", dateTime.day.toString().padStart(2, '0'))
        .replace("HH", dateTime.hour.toString().padStart(2, '0'))
        .replace("mm", dateTime.minute.toString().padStart(2, '0'))
        .replace("ss", dateTime.second.toString().padStart(2, '0'))
        .replace("SSS", (dateTime.nanosecond / 1_000_000).toString().padStart(3, '0'))
}