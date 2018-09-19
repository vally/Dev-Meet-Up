package epam.meetup.android.model

import java.util.*

data class Event(val id: String, val type: EventType, val title: String, val speakers: List<Speaker>, val date: Date, val venue: String, val agenda: List<Agenda>, val description: String)