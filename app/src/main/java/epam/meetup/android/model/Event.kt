package epam.meetup.android.model

data class Event(
        val id: String,
        val type: EventType,
        val name: String,
        val speakers: List<Speaker>,
        val date: String,
        val venue: String,
        val agenda: List<Agenda>,
        val description: String)