package fr.iut.tp2.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


import fr.iut.tp2.data.Contact
import fr.iut.tp2.data.Conversation

//@Preview
//@Composable
//fun HelloWorld() {
//    Text("Adiu !")
//}


@Composable
fun HomeScreen(
    conversations: List<Conversation>,
    contacts: List<Contact>,
    goToConversation: (Conversation) -> Unit
) {

    //HelloWorld()

    Column {
        Row {
            for (contact in contacts) {
                Text(contact.name);
            }


        }


    }
}