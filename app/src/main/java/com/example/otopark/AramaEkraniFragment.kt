package com.example.otopark

import Adapter.OtoparkSonAramalarimAdapter
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_arama_ekrani.*

class AramaEkraniFragment : Fragment() {
    private var otoparkSonAramalarimAdapter: OtoparkSonAramalarimAdapter? = null
    private val otoparkSonAramalarimList: List<String> =
        listOf("34 GA 1527", "34 CD 1527", "34 HK 2020")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Ara",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_arama_ekrani, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        otoparkSonAramalarimAdapter = OtoparkSonAramalarimAdapter(otoparkSonAramalarimList)
        recentsearchautoparkListRecyclerView.adapter = otoparkSonAramalarimAdapter

        temizleTextView.setOnClickListener {
            (activity as BaseActivity).createAlertDialog(
                "Uyarı",
                "Arama geçmişi temizlendi.",
                "Tamam",
                DialogInterface.OnClickListener { _, _ ->
                    (activity as BaseActivity).changeFragment(
                        AramaEkraniFragment(),
                        "ARAMA_EKRANI_FRAGMENT"
                    )
                },
                null,
                null
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AramaEkraniFragment()
    }
}
