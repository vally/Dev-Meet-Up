package epam.meetup.android.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import epam.meetup.android.model.Event
import epam.meetup.android.model.Speaker
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class NetFromJsonImpl(val context: Context) : NetApi {

    private val events: List<Event>

    init {
        val gson = Gson()
        val collectionType = object : TypeToken<Collection<Int>>() {}.type
        events = gson.fromJson(loadJSONFromAsset(), collectionType)
    }
    override fun getEvents(): List<Event> {
        return events
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

    //FIXME here is required better solution
    private fun loadJSONFromAsset(): String {
        val json: String
        try {
            val eventJson = context.assets.open("yourfilename.json")
            val size = eventJson.available()
            val buffer = ByteArray(size)
            eventJson.read(buffer)
            eventJson.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            error(e)
        }

        return json
    }
}