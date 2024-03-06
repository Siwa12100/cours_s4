package fr.iut.tp2.ext

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun Calendar.toReadableString(): String =
    SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(this.time)