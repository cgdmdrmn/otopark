package com.example.otopark

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginapp.LoginFragment
import kotlinx.android.synthetic.main.fragment_yhesabim.*
import kotlinx.android.synthetic.main.fragment_yhesabim.bottom_navigation

class YhesabimFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Hesabım",
            R.drawable.toolbar_hamburger_icon)
        (activity as BaseActivity).setNavViewVisibility(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yhesabim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_anasayfa-> {
                    (activity as BaseActivity).changeFragment(YanasayfaFragment(), "Anasayfa")
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_hesabim-> {
                    (activity as BaseActivity).changeFragment(YhesabimFragment(), "Hesabım")
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.nav_rezervasyonlar-> {
                    (activity as BaseActivity).changeFragment(YrezervasyonlarFragment(), "Rezervasyonlar")
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }

        buttonKullaniciBilgileri.setOnClickListener {
            (activity as BaseActivity).changeFragment(YBilgilerimFragment(), "BILGILERIM_FRAGMENT")
        }
        buttonOtoparkBilgileri.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                YotoparkBilgilerimFragment(),
                "OTOPARK_BILGILERI_FRAGMENT"
            )
        }

        buttonCikis.setOnClickListener {

            val builder = AlertDialog.Builder(this.requireContext())
            builder.setTitle("Çıkış")
            builder.setMessage("Çıkış yapmak istediğinize emin misiniz?")
            builder.setCancelable(false)
            builder.setPositiveButton("Evet", { dialog: DialogInterface?, which: Int ->
                (activity as BaseActivity).changeFragment(
                    LoginFragment(),
                    "LOGIN_FRAGMENT"
                )
            })
            builder.setNegativeButton("Hayır", { dialog: DialogInterface?, which: Int ->

                (activity as BaseActivity).changeFragment(
                    YhesabimFragment(),
                    "HESABIM_FRAGMENT"
                )
            })
            builder.show()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = YhesabimFragment()
    }
}
