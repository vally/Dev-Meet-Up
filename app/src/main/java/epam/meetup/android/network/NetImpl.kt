package epam.meetup.android.network

import android.content.Context
import epam.meetup.android.model.Event

class NetImpl(context: Context) {

    private val netApi: NetApi

    init {
        netApi = NetFromJsonImpl(context)
    }

    val events: List<Event> = netApi.getEvents()
}