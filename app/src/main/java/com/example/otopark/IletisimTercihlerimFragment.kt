package com.example.otopark

import DrawableMenuFragments.AnaEkranFragment
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_iletisim_tercihlerim.*

class IletisimTercihlerimFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "İletişim Tercihlerim",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iletisim_tercihlerim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        kaydetButton.setOnClickListener {
            (activity as BaseActivity).createAlertDialog(
                "Uyarı",
                "İletişim tercihleriniz kaydedildi.",
                "Tamam",
                DialogInterface.OnClickListener { _, _ ->
                    (activity as BaseActivity).changeFragment(
                        AnaEkranFragment(),
                        "ANA_EKRAN_FRAGMENT"
                    )
                },
                null,
                null
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            IletisimTercihlerimFragment()
    }
}
