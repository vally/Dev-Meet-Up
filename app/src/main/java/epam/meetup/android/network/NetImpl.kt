package epam.meetup.android.network

import android.content.Context
import epam.meetup.android.model.Event
import epam.meetup.android.utils.EventJson

class NetImpl(val context: Context) {

    fun getEvents() : List<Event> {
        val json = EventJson().getJsonFromAsset(context)
        return NetFromJsonImpl(json).getEvents()
    }

}