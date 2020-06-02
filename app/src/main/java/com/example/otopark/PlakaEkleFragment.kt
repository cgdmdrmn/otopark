package com.example.otopark

import DrawableMenuFragments.OdemeAraclarimFragment
import DrawableMenuFragments.PlakalarFragment
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_kart_ekle.*
import kotlinx.android.synthetic.main.fragment_plaka_ekle.*
import kotlinx.android.synthetic.main.fragment_plaka_ekle.checkBox

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlakaEkleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlakaEkleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle("Plaka Ekle", R.drawable.toolbar_back_icon)
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
        return inflater.inflate(R.layout.fragment_plaka_ekle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val aracsinifi= arrayOf("1.","2.","3.","4.","5.","6.")
        val arrayAdapter= ArrayAdapter(this.requireContext(), android.R.layout.simple_spinner_item, aracsinifi)
        aracsinifiSpinner.adapter=arrayAdapter

        aracsinifiSpinner.onItemSelectedListener=object :
        AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               spinnerResult.text=aracsinifi[position]
            }
        }


        buttonPlakaEkle.setOnClickListener{

            val plaka = plakagirEditText.text
            if(plaka.isNotEmpty() && checkBox.isChecked){
                (activity as BaseActivity).createAlertDialog(
                    "Uyarı",
                    "Kart ekleme işleminiz gerçekleşti.",
                    "Tamam",
                    DialogInterface.OnClickListener { _, _ ->  (activity as BaseActivity).changeFragment(PlakaEkleFragment(),"PLAKALA_EKLE_FRAGMENT") },
                    null,
                    null
                )
            }else{
                Toast.makeText(this.requireContext(),"Lütfen boş alanları doldurun.", Toast.LENGTH_SHORT).show()
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
         * @return A new instance of fragment PlakaEkleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlakaEkleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
