package Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.otopark.CardsOnClickListener
import com.example.otopark.R


class OdemeAraclarimAdapter(
    private val odemeAraclarimList: List<String>,
    private val listener: CardsOnClickListener
) : RecyclerView.Adapter<Adapter.OdemeAraclarimAdapter.PlateViewHolder>() {

    override fun getItemCount(): Int {
        return odemeAraclarimList.size
    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        holder.editText.text = odemeAraclarimList[position]
        holder.titleTextView.text = odemeAraclarimList[position]
        holder.removeButton.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        holder.removeButton.setOnClickListener { listener.onClick(position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cards_list_item, parent, false)
        return PlateViewHolder(view)
    }

    class PlateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.textContent)
        val removeButton: TextView = itemView.findViewById(R.id.deleteTextView)
        val editText: TextView = itemView.findViewById(R.id.editTextView)

    }
}