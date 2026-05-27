package cz.sg.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import cz.sg.shared.model.MessageDto
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    MaterialTheme {
        var messages by remember { mutableStateOf(emptyList<MessageDto>()) }
        var headerText by remember { mutableStateOf("Backend Messages:") }
        val apiClient = remember { ApiClient() }
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .background(Color.White)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    scope.launch {
                        try {
                            messages = apiClient.getMessages()
                            headerText = "Messages:"
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }) {
                    Text("Load messages")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        messages = listOf(MessageDto(id = 1, messageText = "Hi Java Grupacek"))
                        headerText = "Greetings:"
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text("Say Hi", color = Color.Black)
                }
            }

            Text(
                text = headerText,
                style = MaterialTheme.typography.headlineMedium
            )

            LazyColumn {
                items(messages) { message ->
                    Column(modifier = Modifier.fillMaxWidth().safeContentPadding()) {
                        Text(text = "ID: ${message.id}")
                        Text(text = "Text: ${message.messageText}")
                    }
                }
            }
        }
    }
}