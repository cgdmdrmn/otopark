package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.R


class OdemeAraclarimAdapter(private val OdemeAraclarimList: List<String>) : RecyclerView.Adapter<Adapter.OdemeAraclarimAdapter.PlateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.odemearaclarimlist, parent, false)
        return PlateViewHolder(view)
    }
    override fun getItemCount(): Int {
        return OdemeAraclarimList.size
    }

    override fun onBindViewHolder(holder:PlateViewHolder, position: Int) {
        holder.titleTextView.text=OdemeAraclarimList[position]
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)

    }
}