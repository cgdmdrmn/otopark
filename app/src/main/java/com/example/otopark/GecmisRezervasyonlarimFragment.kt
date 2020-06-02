package com.example.otopark

import Adapter.GecmisRezervasyonlarimAdapter
import Adapter.OdemeAraclarimAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gecmis_rezervasyonlarim.*
import kotlinx.android.synthetic.main.fragment_odeme_araclarim.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GecmisRezervasyonlarimFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GecmisRezervasyonlarimFragment : Fragment(), HistoryRezervationOnClickListener {
    private lateinit var gecmisRezervasyonlarimAdapter: GecmisRezervasyonlarimAdapter
    private val gecmisrezervasyonlarimlist : MutableList<String> =
        mutableListOf("Beşiktaş Kapalı O. 34 GA 1527 12.04.2020 14:00 12.04.2020 16:00", "Ulus O. 34 CD 1993 15.04.2020 15:30 18.04.2020 15:30")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gecmisRezervasyonlarimAdapter= GecmisRezervasyonlarimAdapter(gecmisrezervasyonlarimlist, this)
        historyRezervationListRecyclerView.adapter=gecmisRezervasyonlarimAdapter
    }

    private fun removeItem(position: Int){
        gecmisrezervasyonlarimlist.removeAt(position)
        gecmisRezervasyonlarimAdapter.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {
        removeItem(position)
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
