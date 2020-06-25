package com.example.otopark

import DrawableMenuFragments.*
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.hardware.input.InputManager
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
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

        val isUserAdministrator = intent.getBooleanExtra("IS_USER_ADMINISTRATOR", false)
        if (isUserAdministrator) {
            changeFragment(YanasayfaFragment(), "YAnasayfa")
        } else {
            changeFragment(AnaEkranFragment(), "anaEkranFragment")
        }
    }

    fun changeToolbarIconAndTitle(title: String, icon: Int) {
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

            R.id.nav_anasayfa -> changeFragment(AnaEkranFragment(), ANASAYFA_TAG)

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

    fun changeFragment(fragment: Fragment, tag: String) {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
            currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    fun createAlertDialog(
        title: String,
        message: String,
        positiveButtonName: String?,
        positiveButtonAction: DialogInterface.OnClickListener?,
        negativeButtonName: String?,
        negativeButtonAction: DialogInterface.OnClickListener?
    ) {
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle(title)
            setMessage(message)
            positiveButtonName?.let {
                setPositiveButton(it, positiveButtonAction)
            }

            negativeButtonName?.let {
                setNegativeButton(it, negativeButtonAction)
            }

            show()
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun setNavViewVisibility(isVisible: Boolean) {
        if (isVisible) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        } else {
            toolbar.navigationIcon = null
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
    }

    companion object {
        const val ANASAYFA_TAG = "ANASAYFA"
        const val ODEME_ARACLARIM_TAG = "ODEME_ARACLARIM"
        const val CUZDANIM_TAG = "CUZDANIM"
        const val REZERVASYONLARIM_TAG = "REZERVASYONLARIM"
        const val PLAKALARIM_TAG = "PLAKALARIM"
        const val PROFILE_TAG = "HESABIM"
    }
}