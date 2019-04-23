package com.trantordev.shopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trantordev.shopapp.feature.product.dummy.DummyContent
import com.trantordev.shopapp.feature.product.list.ProductFragment


class MainActivity : AppCompatActivity(), ProductFragment.OnListFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_camera, R.id.navigation_mail, R.id.navigation_user))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}