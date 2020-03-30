package ca.hankli.kinton.ui.main.reward

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.base.BaseFragment
import ca.hankli.kinton.util.extension.visit

class RewardFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_card

    override val hasOptionsMenu: Boolean
        get() = true

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.social_meida, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_visit_facebook -> {
                visit("https://www.facebook.com/kintonramen")
                true
            }
            R.id.action_visit_instagram -> {
                visit("https://www.instagram.com/kintonramen")
                true
            }
            R.id.action_visit_twitter -> {
                visit("https://twitter.com/KintonRamen")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}