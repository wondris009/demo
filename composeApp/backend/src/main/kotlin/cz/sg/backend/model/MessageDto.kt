package cz.sg.backend.model

import cz.sg.backend.extension.format
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class MessageDto @OptIn(ExperimentalTime::class) constructor(
    val id: Int,
    val created: Instant = Clock.System.now(),
    val createdFormatted: String = created.format("dd.MM.yyyy HH:mm:ss:SSS"),
    val messageText: String,
) {
//    @OptIn(ExperimentalTime::class)
//    fun getCreatedFormatted(pattern: String = "dd.MM.yyyy HH:mm:ss:SSS"): String =
//        created.format(pattern)
}
