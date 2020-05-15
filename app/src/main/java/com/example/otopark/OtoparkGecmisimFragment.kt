package com.example.otopark

import Adapter.OtoparkGecmisimAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_otopark_gecmisim.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OtoparkGecmisimFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OtoparkGecmisimFragment : Fragment() {
    private var otoparkGecmisimAdapter: OtoparkGecmisimAdapter? = null
    private val otoparkGecmisimList : List<String> =
        listOf("34 GA 1527", "34 CD 1527", "34 HK 2020")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        otoparkGecmisimAdapter= OtoparkGecmisimAdapter(otoparkGecmisimList)
        autoparkhistoryListRecyclerView.adapter=otoparkGecmisimAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle("Otopark Geçmişim", R.drawable.toolbar_back_icon)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_otopark_gecmisim, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OtoparkGecmisimFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OtoparkGecmisimFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
