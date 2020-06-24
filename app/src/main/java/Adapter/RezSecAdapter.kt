package Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.R
import com.example.otopark.RezSecOnClickListener


class RezSecAdapter(private val rezseclist: MutableList<String>,
                    private val listener: RezSecOnClickListener
) :
    RecyclerView.Adapter<RezSecAdapter.PlateViewHolder>() {

    override fun getItemCount(): Int {
        return rezseclist.size
    }

    override fun onBindViewHolder(holder:PlateViewHolder, position: Int) {
        holder.titleTextView.text=rezseclist[position]
        holder.sectextView.paintFlags= Paint.UNDERLINE_TEXT_FLAG
        holder.sectextView.setOnClickListener{
            listener.onClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.y_rez_sec_list_item, parent, false)
        return PlateViewHolder(view)
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)
        val sectextView: TextView =itemView.findViewById(R.id.deleteTextView)
    }
}