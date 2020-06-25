package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.otopark.*
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        inflater.inflate(R.layout.fragment_login, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            val kullanici = et_email.text.toString()
            val sifre = et_password.text.toString()
            if (kullanici == "1" && sifre == "1") {
                context?.startActivity(
                    Intent(
                        context,
                        BaseActivity::class.java
                    )
                )
            } else if (kullanici == "2" && sifre == "2") {
                (activity as BaseActivity).changeFragment(
                    YanasayfaFragment(), "ANASAYFA"
                )
            } else if (kullanici.isEmpty() && sifre.isEmpty()) {
                Toast.makeText(
                    this.requireContext(),
                    "Boş alanları doldurunuz!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                Toast.makeText(
                    this.requireContext(),
                    "Giriş bilgileri hatalı !",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

            btn_frgt.setOnClickListener {
                context?.startActivity(
                    Intent(
                        context,
                        ForgetPassword::class.java
                    )
                )
            }
        }
    }



