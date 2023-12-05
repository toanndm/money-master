package com.example.moneymaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moneymaster.databinding.ActivityMainBinding
import com.example.moneymaster.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, HomeFragment())
        fragmentTransaction.commit()
    }
}