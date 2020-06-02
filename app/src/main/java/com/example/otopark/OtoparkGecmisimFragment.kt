package com.example.otopark

import Adapter.OtoparkGecmisimAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_otopark_gecmisim.*

class OtoparkGecmisimFragment : Fragment() {
    private var otoparkGecmisimAdapter: OtoparkGecmisimAdapter? = null
    private val otoparkGecmisimList: List<String> =
        listOf("34 GA 1527", "34 CD 1527", "34 HK 2020")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        otoparkGecmisimAdapter = OtoparkGecmisimAdapter(otoparkGecmisimList)
        autoparkhistoryListRecyclerView.adapter = otoparkGecmisimAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Otopark Geçmişim",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otopark_gecmisim, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = OtoparkGecmisimFragment()
    }
}
