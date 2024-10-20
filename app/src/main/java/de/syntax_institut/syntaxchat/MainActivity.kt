package de.syntax_institut.syntaxchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.syntax_institut.syntaxchat.data.ChatManager
import de.syntax_institut.syntaxchat.ui.BackgroundView
import de.syntax_institut.syntaxchat.ui.InputView
import de.syntax_institut.syntaxchat.ui.MessageView
import de.syntax_institut.syntaxchat.ui.TopAppBarView
import de.syntax_institut.syntaxchat.ui.theme.SyntaxChatTheme

class MainActivity : ComponentActivity() {

    private val chatManager by viewModels<ChatManager>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val messages by chatManager.messages.collectAsState()
            SyntaxChatTheme {
                Box {
                    // Der Hintergrund
                    BackgroundView()

                    Column{
                        // Die Titel-Leiste
                        TopAppBarView()

                        // Der Chat
                        LazyColumn(
                            reverseLayout = true,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp)
                        ) {
                            items(messages) { message ->
                                Column {
                                    MessageView(message.userName, message.text, message.time)
                                    Spacer(modifier = Modifier.height(12.dp))
                                }
                            }
                        }

                        // Die Eingabe
                        InputView { message ->
                            chatManager.sendMessage(message)
                        }
                    }
                }
            }
        }
    }
}

