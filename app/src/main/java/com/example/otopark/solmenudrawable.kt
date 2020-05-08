package com.example.otopark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class solmenudrawable : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solmenudrawable)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_hesabim -> {
                Toast.makeText(this, "Hesabım", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_plakalarim -> {
                Toast.makeText(this, "Plakalarım", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_rezervasyonlarim -> {
                Toast.makeText(this, "Rezervasyonlarım", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_cuzdanim -> {
                Toast.makeText(this, "Cüzdanım", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_odeme_araclarim -> {
                Toast.makeText(this, "Ödeme Araçlarım", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}