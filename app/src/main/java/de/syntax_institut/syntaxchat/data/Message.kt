package de.syntax_institut.syntaxchat.data

import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

data class Message(
    var text: String = "",
    var userName: String = "",
    var timestamp: Timestamp = Timestamp.now()
) {
    val time: String
        get() {
            val date = timestamp.toDate()
            val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
            return formatter.format(date)
        }
}
