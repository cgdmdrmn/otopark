package com.example.otopark

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_bilgilerim.*

class YBilgilerimFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Bilgilerim",
            R.drawable.toolbar_hamburger_icon)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ybilgilerim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonKaydet.setOnClickListener {
            val eskisifre = Texteskisifre.text
            val yenisifre = Textyenisifre.text
            if (eskisifre.isNotEmpty() && yenisifre.isNotEmpty() && eskisifre != yenisifre) {
                Toast.makeText(
                    this.requireContext(),
                    "Şifreniz güncellendi.",
                    Toast.LENGTH_SHORT
                ).show()
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
        fun newInstance() = YBilgilerimFragment()
    }
}
