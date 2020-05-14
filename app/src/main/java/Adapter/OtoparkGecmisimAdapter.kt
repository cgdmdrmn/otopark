package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.R


class OtoparkGecmisimAdapter(private val otoparkGecmisimList: List<String>) : RecyclerView.Adapter<Adapter.OtoparkGecmisimAdapter.PlateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.history_auto_park_list_item, parent, false)
        return PlateViewHolder(view)
    }
    override fun getItemCount(): Int {
        return otoparkGecmisimList.size
    }

    override fun onBindViewHolder(holder:PlateViewHolder, position: Int) {
        holder.titleTextView.text=otoparkGecmisimList[position]
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)

    }
}