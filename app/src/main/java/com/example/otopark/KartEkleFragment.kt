package com.example.otopark

import DrawableMenuFragments.OdemeAraclarimFragment
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_kart_ekle.*

class KartEkleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Kart Ekle",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kart_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonKartEkle.setOnClickListener {

            val kartno = kartnoEditText.text
            val ay = ayEditText.text
            val yil = yilEditText.text
            val ccv = editText3.text

            if (kartno.isNotEmpty() && ay.isNotEmpty() && yil.isNotEmpty() && ccv.isNotEmpty() && checkBox.isChecked) {
                Toast.makeText(
                    this.requireContext(),
                    "Kartınız eklendi.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this.requireContext(),
                    "Lütfen boş alanları doldurun.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = KartEkleFragment()
    }
}
