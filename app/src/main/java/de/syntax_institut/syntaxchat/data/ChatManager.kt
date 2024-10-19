package de.syntax_institut.syntaxchat.data

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import de.syntax_institut.syntaxchat.CHAT_ROOM_NAME
import de.syntax_institut.syntaxchat.USER_NAME
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/*

ACHTUNG: HIER NICHTS VERÄNDERN!!!

*/

private const val TAG = "Firebase ViewModel"
private const val PLEASE_ASSIGN_CHAT_ROOM_NAME =
    "Bitte gib den Namen eures Chatraums an. " + "\n\n" +
            "Öffne Dafür die Datei \"Configuration\" und speichere dort den Namen eures Chat Rooms und deinen Nutzernamen. " + "\n\n" +
            "Beispiel:" + "\n" +
            "const val CHAT_ROOM_NAME = \"Chatraum\"" + "\n" +
            "const val USER_NAME = \"Beate Beispiel\""

class ChatManager : ViewModel() {

    private val db = Firebase.firestore

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    init {
        if (CHAT_ROOM_NAME.isNotEmpty()) {
            db.collection(CHAT_ROOM_NAME)
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        Log.w(TAG, "Listen failed.", e)
                        return@addSnapshotListener
                    }

                    snapshot?.let { querySnapshot ->
                        val newMessages = querySnapshot.documents.mapNotNull { doc ->
                            doc.toObject(Message::class.java)
                        }
                        _messages.value = newMessages
                    }
                }
        } else {
            _messages.value = listOf(
                Message(
                    text = PLEASE_ASSIGN_CHAT_ROOM_NAME,
                    userName = "System"
                )
            )
        }
    }

    fun sendMessage(text: String) {
        if (CHAT_ROOM_NAME.isEmpty()) return
        val message = Message(
            text = text,
            userName = USER_NAME,
            timestamp = Timestamp.now()
        )
        db.collection(CHAT_ROOM_NAME).add(message)
            .addOnSuccessListener {
                Log.d(TAG, "Message sent successfully")
            }
            .addOnFailureListener { e ->
                Log.e(TAG, "Failed to send message", e)
            }
    }
}