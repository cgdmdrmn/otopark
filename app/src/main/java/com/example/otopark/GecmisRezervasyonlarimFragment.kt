package com.example.otopark

import Adapter.GecmisRezervasyonlarimAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gecmis_rezervasyonlarim.*

class GecmisRezervasyonlarimFragment : Fragment() {
    private var gecmisRezervasyonlarimAdapter: GecmisRezervasyonlarimAdapter? = null
    private val gecmisrezervasyonlarimlist: List<String> =
        listOf(
            "Beşiktaş Kapalı O. 34 GA 1527 12.04.2020 14:00 12.04.2020 16:00",
            "Ulus O. 34 CD 1993 15.04.2020 15:30 18.04.2020 15:30"
        )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gecmisRezervasyonlarimAdapter = GecmisRezervasyonlarimAdapter(gecmisrezervasyonlarimlist)
        historyRezervationListRecyclerView.adapter = gecmisRezervasyonlarimAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            (activity as BaseActivity).changeToolbarIconAndTitle(
                "Rezervasyonlarım",
                R.drawable.toolbar_hamburger_icon
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gecmis_rezervasyonlarim, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GecmisRezervasyonlarimFragment()
    }
}
