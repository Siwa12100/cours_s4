package fr.iut.tp2.data

data class Conversation(
    val id: Long,
    val name: String,
    val contacts: List<Contact>,
    var messages: List<Message>
)