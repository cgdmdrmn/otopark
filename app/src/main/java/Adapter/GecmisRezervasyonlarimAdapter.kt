package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.R


class GecmisRezervasyonlarimAdapter(private val gecmisRezervasyonlarimList: List<String>) : RecyclerView.Adapter<Adapter.GecmisRezervasyonlarimAdapter.PlateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.history_rezervation_list_item, parent, false)
        return PlateViewHolder(view)
    }
    override fun getItemCount(): Int {
        return gecmisRezervasyonlarimList.size
    }

    override fun onBindViewHolder(holder:PlateViewHolder, position: Int) {
        holder.titleTextView.text=gecmisRezervasyonlarimList[position]
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)

    }
}