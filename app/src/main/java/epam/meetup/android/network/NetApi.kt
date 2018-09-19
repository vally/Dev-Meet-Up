package epam.meetup.android.network

import epam.meetup.android.model.Event
import epam.meetup.android.model.Speaker
import java.util.*

interface NetApi {
    fun getEvents(): List<Event>

    fun findEvents(title: String): List<Event>

    fun findEvents(from: Date, to: Date): List<Event>

    fun findEvents(speaker: Speaker): List<Event>
}