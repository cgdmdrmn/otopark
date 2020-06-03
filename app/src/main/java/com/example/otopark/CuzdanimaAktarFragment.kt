package com.example.otopark

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_cuzdanima_aktar.*
import kotlinx.android.synthetic.main.fragment_cuzdanima_aktar.kartsecSpinner

class CuzdanimaAktarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Cüzdanıma Aktar",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuzdanima_aktar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val odemearaclar =
            arrayOf("4926 **** **** **11", "1527 **** **** **89", "2222 **** **** **15")
        val arrayAdapter =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, odemearaclar)
        kartsecSpinner.adapter = arrayAdapter
        kartsecSpinner.onItemSelectedListener = object :
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

        kartekleTextView.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                KartEkleFragment(), "KART_EKLE_FRAGMENT"
            )
        }

        cuzdanimaaktarButton.setOnClickListener {

            val tutar = tutargirEditText.text
            if (tutar.isNotEmpty() && kullanimkosullaricheckBox.isChecked) {
                Toast.makeText(
                    this.requireContext(),
                    "Tutar cüzdanınıza aktarıldı.",
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
        fun newInstance() = CuzdanimaAktarFragment()
    }
}
