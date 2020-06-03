package Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.R
import com.example.otopark.YakinimdakiOtoparklarOnClickListener
import java.util.*
import kotlin.collections.ArrayList


class YakinimdakiOtoparklarAdapter(
    private var yakinimdakiOtoparklarList: MutableList<String>,
    private val listener: YakinimdakiOtoparklarOnClickListener
) :
    RecyclerView.Adapter<YakinimdakiOtoparklarAdapter.PlateViewHolder>() {

    override fun getItemCount(): Int {
        return yakinimdakiOtoparklarList.size

    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.titleTextView.text = yakinimdakiOtoparklarList[position]
        holder.titleTextView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.titleTextView.setOnClickListener {
            listener.onClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.closest_auto_park_list_item, parent, false)
        return PlateViewHolder(view)
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)

    }
}