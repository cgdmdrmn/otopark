package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.R


class OtoparkSonAramalarimAdapter(private val otoparkSonAramalarimList: List<String>) :
    RecyclerView.Adapter<Adapter.OtoparkSonAramalarimAdapter.PlateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recent_search_auto_park_list_item, parent, false)
        return PlateViewHolder(view)
    }

    override fun getItemCount(): Int {
        return otoparkSonAramalarimList.size
    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.titleTextView.text = otoparkSonAramalarimList[position]
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)

    }
}