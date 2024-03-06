package fr.iut.tp2.data

import java.util.Calendar

data class Message(
    val text: String,
    val date: Calendar,
    val sender: Contact?,
    val isReaded: Boolean
)