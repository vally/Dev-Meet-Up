package epam.meetup.android.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import epam.meetup.android.adapter.EventAdapter
import epam.meetup.android.dev_meet_up.R
import epam.meetup.android.network.NetImpl


//TODO Could you look up this screen and list of events?
class MainActivity : AppCompatActivity() {


    private val eventList: RecyclerView by lazy { findViewById<RecyclerView>(R.id.event_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventList.layoutManager = LinearLayoutManager(this)
        eventList.adapter = EventAdapter(NetImpl(this).getEvents())
    }
}
