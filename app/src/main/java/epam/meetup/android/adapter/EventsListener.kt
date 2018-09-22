package epam.meetup.android.adapter

import epam.meetup.android.model.Event

interface EventsListener {
    fun onEventSelected(event: Event)
}