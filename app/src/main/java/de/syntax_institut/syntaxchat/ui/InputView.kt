package de.syntax_institut.syntaxchat.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputView(sendMessage: (String) -> Unit){

    var inputText by remember { mutableStateOf("") }

    Surface(
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = null,
                maxLines = 5,
                placeholder = { Text("Schreibe eine Nachricht an alle") },
                shape = RoundedCornerShape(CornerSize(24.dp)),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .weight(1f)
            )
            IconButton(
                onClick = {
                    sendMessage(inputText)
                    inputText = ""
                },
                Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(Icons.Filled.Send, "")
            }
        }
    }

}

@Preview
@Composable
fun InputViewPreview(){
    InputView {}
}