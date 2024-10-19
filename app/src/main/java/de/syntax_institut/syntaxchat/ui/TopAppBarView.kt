package de.syntax_institut.syntaxchat.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.syntaxchat.CHAT_ROOM_NAME
import de.syntax_institut.syntaxchat.ui.theme.chatBlue

@Composable
fun TopAppBarView() {
    Text(
        text = "🚀 $CHAT_ROOM_NAME",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun TopAppBarViewPreview() {
    TopAppBarView()
}