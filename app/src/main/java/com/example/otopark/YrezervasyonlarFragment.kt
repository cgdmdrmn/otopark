package com.example.otopark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_rezervasyonlar.*
import kotlinx.android.synthetic.main.fragment_yrezervasyonlar.*
import kotlinx.android.synthetic.main.fragment_yrezervasyonlar.bottom_navigation

class YrezervasyonlarFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Anasayfa",  R.drawable.logo5
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yrezervasyonlar, container, false)
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

        buttonYeniRezervasyonlar.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                YyeniRezervasyonlarFragment(),
                "YENI_REZERVASYON_FRAGMENT"
            )
        }
        buttonGecmisRezervasyonlar.setOnClickListener {
            (activity as BaseActivity).changeFragment(
                YGecmisRezervasyonlarFragment(),
                "GECMİS_REZERVASYON_FRAGMENT"
            )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = YrezervasyonlarFragment()
    }
}
