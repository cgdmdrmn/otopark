package com.example.otopark
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class BaseActivity() : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    lateinit var profileFragment: ProfileFragment
    lateinit var anaEkranFragment: AnaEkranFragment
    lateinit var plakalarFragment: PlakalarFragment
    lateinit var rezervasyonlarFragment: RezervasyonlarFragment
    lateinit var cuzdanimFragment: CuzdanimFragment
    lateinit var odemeAraclarimFragment: OdemeAraclarimFragment
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solmenudrawable)

        setSupportActionBar(toolbar)
        val actionBar=supportActionBar
        actionBar?.title="E-Park"

        val drawerToggle:ActionBarDrawerToggle=object : ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            (R.string.open),
            (R.string.close)
        ){

        }
        drawerToggle.isDrawerIndicatorEnabled =true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navView.setNavigationItemSelectedListener (this)

        anaEkranFragment= AnaEkranFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,anaEkranFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

    }
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId){
            R.id.nav_hesabim -> {
               profileFragment=ProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,profileFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_plakalarim -> {
                plakalarFragment= PlakalarFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,plakalarFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_rezervasyonlarim -> {
                rezervasyonlarFragment= RezervasyonlarFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,rezervasyonlarFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_cuzdanim -> {
                cuzdanimFragment= CuzdanimFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,cuzdanimFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_odeme_araclarim -> {
                odemeAraclarimFragment= OdemeAraclarimFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout,odemeAraclarimFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }
}