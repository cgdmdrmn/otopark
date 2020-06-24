package com.example.otopark

import Adapter.RezSecAdapter
import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_rez_sec.*
import kotlinx.android.synthetic.main.fragment_rezervasyon_ekle.*
import kotlinx.android.synthetic.main.fragment_y_anasayfa.*


class RezSecFragment : Fragment(), RezSecOnClickListener {
    private var rezsecAdapter: RezSecAdapter? = null
    private val rezsecList: MutableList<String> =
        mutableListOf("29.6.20/16:30-17:30 34 GA 1527", "30.6.20/18:30-21:00 34 CD 1993")

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
        removeItem(position)
        (activity as BaseActivity).changeFragment(YanasayfaFragment(),"Anasayfa")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rez_sec, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RezSecFragment()
    }
}
