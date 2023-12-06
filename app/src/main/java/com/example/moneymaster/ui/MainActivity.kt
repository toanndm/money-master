package com.example.moneymaster.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.moneymaster.R
import com.example.moneymaster.databinding.ActivityMainBinding
import com.example.moneymaster.ui.fragment.HomeFragment
import com.example.moneymaster.ui.fragment.ProfileFragment
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNav()

    }

    private fun setUpBottomNav() {
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
        navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)
        binding.bottomNavigationView.setOnItemReselectedListener { /* NO-OP */ }
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment, R.id.profileFragment, R.id.transactionFragment, R.id.statisticsFragment
                -> binding.bottomNavigationView.visibility = View.VISIBLE
                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }
    }
}