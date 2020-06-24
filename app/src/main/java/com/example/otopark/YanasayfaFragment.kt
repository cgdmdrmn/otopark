package com.example.otopark

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_y_anasayfa.*

class YanasayfaFragment : Fragment() {

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

        return inflater.inflate(R.layout.fragment_y_anasayfa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonA1.setOnClickListener{
            buttonA1.setBackgroundColor(Color.WHITE)
            (activity as BaseActivity).changeFragment(RezSecFragment(),"Rezervasyon Seç")
        }

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
    }

    companion object {
        @JvmStatic
        fun newInstance() = YanasayfaFragment()
    }
}
