package com.example.otopark

import Adapter.OtoparkSonAramalarimAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_arama_ekrani.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AramaEkraniFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AramaEkraniFragment : Fragment() {
    private var otoparkSonAramalarimAdapter: OtoparkSonAramalarimAdapter? = null
    private val otoparkSonAramalarimList : List<String> =
        listOf("34 GA 1527", "34 CD 1527", "34 HK 2020")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        otoparkSonAramalarimAdapter= OtoparkSonAramalarimAdapter(otoparkSonAramalarimList)
        recentsearchautoparkListRecyclerView.adapter=otoparkSonAramalarimAdapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_arama_ekrani, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AramaEkraniFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AramaEkraniFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
