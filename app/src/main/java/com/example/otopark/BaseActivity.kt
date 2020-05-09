package com.example.otopark

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

open class BaseActivity() : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "E-Park"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            (R.string.open),
            (R.string.close)
        ) {

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, AnaEkranFragment(), "anaEkranFragment")
            .commit()

    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_hesabim -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, ProfileFragment(), "profileFragment")
                    .commit()
            }

            R.id.nav_plakalarim -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, PlakalarFragment(), "plakalarFragment")
                    .commit()
            }

            R.id.nav_rezervasyonlarim -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, RezervasyonlarFragment(), "rezervasyonlarFragment")
                    .commit()
            }
            R.id.nav_cuzdanim -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, CuzdanimFragment(), " cuzdanimFragment")
                    .commit()
            }
            R.id.nav_odeme_araclarim -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, OdemeAraclarimFragment(), " odemeAraclarimFragment")
                    .commit()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}