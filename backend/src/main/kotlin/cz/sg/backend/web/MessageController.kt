package cz.sg.backend.web

import cz.sg.shared.model.MessageDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/1/messages")
class MessageController {

    @GetMapping("/list")
    fun getMessages(): List<MessageDto> =
        List(10) {
            MessageDto(
                id = it + 1,
                messageText = UUID.randomUUID().toString()
            )
        }
}