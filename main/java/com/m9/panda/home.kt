package com.m9.panda

import com.m9.panda.Fragments.Settings
import com.m9.panda.Fragments.cart
import com.m9.panda.Fragments.profile
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.m9.panda.Fragments.fragmentHome

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu);
        loadFragment(fragmentHome())
        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_cart -> {
                    loadFragment(cart())
                    true
                }
                R.id.nav_settings -> {
                    loadFragment(Settings())
                    true
                }
                R.id.nav_user -> {
                    loadFragment(profile())
                    true

                }
                R.id.nav_home -> {
                    loadFragment(fragmentHome())
                    true
                }
                else -> {false}
            }
        }

    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}