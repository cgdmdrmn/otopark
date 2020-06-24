package com.example.otopark

import Adapter.PlakalarAdapter
import Adapter.YGecmisRezervasyonlarAdapter
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_plakalar.*
import kotlinx.android.synthetic.main.fragment_y_gecmis_rezervasyonlar.*

class YGecmisRezervasyonlarFragment : Fragment(), GecmisRezervasyonlarOnClickListener {

    private lateinit var gecmisrezervasyonlarAdapter: YGecmisRezervasyonlarAdapter
    private val gecmisrezervasyonlarlist: MutableList<String> =
        mutableListOf("16.6.20/16:30-17:30 34 GA 1527", "19.6.20/18:30-21:00 34 CD 1993")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gecmisrezervasyonlarAdapter = YGecmisRezervasyonlarAdapter(gecmisrezervasyonlarlist, this)
        gecmisRezervationListRecyclerView.adapter = gecmisrezervasyonlarAdapter
    }

    private fun removeItem(position: Int) {
        gecmisrezervasyonlarlist.removeAt(position)
        gecmisrezervasyonlarAdapter.notifyDataSetChanged()
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_y_gecmis_rezervasyonlar, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarTitle("Geçmiş Rezervasyonlar")
    }

    companion object {
        @JvmStatic
        fun newInstance() = YGecmisRezervasyonlarFragment()
    }
}
