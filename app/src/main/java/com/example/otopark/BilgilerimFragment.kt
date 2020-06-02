package com.example.otopark

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_bilgilerim.*

class BilgilerimFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Bilgilerim",
            R.drawable.toolbar_hamburger_icon
        )
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
            if (eskisifre.isNotEmpty() && yenisifre.isNotEmpty() && eskisifre != yenisifre) {
                (activity as BaseActivity).createAlertDialog(
                    "Uyarı",
                    "Şifre değiştirme işleminiz başarıyla gerçekleşti.",
                    "Tamam",
                    DialogInterface.OnClickListener { _, _ ->
                        (activity as BaseActivity).changeFragment(
                            BilgilerimFragment(),
                            "BILGILERIM_FRAGMENT"
                        )
                    },
                    null,
                    null
                )
            } else {
                Toast.makeText(
                    this.requireContext(),
                    "Lütfen geçerli bir şifre giriniz.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BilgilerimFragment()
    }
}
