package ca.hankli.kinton.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ca.hankli.kinton.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val topLevelDestinations = setOf(R.id.menu_dest, R.id.reward_dest)

        appBarConfig = AppBarConfiguration(topLevelDestinations)

        val navController = getNavController().apply {
            addOnDestinationChangedListener { _, destination, _ ->
                view_bottom_nav.isVisible = topLevelDestinations.contains(destination.id)
            }
        }

        setupActionBar(navController)
        setupBottomNavMenu(navController)
    }

    private fun getNavController(): NavController {
        return findNavController(R.id.nav_host_fragment)
    }

    private fun setupActionBar(navController: NavController) {
        setupActionBarWithNavController(navController, appBarConfig)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        view_bottom_nav.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return getNavController().navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }
}
