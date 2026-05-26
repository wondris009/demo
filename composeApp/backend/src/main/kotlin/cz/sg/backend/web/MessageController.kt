package cz.sg.backend.web

import cz.sg.backend.model.MessageDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.time.ExperimentalTime

@RestController
@RequestMapping("/api/1/messages")
class MessageController {

    @OptIn(ExperimentalTime::class)
    @GetMapping("/list")
    fun getMessages(): List<MessageDto> =
        List(10) {
            MessageDto(
                id = it + 1,
                messageText = UUID.randomUUID().toString()
            )
        }
}