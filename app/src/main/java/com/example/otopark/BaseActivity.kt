package com.example.otopark

import DrawableMenuFragments.*
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

open class BaseActivity() : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    lateinit var drawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        setSupportActionBar(toolbar)

        initializeDrawableToggle()
        navView.setNavigationItemSelectedListener(this)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, AnaEkranFragment(), "anaEkranFragment")
            .commit()

    }

    fun changeToolbarIconAndTitle(title:String,icon:Int){
        supportActionBar?.title = title
        drawerToggle.setHomeAsUpIndicator(icon)
    }

    private fun initializeDrawableToggle() {
            drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            (R.string.open),
            (R.string.close)
        )
        drawerToggle.isDrawerIndicatorEnabled = false
        drawerToggle.setHomeAsUpIndicator(R.drawable.toolbar_hamburger_icon)
        drawerToggle.setToolbarNavigationClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }

        }
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_hesabim -> changeFragment(ProfileFragment(), PROFILE_TAG)

            R.id.nav_plakalarim -> changeFragment(PlakalarFragment(), PLAKALARIM_TAG)

            R.id.nav_rezervasyonlarim -> changeFragment(
                RezervasyonlarFragment(), REZERVASYONLARIM_TAG
            )
            R.id.nav_cuzdanim -> changeFragment(CuzdanimFragment(), CUZDANIM_TAG)

            R.id.nav_odeme_araclarim -> changeFragment(
                OdemeAraclarimFragment(), ODEME_ARACLARIM_TAG
            )
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment, tag)
            .commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        const val ODEME_ARACLARIM_TAG = "ODEME_ARACLARIM"
        const val CUZDANIM_TAG = "CUZDANIM"
        const val REZERVASYONLARIM_TAG = "REZERVASYONLARIM"
        const val PLAKALARIM_TAG = "PLAKALARIM"
        const val PROFILE_TAG = "HESABIM"
    }
}