package com.sedat.jetpacknavigationwithpaparauiclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.setupWithNavController
import com.sedat.jetpacknavigationwithpaparauiclone.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavController()
        navigate()

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(navController.currentDestination?.id == R.id.homeFragment){
                    finishAndRemoveTask()
                }
                navController.navigate(R.id.homeFragment, null, NavOptions.Builder()
                    .setPopUpTo(R.id.main_nav_graph, true) // Tüm fragment'leri temizle
                    .build())
            }
        })
    }

    private fun setUpNavController(){
        val navHostFragmentView = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragmentView.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun navigate(){
        binding.bottomNavigationView.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment, null, NavOptions.Builder().setPopUpTo(R.id.main_nav_graph, true).build())
                }
                R.id.paymentFragment -> {
                    navController.navigate(R.id.paymentFragment)
                }
                R.id.paparaCardFragment -> {
                    navController.navigate(R.id.paparaCardFragment)
                }
            }
            true
        }
    }
}