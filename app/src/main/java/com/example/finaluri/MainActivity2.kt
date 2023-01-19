package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.finaluri.fragments.BalanceFragment
import com.example.finaluri.fragments.HomeFragment
import com.example.finaluri.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val homefragment = HomeFragment()
        val balancefragment = BalanceFragment()
        val settingsfragment = SettingsFragment()

        makeCurrentFragment(homefragment)

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homefragment)
                R.id.ic_balance -> makeCurrentFragment(balancefragment)
                R.id.ic_settings -> makeCurrentFragment(settingsfragment)
            }
            true
        }

    }
    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}