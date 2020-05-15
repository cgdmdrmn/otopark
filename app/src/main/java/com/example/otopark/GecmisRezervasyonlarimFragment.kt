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
class GecmisRezervasyonlarimFragment : Fragment() {
    private var gecmisRezervasyonlarimAdapter: GecmisRezervasyonlarimAdapter? = null
    private val gecmisrezervasyonlarimlist : List<String> =
        listOf("Beşiktaş Kapalı O. 34 GA 1527 12.04.2020 14:00 12.04.2020 16:00", "Ulus O. 34 CD 1993 15.04.2020 15:30 18.04.2020 15:30")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gecmisRezervasyonlarimAdapter= GecmisRezervasyonlarimAdapter(gecmisrezervasyonlarimlist)
        historyRezervationListRecyclerView.adapter=gecmisRezervasyonlarimAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            (activity as BaseActivity).changeToolbarIconAndTitle("Rezervasyonlarım", R.drawable.toolbar_back_icon)
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GecmisRezervasyonlarimFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GecmisRezervasyonlarimFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
