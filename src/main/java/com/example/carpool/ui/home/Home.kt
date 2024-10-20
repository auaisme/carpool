package com.example.carpool.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.carpool.R
import com.example.carpool.ui.home.fragments.Package
import com.example.carpool.ui.home.fragments.bike
import com.example.carpool.ui.home.fragments.car
import com.example.carpool.ui.home.fragments.rikshaw
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.libraries.maps.GoogleMap
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity()/*, OnMapReadyCallback*/ {

//    private var currentMap: GoogleMap? = null
    private lateinit var navview:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("name")
        val phoneNumber = intent.getStringExtra("phoneNumber")
//        findViewById<TextView>(R.id.labelName).text = name
//        findViewById<TextView>(R.id.labelPhoneNumber).text = phoneNumber

//        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_current_location) as SupportMapFragment
//        mapFragment.getMapAsync(this)

        navview = findViewById(R.id.nav_view)
        navview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.book_car -> replaceFragment(car())
                R.id.book_rikshaw -> replaceFragment(rikshaw())
                R.id.book_bike -> replaceFragment(bike())
                R.id.book_package -> replaceFragment(Package())
            }
            true
        }
    }

//    override fun onMapReady(googleMap: GoogleMap) {
//        currentMap = googleMap
//    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host,fragment)
        transaction.commit()
    }
}