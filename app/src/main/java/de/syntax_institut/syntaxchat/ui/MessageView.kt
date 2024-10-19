package de.syntax_institut.syntaxchat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.syntaxchat.USER_NAME
import de.syntax_institut.syntaxchat.ui.theme.chatBlue

@Composable
fun MessageView(userName: String, text: String, time: String) {

    Row {
        if (userName == USER_NAME){
            Spacer(modifier = Modifier.weight(1f))
        }
        Surface(
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = userName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = chatBlue
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = time,
                        fontSize = 12.sp
                    )
                }
                Text(text = text)
            }
        }
    }
}

@Preview
@Composable
fun MessageViewPreview() {
    MessageView(
        userName = "MaxMustermann",
        text = "Hallo wie geht es dir heute? 😊",
        time = "10:00"
    )
}