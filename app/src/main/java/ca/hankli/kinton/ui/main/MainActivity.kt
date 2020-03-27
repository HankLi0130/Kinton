package ca.hankli.kinton.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import ca.hankli.kinton.R
import ca.hankli.kinton.util.extension.visit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)

        setBottomNavMenu(navController)
    }

    private fun setBottomNavMenu(navController: NavController) {
        bottom_nav_view.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_social_media, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.visit_facebook -> {
                visit("https://www.facebook.com/kintonramen")
                true
            }
            R.id.visit_instagram -> {
                visit("https://www.instagram.com/kintonramen")
                true
            }
            R.id.visit_twitter -> {
                visit("https://twitter.com/KintonRamen")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
