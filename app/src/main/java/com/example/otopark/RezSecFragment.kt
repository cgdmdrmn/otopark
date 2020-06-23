package com.example.otopark

import Adapter.OdemeAraclarimAdapter
import Adapter.RezSecAdapter
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otopark.*
import kotlinx.android.synthetic.main.fragment_odeme_araclarim.*
import kotlinx.android.synthetic.main.y_bottom_sheet.*

class RezSecFragment : Fragment(), RezSecOnClickListener {

    private var rezsecAdapter: RezSecAdapter? = null
    private val rezsecList: MutableList<String> =
        mutableListOf("4926 **** **** **11", "1527 **** **** **89", "2222 **** **** **15")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rezsecAdapter = RezSecAdapter(rezsecList, this)
        rezSecRecyclerView.adapter = rezsecAdapter
    }

    private fun removeItem(position: Int) {
        rezsecList.removeAt(position)
        rezsecAdapter?.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {

        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Uyarı")
        builder.setMessage("Silmek istediğinize emin misiniz?")
        builder.setCancelable(false)
        builder.setPositiveButton("Evet", { dialog: DialogInterface?, which: Int ->
            removeItem(position)
        })
        builder.setNegativeButton("Hayır", { dialog: DialogInterface?, which: Int -> })
        builder.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RezSecFragment()
    }
}
