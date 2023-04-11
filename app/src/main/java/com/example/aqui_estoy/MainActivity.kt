package com.example.aqui_estoy


import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.aqui_estoy.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.security.AccessController


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainer)as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setupWithNavController(bottomNavigationView, navController)
    }

}