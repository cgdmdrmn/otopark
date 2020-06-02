package com.example.otopark

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_plaka_ekle.*
import kotlinx.android.synthetic.main.fragment_plaka_ekle.checkBox

class PlakaEkleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Plaka Ekle",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plaka_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val aracsinifi = arrayOf("1.", "2.", "3.", "4.", "5.", "6.")
        val arrayAdapter =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, aracsinifi)
        aracsinifiSpinner.adapter = arrayAdapter

        aracsinifiSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
            }
        }


        buttonPlakaEkle.setOnClickListener {

            val plaka = plakagirEditText.text
            if (plaka.isNotEmpty() && checkBox.isChecked) {
                (activity as BaseActivity).createAlertDialog(
                    "Uyarı",
                    "Kart ekleme işleminiz gerçekleşti.",
                    "Tamam",
                    DialogInterface.OnClickListener { _, _ ->
                        (activity as BaseActivity).changeFragment(
                            PlakaEkleFragment(),
                            "PLAKALA_EKLE_FRAGMENT"
                        )
                    },
                    null,
                    null
                )
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
        fun newInstance() = PlakaEkleFragment()
    }
}
