package epam.meetup.android.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import epam.meetup.android.model.Event
import java.io.IOException
import java.nio.charset.Charset

class EventJson {



    //FIXME here is required better solution
    fun getJsonFromAsset(context: Context): String {
        val json: String
        try {
            val eventJson = context.assets.open("fake_events.json")
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