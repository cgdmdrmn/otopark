package com.example.otopark

import DrawableMenuFragments.AnaEkranFragment
import DrawableMenuFragments.OdemeAraclarimFragment
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_bilgilerim.*
import kotlinx.android.synthetic.main.fragment_kart_ekle.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BilgilerimFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BilgilerimFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle("Bilgilerim", R.drawable.toolbar_back_icon)
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
        return inflater.inflate(R.layout.fragment_bilgilerim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonKaydet.setOnClickListener {
            val eskisifre = Texteskisifre.text
            val yenisifre = Textyenisifre.text
            if(eskisifre.isNotEmpty() && yenisifre.isNotEmpty() && eskisifre != yenisifre){
                (activity as BaseActivity).createAlertDialog(
                    "Uyarı",
                    "Şifre değiştirme işleminiz başarıyla gerçekleşti.",
                    "Tamam",
                    DialogInterface.OnClickListener { _, _ ->  (activity as BaseActivity).changeFragment(BilgilerimFragment(),"BILGILERIM_FRAGMENT") },
                    null,
                    null
                )
            }else{
                Toast.makeText(this.requireContext(),"Lütfen geçerli bir şifre giriniz.", Toast.LENGTH_SHORT).show()
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
         * @return A new instance of fragment BilgilerimFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BilgilerimFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
