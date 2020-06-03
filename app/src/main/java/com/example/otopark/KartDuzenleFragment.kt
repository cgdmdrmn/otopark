package com.example.otopark

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_kart_duzenle.*
import kotlinx.android.synthetic.main.fragment_kart_duzenle.ayEditText
import kotlinx.android.synthetic.main.fragment_kart_duzenle.checkBox
import kotlinx.android.synthetic.main.fragment_kart_duzenle.editText3
import kotlinx.android.synthetic.main.fragment_kart_duzenle.kartnoEditText
import kotlinx.android.synthetic.main.fragment_kart_duzenle.yilEditText


class KartDuzenleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Kart Düzenle",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kart_duzenle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        kaydetButton.setOnClickListener {

            val kartno = kartnoEditText.text
            val ay = ayEditText.text
            val yil = yilEditText.text
            val ccv = editText3.text

            if (kartno.isNotEmpty() && ay.isNotEmpty() && yil.isNotEmpty() && ccv.isNotEmpty() && checkBox.isChecked) {
                Toast.makeText(
                    this.requireContext(),
                    "Değişiklikleriniz kaydedildi.",
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
        fun newInstance(param1: String, param2: String) = KartDuzenleFragment()
    }
}
