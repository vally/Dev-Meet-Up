package epam.meetup.android.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import epam.meetup.android.model.Event
import epam.meetup.android.model.Speaker
import java.util.Date

class NetFromJsonImpl(private val json: String) : NetApi {

    override fun getEvents(): List<Event> {
        return getDataFromJson(json)
    }

    override fun findEvents(title: String): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findEvents(from: Date, to: Date): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findEvents(speaker: Speaker): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getDataFromJson(json: String): List<Event> {
        val collectionType = object : TypeToken<List<Event>>() {}.type
        return Gson().fromJson(json, collectionType)
    }
}