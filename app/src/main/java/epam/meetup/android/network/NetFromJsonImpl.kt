package epam.meetup.android.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import epam.meetup.android.model.Event
import epam.meetup.android.model.Speaker
import java.util.Date

//TODO how we can look up this class?
class NetFromJsonImpl(private val json: String) : NetApi {

    override fun getEvents(): List<Event> {
        return getDataFromJson(json)
    }

    override fun findEvents(title: String): List<Event> {
        val list = getDataFromJson(json)
        val result  = ArrayList<Event>()
        for (event: Event in list) {
            if (event.name.contains(title, false)) {
                result.add(event)
            }
        }
        return result
    }

    override fun findEvents(from: Date, to: Date): List<Event> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findEvents(speaker: Speaker): List<Event> {
        val list = getDataFromJson(json)
        val result  = ArrayList<Event>()
        for (event: Event in list) {
            if (event.speakers.contains(speaker)) {
                result.add(event)
            }
        }
        return result
    }

    private fun getDataFromJson(json: String): List<Event> {
        val collectionType = object : TypeToken<List<Event>>() {}.type
        return Gson().fromJson(json, collectionType)
    }
}