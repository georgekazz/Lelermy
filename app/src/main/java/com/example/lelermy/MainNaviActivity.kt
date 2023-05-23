package com.example.lelermy

import android.os.Bundle
import android.widget.TextView
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

class MainNaviActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMainNavi.toolbar)

       // val tipsTx = findViewById<TextView>(R.id.tipsTx)

        //tethorakismena-peziko-puroboliko-mixaniko-diabibasis-aeroporia-efodiasmou-elegktikou-ereunas pliroforikis-
        //  val leveltwoTx = findViewById<TextView>(R.id.levelTwoText)

        binding.appBarMainNavi.fab.setOnClickListener { view ->
            Snackbar.make(view, "Η προσθήκη ολοκληρώθηκε με επιτυχία", Snackbar.LENGTH_LONG)
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