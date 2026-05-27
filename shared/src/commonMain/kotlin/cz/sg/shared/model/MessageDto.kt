package cz.sg.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class MessageDto(
    val id: Int,
    val messageText: String,
)