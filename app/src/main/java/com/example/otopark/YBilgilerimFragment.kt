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
import kotlinx.android.synthetic.main.fragment_bilgilerim.Texteskisifre
import kotlinx.android.synthetic.main.fragment_bilgilerim.Textyenisifre
import kotlinx.android.synthetic.main.fragment_bilgilerim.buttonKaydet
import kotlinx.android.synthetic.main.fragment_ybilgilerim.*

class YBilgilerimFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Bilgilerim",
            R.drawable.toolbar_hamburger_icon)
        (activity as BaseActivity).setNavViewVisibility(false)
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
            val yeskisifre = yTexteskisifre.toString()
            val yyenisifre = yTextyenisifre.toString()
            if (yeskisifre.isEmpty() && yyenisifre.isEmpty()) {
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
