package com.example.lelermy

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.lelermy.databinding.ActivityMainNaviBinding
import java.time.Duration
import java.time.LocalDate
import java.util.Calendar

class MainNaviActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainNaviBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMainNavi.toolbar)

        //get calendar values
        val sharedPref = getSharedPreferences("secondCalendar", Context.MODE_PRIVATE)
        val sharedPref1 = getSharedPreferences("firstCalendar", Context.MODE_PRIVATE)
        val firstCalendar = sharedPref1.getString("firstCalendar", null)
        val secondCalendar = sharedPref.getString("secondCalendar", null)

        System.out.println("Take the first day:$firstCalendar")
        System.out.println("Take the second day:$secondCalendar")

        val startDate = LocalDate.parse(firstCalendar)
        val endDate = LocalDate.parse(secondCalendar)

        val duration = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay())
        val days = duration.toDays()

        val daysLeftTx = findViewById<TextView>(R.id.daysLeftTx)
        daysLeftTx.text = days.toString()

        System.out.println("To ypoloipo einai: $days")

        binding.appBarMainNavi.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main_navi)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main_navi)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}