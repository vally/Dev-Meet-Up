package epam.meetup.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import epam.meetup.android.dev_meet_up.R
import epam.meetup.android.model.Event


//TODO Here maybe exist some bugs. Could you look up the adapter?
class EventAdapter(
        private val events: List<Event>,
        private val eventListener: EventsListener
) : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        var holder = EventHolder(LayoutInflater.from(parent.context).inflate(R.layout.event_row, parent, false))
        //holder.itemView.setOnClickListener(this)
        return holder
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        holder.bind(events[position])
        holder.itemView.setOnClickListener { eventListener.onEventSelected(events[position]) }
    }

//    override fun onClick(v: View?) {
//
//    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(events[position])
    }


    class EventHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.list_event_title)
        private val description: TextView = itemView.findViewById(R.id.list_event_description)
        private val date: TextView = itemView.findViewById(R.id.list_event_date)

        fun bind(event: Event) {
            description.text = event.description
            date.text = event.date
            title.text = event.name
        }
    }
}