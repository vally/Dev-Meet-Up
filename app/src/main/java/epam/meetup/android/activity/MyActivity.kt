package epam.meetup.android.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import epam.meetup.android.adapter.EventAdapter
import epam.meetup.android.dev_meet_up.R
import epam.meetup.android.network.NetImpl
import epam.meetup.android.adapter.EventsListener
import epam.meetup.android.model.Event
import java.util.*


class MyActivity : AppCompatActivity() {


    private val eventList: RecyclerView by lazy { findViewById<RecyclerView>(R.id.event_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventList.layoutManager = LinearLayoutManager(this)

        val listener: EventsListener = SecEventsListener()
        eventList.adapter = EventAdapter(
                NetImpl(this).getEvents(),
                listener
        )
    }


    private class SecEventsListener : EventsListener {
        override fun onEventSelected(event: Event) {
            System.exit(0)
            Log.d("TAG", "GoodBye")
        }

    }


}
