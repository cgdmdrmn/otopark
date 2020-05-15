package com.example.otopark

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.loginapp.LoginFragment
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val pagerAdapter =
            AuthenticationPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragmet(LoginFragment())
        pagerAdapter.addFragmet(RegisterFragment())
        viewPager.adapter = pagerAdapter
    }

    internal class AuthenticationPagerAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        private val fragmentList = ArrayList<Fragment>()
        override fun getItem(i: Int): Fragment {
            return fragmentList[i]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragmet(fragment: Fragment) {
            fragmentList.add(fragment)
        }
    }

}
