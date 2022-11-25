package com.fillah.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fillah.bottomnavigation.fragment.HomeFragment
import com.fillah.bottomnavigation.fragment.NotificationFragment
import com.fillah.bottomnavigation.fragment.ProfileFragment
import com.fillah.bottomnavigation.fragment.RecycleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val recycleFragment = RecycleFragment()
    private val notificationFragment = NotificationFragment()
    private val profileFragment = ProfileFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)
        supportActionBar?.hide()

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.recycle -> replaceFragment(recycleFragment)
                R.id.notif -> replaceFragment(notificationFragment)
                R.id.profil -> replaceFragment(profileFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
        }
    }
}
