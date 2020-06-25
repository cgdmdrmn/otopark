package Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.R
import com.example.otopark.YakinimdakiOtoparklarOnClickListener
import kotlinx.android.synthetic.main.closest_auto_park_list_item.view.*
import java.util.*
import kotlin.collections.ArrayList


class YakinimdakiOtoparklarAdapter(
    private var yakinimdakiOtoparklarList: ArrayList<String>,
    private val listener: YakinimdakiOtoparklarOnClickListener
) :
    RecyclerView.Adapter<YakinimdakiOtoparklarAdapter.PlateViewHolder>(), Filterable {

    var otoparkFilterList = ArrayList<String>()

    init {
        otoparkFilterList = yakinimdakiOtoparklarList
    }

    override fun getItemCount(): Int {
        return otoparkFilterList.size

    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.itemView.textContent.text = otoparkFilterList[position]
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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    otoparkFilterList = yakinimdakiOtoparklarList
                } else {
                    val resultList = ArrayList<String>()
                    for (row in yakinimdakiOtoparklarList) {
                        if (row.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    otoparkFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = otoparkFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                otoparkFilterList = results?.values as ArrayList<String>
                notifyDataSetChanged()
            }

        }
    }
}