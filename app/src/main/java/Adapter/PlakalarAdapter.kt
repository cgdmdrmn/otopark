package Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.PlakalarOnClickListener
import com.example.otopark.R


class PlakalarAdapter(private val plakalarList: MutableList<String>,
                      private val listener: PlakalarOnClickListener
) :
    RecyclerView.Adapter<PlakalarAdapter.PlateViewHolder>() {

    override fun getItemCount(): Int {
        return plakalarList.size
    }

    override fun onBindViewHolder(holder:PlateViewHolder, position: Int) {
        holder.titleTextView.text=plakalarList[position]
        holder.removeTextView.paintFlags= Paint.UNDERLINE_TEXT_FLAG
        holder.removeTextView.setOnClickListener{
            listener.onClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PlateViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.plakalar_list_item, parent, false)
        return PlateViewHolder(view)
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)
        val removeTextView: TextView =itemView.findViewById(R.id.deleteTextView)
    }
}