package com.example.myapplication

import com.example.myapplication.module.account.AccountFragment
import com.example.myapplication.module.basket.BasketFragment
import com.example.myapplication.module.home.HomeFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var homeFragment: HomeFragment
    lateinit var basketFragment: BasketFragment
    lateinit var accountFragment: AccountFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        basketFragment = BasketFragment()
        accountFragment = AccountFragment()

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        loadFragment(HomeFragment())
        bottomNavigationView.setOnItemSelectedListener {

            try {
                when (it.itemId) {
                    R.id.homeFragment -> {
                        loadFragment(homeFragment)
                        true
                    }
                    R.id.basketFragment -> {
                        loadFragment(basketFragment)
                        true
                    } else -> {
                    R.id.accountFragment
                    loadFragment(accountFragment)
                    true
                }
                }
            } catch (e : Exception) {
                throw e
            }
        }
    }

   private fun loadFragment(fragment: Fragment) {

       if (fragment != null) {
           val transaction = supportFragmentManager.beginTransaction()
           transaction.replace(R.id.activity_container, fragment)
           transaction.commit()
       }
   }
}