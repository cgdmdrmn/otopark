package com.example.otopark

import DrawableMenuFragments.OdemeAraclarimFragment
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
import kotlinx.android.synthetic.main.fragment_kart_ekle.*
import kotlinx.android.synthetic.main.fragment_rezervasyon_ekle.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KartDuzenleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KartDuzenleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Kart Düzenle",
            R.drawable.toolbar_hamburger_icon
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
        return inflater.inflate(R.layout.fragment_kart_duzenle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        kaydetButton.setOnClickListener {

            val kartno = kartnoEditText.text
            val ay = ayEditText.text
            val yil = yilEditText.text
            val ccv = editText3.text

            if (kartno.isNotEmpty() && ay.isNotEmpty() && yil.isNotEmpty() && ccv.isNotEmpty() && checkBox.isChecked) {
                (activity as BaseActivity).createAlertDialog(
                    "Uyarı",
                    "Değişiklikleriniz kaydedildi.",
                    "Tamam",
                    DialogInterface.OnClickListener { _, _ ->
                        (activity as BaseActivity).changeFragment(
                            KartDuzenleFragment(), "KART_DUZENLE_FRAGMENT"
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KartDuzenleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KartDuzenleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
