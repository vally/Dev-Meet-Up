package epam.meetup.android.network

import android.content.Context
import epam.meetup.android.model.Event
import epam.meetup.android.model.Speaker
import epam.meetup.android.utils.EventJson

class NetImpl(val context: Context) {

    private val json = EventJson().getJsonFromAsset(context)
    private val netFromJsonImpl = NetFromJsonImpl(json)

    fun getEvents(): List<Event> {
        return netFromJsonImpl.getEvents()
    }

    fun getEvents(speaker: Speaker): List<Event> {
        return netFromJsonImpl.findEvents(speaker)
    }

    fun getEvents(title: String): List<Event> {
        return netFromJsonImpl.findEvents(title)
    }
}