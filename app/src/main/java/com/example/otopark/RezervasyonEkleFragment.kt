package com.example.otopark

import DrawableMenuFragments.PlakalarFragment
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_kart_ekle.*
import kotlinx.android.synthetic.main.fragment_plaka_ekle.*
import kotlinx.android.synthetic.main.fragment_rezervasyon_ekle.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RezervasyonEkleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RezervasyonEkleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Rezervasyon Ekle",
            R.drawable.toolbar_back_icon
        )
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rezervasyon_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        dateBtn.setOnClickListener {
            val dpd = DatePickerDialog(
                this.requireContext(),
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    tarihbasEditText.setText("" + mDay + "/" + mMonth + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
        }

        dateBitBtn.setOnClickListener {
            val dpd1 = DatePickerDialog(
                this.requireContext(),
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    tarihbasEditText.setText("" + mDay + "/" + mMonth + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd1.show()
        }

        val rezbassaat = arrayOf(
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
        val arrayAdapter =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, rezbassaat)
        rezbassaatspinner.adapter = arrayAdapter
        rezbassaatspinner.onItemSelectedListener = object :
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
        val arrayAdapter1 =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, rezbitsaat)
        rezbitsaatspinner.adapter = arrayAdapter1
        rezbitsaatspinner.onItemSelectedListener = object :
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

        val plakalar = arrayOf("34 GA 1527", "34 CD 1993", "34 HK 2020")
        val arrayAdapter2 =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, plakalar)
        plakasecspinner.adapter = arrayAdapter2
        plakasecspinner.onItemSelectedListener = object :
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

        val odemearaclar =
            arrayOf("4926 **** **** **11", "1527 **** **** **89", "2222 **** **** **15")
        val arrayAdapter3 =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, odemearaclar)
        odemearacisecspinner.adapter = arrayAdapter3
        odemearacisecspinner.onItemSelectedListener = object :
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

        aracekleTextView.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                PlakaEkleFragment(), "PLAKA_EKLE_FRAGMENT"
            )
        }

        yeniKartEkleTextView.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                KartEkleFragment(), "KART_EKLE_FRAGMENT"
            )
        }

        rezYapButton.setOnClickListener{
        val bastarih = tarihbasEditText.text
        val bittarih = tarihbitEditText.text
        val otopark = otoparkAraEditText.text

        if (bastarih.isNotEmpty() && bittarih.isNotEmpty() && otopark.isNotEmpty()) {
            (activity as BaseActivity).createAlertDialog(
                "Uyarı",
                "Rezervasyonunuz başarıyla oluşturuldu.",
                "Tamam",
                DialogInterface.OnClickListener { _, _ ->
                    (activity as BaseActivity).changeFragment(
                        RezervasyonEkleFragment(), "REZERVASYONLAR_FRAGMENT"
                    )
                },
                null,
                null
            )
        } else {
            Toast.makeText(
                this.requireContext(),
                "Lütfen boş alanları doldurunuz.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RezervasyonEkleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RezervasyonEkleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
