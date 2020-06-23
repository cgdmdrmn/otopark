package Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.HistoryRezervationOnClickListener
import com.example.otopark.R
import com.example.otopark.YeniRezervasyonlarOnClickListener


class YYeniRezervasyonlarAdapter(
    private val yenirezervasyonlarList: MutableList<String>,
    private val listener: YeniRezervasyonlarOnClickListener
) : RecyclerView.Adapter<YYeniRezervasyonlarAdapter.PlateViewHolder>() {

    override fun getItemCount(): Int {
        return yenirezervasyonlarList.size
    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.titleTextView.text = yenirezervasyonlarList[position]
        holder.removeButton.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.removeButton.setOnClickListener { listener.onClick(position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.y_yeni_rezervation_list_item, parent, false)
        return PlateViewHolder(view)
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)
        val removeButton: TextView = itemView.findViewById(R.id.deleteTextView)

    }
}