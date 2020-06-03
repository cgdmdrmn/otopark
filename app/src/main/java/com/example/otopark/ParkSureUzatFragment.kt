package com.example.otopark

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_park_sure_uzat.*
import kotlinx.android.synthetic.main.fragment_rezervasyon_ekle.dateBitBtn
import kotlinx.android.synthetic.main.fragment_rezervasyon_ekle.tarihbitEditText
import kotlinx.android.synthetic.main.fragment_rezervasyon_ekle.yeniKartEkleTextView
import kotlinx.android.synthetic.main.fragment_rezervasyonlar.*
import java.util.*

class ParkSureUzatFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Park Süremi Uzat",
            R.drawable.toolbar_hamburger_icon
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_park_sure_uzat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        dateBitBtn.setOnClickListener {
            val dpd = DatePickerDialog(
                this.requireContext(),
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    tarihbitEditText.setText("" + mDay + "/" + mMonth + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
        }

        val rezervasyonlar = arrayOf(
            "Beşiktaş Kapalı Otoparkı 34 GA 1527 12.04.2020 14:00-16:00",
            "Ulus Otoparkı 15.04.2020 15:00-16:00"
        )
        val arrayAdapter = ArrayAdapter(
            this.requireContext(),
            android.R.layout.simple_spinner_item,
            rezervasyonlar
        )
        rezSecSpinner.adapter = arrayAdapter
        rezSecSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                rezbittarihTextView.text = rezervasyonlar[position]
            }
        }

        val odemearaclar =
            arrayOf("4926 **** **** **11", "1527 **** **** **89", "2222 **** **** **15")
        val arrayAdapter1 =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, odemearaclar)
        kartsecSpinner.adapter = arrayAdapter1
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

        val rezbitsaat = arrayOf(
            "00:00",
            "01:00",
            "02:00",
            "03:00",
            "04:00",
            "05:00",
            "06:00",
            "07:00",
            "08:00",
            "09:00",
            "10:00",
            "11:00",
            "12:00",
            "13:00",
            "14:00",
            "15:00",
            "16:00",
            "17:00",
            "18:00",
            "19:00",
            "20:00",
            "21:00",
            "22:00",
            "23:00"
        )
        val arrayAdapter2 =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, rezbitsaat)
        saatsecSpinner.adapter = arrayAdapter2
        saatsecSpinner.onItemSelectedListener = object :
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

        yeniKartEkleTextView.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                KartEkleFragment(), "KART_EKLE_FRAGMENT"
            )
        }

        buttonParkUzat.setOnClickListener {

            val tarih = tarihbitEditText.text
            if (tarih.isNotEmpty()) {
                Toast.makeText(
                    this.requireContext(),
                    "Rezervasyonunuz güncellendi.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this.requireContext(),
                    "Lütfen rezervasyonunuzu uzatmak istediğiniz tarihi seçin.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ParkSureUzatFragment()
    }
}
