package com.example.otopark

import Adapter.RezSecAdapter
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

class YanasayfaFragment : Fragment(), RezSecOnClickListener  {
    private var rezsecAdapter: RezSecAdapter? = null
    private val rezsecList: MutableList<String> =
        mutableListOf("29.6.20/16:30-17:30 34 GA 1527", "30.6.20/18:30-21:00 34 CD 1993")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rezsecAdapter = RezSecAdapter(rezsecList, this)
        rezSecRecyclerView.adapter = rezsecAdapter


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


    private fun removeItem(position: Int) {
        rezsecList.removeAt(position)
        rezsecAdapter?.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {
        Toast.makeText(
            this.requireContext(),
            "Rezervasyon onayı için boş alanlardan birini seçin.",
            Toast.LENGTH_SHORT
        ).show()
        buttonA1.setOnClickListener {
            removeItem(position)
            buttonA1.setBackgroundColor(Color.YELLOW)
            Toast.makeText(
                this.requireContext(),
                "Rezervasyon onaylandı.",
                Toast.LENGTH_SHORT
            ).show()}

        buttonA3.setOnClickListener {
            removeItem(position)
            buttonA3.setBackgroundColor(Color.YELLOW)
            Toast.makeText(
                this.requireContext(),
                "Rezervasyon onaylandı.",
                Toast.LENGTH_SHORT
            ).show()}

        buttonA4.setOnClickListener {
            removeItem(position)
            buttonA4.setBackgroundColor(Color.YELLOW)
            Toast.makeText(
                this.requireContext(),
                "Rezervasyon onaylandı.",
                Toast.LENGTH_SHORT
            ).show()}

        buttonA6.setOnClickListener {
            removeItem(position)
            buttonA6.setBackgroundColor(Color.YELLOW)
            Toast.makeText(
                this.requireContext(),
                "Rezervasyon onaylandı.",
                Toast.LENGTH_SHORT
            ).show()}

        buttonC2.setOnClickListener {
            removeItem(position)
            buttonC2.setBackgroundColor(Color.YELLOW)
            Toast.makeText(
                this.requireContext(),
                "Rezervasyon onaylandı.",
                Toast.LENGTH_SHORT
            ).show()}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_y_anasayfa, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle(
            "Anasayfa",
            R.drawable.toolbar_hamburger_icon)
        (activity as BaseActivity).setNavViewVisibility(false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = YanasayfaFragment()
    }
}
